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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apptive.japkor.R
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.StepIndicator
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
        StepIndicator(currentStep = currentStep.value)
        Spacer(modifier = Modifier.height(24.dp))

        // Step에 따른 Body UI
        when (currentStep.value) {
            1 -> Step1Content(selectedOption = selectedOption)
            2 -> Step2Content()
            3 -> Step3Content()
            4 -> Step4Content()
        }

        // 하단 버튼
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
                shape = RoundedCornerShape(10.dp)
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
                    shape = RoundedCornerShape(10.dp)
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
                        if (currentStep.value < 4) {
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
                    shape = RoundedCornerShape(10.dp)
                ) {
                    CustomText(
                        text = if (currentStep.value < 4) "다음" else "완료",
                        type = CustomTextType.bodyLarge,
                        color = Color.Black
                    )
                }
            }
        }

    }
}

@Composable
fun Step1Content(selectedOption: androidx.compose.runtime.MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomText(
            text = "성별을 설정해주세요",
            type = CustomTextType.mainRegularLarge,
            size = 32.sp
        )
        CustomText(
            text = "한국인 남성, 일본인 여성 중 선택가능합니다.",
            color = CustomColor.gray400,
            type = CustomTextType.mainRegularSmall,
        )
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CustomText(
                text = "저는",
                color = CustomColor.gray400,
                type = CustomTextType.mainRegularSmall,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                listOf("한국 남성", "일본 여성").forEach { option ->
                    val isSelected = selectedOption.value == option
                    Button(
                        onClick = { selectedOption.value = option },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) CustomColor.gray300 else CustomColor.gray100
                        ),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        CustomText(
                            text = option,
                            color = if (isSelected) Color.White else CustomColor.black,
                            type = CustomTextType.mainRegularSmall,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            CustomText(
                text = "입니다.",
                color = CustomColor.gray400,
                type = CustomTextType.mainRegularSmall,
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        val selectedText = if (selectedOption.value == "한국 남성") {
            "'한국 남성'를 선택하셨습니다.\n\n'한국 남성'를 선택하는 경우,\n'일본 여성'에게 프로필이 먼저 전달됩니다."
        } else {
            "'일본 여성'를 선택하셨습니다.\n\n'일본 여성'를 선택하는 경우,\n'한국 남성'에게 프로필이 먼저 전달됩니다."
        }
        CustomText(
            text = selectedText,
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun Step2Content() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomText(
            text = "필수정보입력",
            type = CustomTextType.mainRegularLarge,
            size = 32.sp
        )
        CustomText(
            text = "클릭하여 각 항목에 정보를 입력해주세요.",
            color = CustomColor.gray400,
            type = CustomTextType.mainRegularSmall,
        )
        Spacer(modifier = Modifier.height(50.dp))

        // 나이 입력 UI 구현 (예시)
        CustomText(
            text = "Step 2: 화면",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
fun Step3Content() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomText(
            text = "선택사항",
            type = CustomTextType.mainRegularLarge,
            size = 32.sp
        )
        CustomText(
            text = "클릭하여 각 항목에 정보를 입력해주세요.",
            color = CustomColor.gray400,
            type = CustomTextType.mainRegularSmall,
        )
        Spacer(modifier = Modifier.height(50.dp))

        // 프로필 사진 등록 UI 구현 (예시)
        CustomText(
            text = "Step 3: 화면",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
fun Step4Content() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomText(
            text = "프로필사진",
            type = CustomTextType.mainRegularLarge,
            size = 32.sp
        )
        CustomText(
            text = "클릭하여 얼굴이 보이는 사진을 첨부해주세요.",
            color = CustomColor.gray400,
            type = CustomTextType.mainRegularSmall,
        )
        Spacer(modifier = Modifier.height(50.dp))

        // 자기소개 작성 UI 구현 (예시)
        CustomText(
            text = "Step 4: 화면",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}
