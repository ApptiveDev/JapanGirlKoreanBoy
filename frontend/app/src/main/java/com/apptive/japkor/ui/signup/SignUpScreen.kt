package com.apptive.japkor.ui.signup

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apptive.japkor.R
import com.apptive.japkor.data.api.apiService
import com.apptive.japkor.data.model.SignUpRequest
import com.apptive.japkor.ui.components.CustomOutlinedTextField
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.CustomToast
import com.apptive.japkor.ui.theme.CustomColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(scrollState)
                .padding(WindowInsets.safeDrawing.asPaddingValues()),
            horizontalAlignment = Alignment.Start
        ) {
            // 헤더: 좌측 상단 뒤로가기 아이콘 + 구분선 + 언어 선택
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "뒤로가기",
                        modifier = Modifier.width(20.dp)
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    thickness = 1.dp,
                    color = CustomColor.gray200
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CustomText(
                        text = "한국어",
                        type = CustomTextType.bodyLarge,
                        color = CustomColor.gray300,
                        underline = true
                    )
                }
            }

            // 본문 영역
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomText(
                    text = "회원가입",
                    type = CustomTextType.mainRegularLarge,
                    size = 32.sp
                )
                CustomText(
                    text = "당신의 인연을 잇는 소개팅 어플 '앤'에 가입하세요\n",
                    color = CustomColor.gray400,
                    type = CustomTextType.mainRegularSmall,
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    CustomOutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = "이름을 입력하세요"
                    )

                    CustomOutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = "이메일을 입력하세요"
                    )

                    CustomOutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "비밀번호를 입력하세요",
                        isPassword = true
                    )

                    Button(
                        onClick = {
                            // 입력값 검증
                            if (name.isBlank() || email.isBlank() || password.isBlank()) {
                                CustomToast.show(context, "모든 필드를 입력해주세요.")
                                return@Button
                            }

                            // 회원가입 API 호출
                            val signUpRequest =
                                SignUpRequest(name = name, email = email, password = password)
                            Log.d("SignUpScreen", "회원가입 시도 - 이름: $name, 이메일: $email")

                            apiService.signUp(signUpRequest)
                                .enqueue(object : Callback<Void> {
                                    override fun onResponse(
                                        call: Call<Void>,
                                        response: Response<Void>
                                    ) {
                                        val statusCode = response.code()
                                        Log.d("SignUpScreen", "회원가입 응답 상태코드: $statusCode")

                                        if (response.isSuccessful) {
                                            Log.d(
                                                "SignUpScreen",
                                                "회원가입 성공"
                                            )

                                            CustomToast.show(
                                                context,
                                                "회원가입 성공!"
                                            )

                                            // 로그인 화면으로 이동
                                            navController.popBackStack()
                                        } else {
                                            val errorMsg = when (statusCode) {
                                                400 -> "잘못된 요청입니다. (400)"
                                                409 -> "이미 존재하는 이메일입니다. (409)"
                                                500 -> "서버 오류가 발생했습니다. (500)"
                                                else -> "회원가입에 실패했습니다. ($statusCode)"
                                            }
                                            Log.e(
                                                "SignUpScreen",
                                                "회원가입 실패 - 상태코드: $statusCode, 메시지: $errorMsg"
                                            )
                                            CustomToast.showLong(context, errorMsg)
                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<Void>,
                                        t: Throwable
                                    ) {
                                        val errorMsg = "네트워크 오류: ${t.message}"
                                        Log.e("SignUpScreen", errorMsg, t)
                                        CustomToast.showLong(context, "네트워크 연결을 확인해주세요.")
                                    }
                                })
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CustomColor.gray300
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        CustomText(
                            text = "회원가입",
                            type = CustomTextType.bodyLarge,
                            color = Color.Black
                        )
                    }
                }
            }

            // 키보드가 열릴 때 충분한 공간 확보
            Spacer(modifier = Modifier.height(200.dp))
        }
    }
}
