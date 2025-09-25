package com.apptive.japkor.ui.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apptive.japkor.R
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.auth.GoogleSignUpButton
import com.apptive.japkor.ui.theme.CustomColor


@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        horizontalAlignment = Alignment.Start
    ) {
        // 헤더: 좌측 상단 뒤로가기 아이콘 + 구분선 + 언어 선택
        Column(
            modifier = Modifier
                .fillMaxWidth(),
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
                text = "어서오세요\nen 입니다",
                type = CustomTextType.mainRegularSmall,
                size = 32.sp
            )
            CustomText(
                text = "당신의 인연을 잇는 소개팅 어플 ‘앤’ 입니다\n",
                color = CustomColor.gray400,
                type = CustomTextType.mainRegularSmall,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                androidx.compose.material3.OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            color = CustomColor.gray100,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    shape = RoundedCornerShape(10.dp),

                    placeholder = {
                        CustomText(
                            text = "아이디를 입력하세요",
                            type = CustomTextType.bodyMedium,
                            color = CustomColor.gray300
                        )

                    }
                )

                androidx.compose.material3.OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            color = CustomColor.gray100,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    shape = RoundedCornerShape(10.dp),
                    placeholder = {
                        CustomText(
                            text = "비밀번호를 입력하세요",
                            type = CustomTextType.bodyMedium,
                            color = CustomColor.gray300
                        )

                    },
                    visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
                )
                Button(
                    onClick = { /* TODO: 로그인 처리 */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CustomColor.gray300
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    CustomText(
                        text = "로그인",
                        type = CustomTextType.bodyLarge,
                        color = Color.Black
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomText(
                        text = "아이디 찾기",
                        type = CustomTextType.bodyMedium,
                        color = CustomColor.black,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CustomText(
                        text = " | ",
                        type = CustomTextType.bodyMedium,
                        color = CustomColor.gray300,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CustomText(
                        text = "비밀번호 찾기",
                        type = CustomTextType.bodyMedium,
                        color = CustomColor.black,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CustomText(
                        text = " | ",
                        type = CustomTextType.bodyMedium,
                        color = CustomColor.gray300,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CustomText(
                        text = "회원가입",
                        type = CustomTextType.bodyMedium,
                        color = CustomColor.black,
                    )
                }

            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    color = CustomColor.gray300,
                    thickness = 1.dp
                )
                Spacer(modifier = Modifier.width(10.dp))
                CustomText(
                    text = "SNS 계정으로 로그인",
                    type = CustomTextType.bodyMedium,
                    color = CustomColor.gray300,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(10.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    color = CustomColor.gray300,
                    thickness = 1.dp
                )
            }
            Spacer(modifier = Modifier.height(1.dp))
            Row {
                GoogleSignUpButton(
                    onSignedIn = {
                        android.util.Log.d("LoginScreen", "onSignedIn 콜백 호출됨")
                        navController.navigate("requiredinfo")
                    },
                )
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = { /* TODO: 원하는 동작 추가 */ },
                    modifier = Modifier
                        .size(30.dp) // 버튼 크기 크게
                        .border(
                            width = 1.dp,
                            color = CustomColor.gray200,
                            shape = CircleShape
                        )
                        .background(color = CustomColor.white),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(1.dp) // 내부 패딩 제거
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = "Google Logo",
                        tint = CustomColor.gray400,
                        modifier = Modifier.size(20.dp) // 아이콘 크게
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = { /* TODO: 원하는 동작 추가 */ },
                    modifier = Modifier
                        .size(30.dp) // 버튼 크기 크게
                        .border(
                            width = 1.dp,
                            color = CustomColor.gray200,
                            shape = CircleShape
                        )
                        .background(color = CustomColor.white),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(1.dp) // 내부 패딩 제거
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_twitter),
                        contentDescription = "Google Logo",
                        tint = CustomColor.gray400,
                        modifier = Modifier.size(20.dp) // 아이콘 크게
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Button(
                    onClick = { /* TODO: 원하는 동작 추가 */ },
                    modifier = Modifier
                        .size(30.dp) // 버튼 크기 크게
                        .border(
                            width = 1.dp,
                            color = CustomColor.gray200,
                            shape = CircleShape
                        )
                        .background(color = CustomColor.white),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(1.dp) // 내부 패딩 제거
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = "Google Logo",
                        tint = CustomColor.gray400,
                        modifier = Modifier.size(20.dp) // 아이콘 크게
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomText(
                    text = "이용약관",
                    type = CustomTextType.bodyMedium,
                    color = CustomColor.black,
                )
                Spacer(modifier = Modifier.width(16.dp))
                CustomText(
                    text = " | ",
                    type = CustomTextType.bodyMedium,
                    color = CustomColor.gray300,
                )
                Spacer(modifier = Modifier.width(16.dp))
                CustomText(
                    text = "개인정보 보호정책",
                    type = CustomTextType.bodyMedium,
                    color = CustomColor.black,
                )
            }
            
        }
    }

}
