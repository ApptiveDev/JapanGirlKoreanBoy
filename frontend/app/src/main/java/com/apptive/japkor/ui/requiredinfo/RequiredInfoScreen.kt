package com.apptive.japkor.ui.requiredinfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apptive.japkor.R
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.StepIndicator
import com.apptive.japkor.ui.requiredinfo.steps.Step1Content
import com.apptive.japkor.ui.requiredinfo.steps.Step2Content
import com.apptive.japkor.ui.requiredinfo.steps.Step3Content
import com.apptive.japkor.ui.requiredinfo.steps.Step4Content
import com.apptive.japkor.ui.requiredinfo.steps.Step5Content
import com.apptive.japkor.ui.theme.CustomColor

@Composable
fun RequiredInfoScreen(
    navController: NavController,
    onSubmit: (name: String, email: String) -> Unit = { _, _ -> },
    initialStep: Int = 1
) {
    val selectedOption = remember { mutableStateOf("한국 남성") }
    val currentStep = remember { mutableStateOf(initialStep) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        horizontalAlignment = Alignment.Start
    ) {
        // 상단 뒤로가기
        Spacer(modifier = Modifier.height(30.dp))
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
                )
            }
        }

        // 스텝 인디케이터 (4단계, 높이 3dp)
        StepIndicator(currentStep = currentStep.value, totalSteps = 5)
        Spacer(modifier = Modifier.height(24.dp))

        // Step에 따른 Body UI
        when (currentStep.value) {
            1 -> Step1Content(selectedOption = selectedOption)
            2 -> Step2Content()
            3 -> Step3Content()
            4 -> Step4Content()
            5 -> Step5Content()
        }

        // 하단 버튼
        Spacer(modifier = Modifier.weight(1f)) // Pushes the buttons to the bottom
        if (currentStep.value == 1) {
            // Step 1: 다음 버튼만
            Button(
                onClick = {
                    currentStep.value += 1
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomColor.gray300
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                CustomText(
                    text = "다음",
                    type = CustomTextType.bodyLarge,
                    color = Color.Black
                )
            }
        } else {
            // Step 2, 3, 4: 이전, 다음/완료 버튼
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 이전 버튼
                Button(
                    onClick = {
                        currentStep.value -= 1
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CustomColor.gray100
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    CustomText(
                        text = "이전",
                        type = CustomTextType.bodyLarge,
                        color = CustomColor.black
                    )
                }

                // 다음/완료 버튼
                Button(
                    onClick = {
                        if (currentStep.value < 5) {
                            currentStep.value += 1
                        } else {
                            // 마지막 단계에서 완료 처리
                            navController.navigate("language") // 다음 화면으로 이동
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CustomColor.gray300
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    CustomText(
                        text = if (currentStep.value < 5) "다음" else "완료",
                        type = CustomTextType.bodyLarge,
                        color = Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.navigationBarsPadding())

    }
}
