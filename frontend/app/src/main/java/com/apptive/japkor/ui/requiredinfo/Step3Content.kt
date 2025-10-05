package com.apptive.japkor.ui.requiredinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        CustomText(
            text = "Step 3: 화면",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}
