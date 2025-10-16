package com.apptive.japkor.ui.requiredinfo.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.japkor.ui.components.CustomOutlinedTextField
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.theme.CustomColor


@Composable
fun Step2Content() {
    val placeholders = listOf("*키/ 몸무게", "*거주 지역", "*흡연 유/무", "*음주 빈도", "*종교")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .imePadding(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomText(
            text = "필수정보입력",
            type = CustomTextType.mainRegular,
            size = 32.sp
        )
        CustomText(
            text = "클릭하여 각 항목에 정보를 입력해주세요.",
            color = CustomColor.gray400,
            type = CustomTextType.mainRegular,
        )
        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            CustomText(
                text = "*필수 항목",
                type = CustomTextType.body,
                color = CustomColor.gray300
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            placeholders.forEach { placeholder ->
                CustomOutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = placeholder
                )
            }

        }

        CustomText(
            text = "거짓 정보 입력 시 서비스 이용이 제한될 수 있습니다.",
            color = CustomColor.gray300,
            type = CustomTextType.body,
            modifier = Modifier.padding(horizontal = 7.dp),
            size = 14.sp
        )

    }
}
