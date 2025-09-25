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
    currentStep: Int = 1
) {

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

        StepIndicator(currentStep = currentStep)
        Spacer(modifier = Modifier.height(24.dp))

        var selectedOption = remember { mutableStateOf("한국인 남성") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomText(
                text = "설정해주세요",
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
                        androidx.compose.material3.Button(
                            onClick = { selectedOption.value = option },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
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
        }


    }
}
