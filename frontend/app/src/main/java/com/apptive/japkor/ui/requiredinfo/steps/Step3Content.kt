package com.apptive.japkor.ui.requiredinfo.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CustomOutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = "학력(인증)"
            )
            CustomOutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = "재산(인증)"
            )
            CustomOutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = "기타정보"
            )

        }

        CustomText(
            text = "'학력' 및 '재산' 정보는 선택 입력 사항입니다.\n입력시, 더 빠르고 정확한 매칭에 도움을 줄 수 있습니다.",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
            modifier = Modifier.padding(horizontal = 7.dp)
        )
    }
}
