package com.apptive.japkor.ui.requiredinfo.steps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.step4.PhotoUploadGrid
import com.apptive.japkor.ui.theme.CustomColor

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
        Spacer(modifier = Modifier.height(5.dp))

        PhotoUploadGrid()



        CustomText(
            text = "- 사진은 프로필에서 가장 중요한 요소입니다.",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
            modifier = Modifier.padding(horizontal = 7.dp),
            size = 14.sp
        )

        CustomText(
            text = "- 얼굴 정면이 잘 보이는 사진으로 최소 2장 이상 올려주세요.",
            color = CustomColor.gray400,
            type = CustomTextType.bodyLarge,
            modifier = Modifier.padding(horizontal = 7.dp),
            size = 14.sp
        )

        CustomText(
            text = "- 과도한 포토샵/스티커, 마스크로 가린 사진, 똑같은 사진 2장 등 가이드에 벗어나는 사진은 가입이 거절될 수 있습니다.",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
            modifier = Modifier.padding(horizontal = 7.dp),
            size = 14.sp
        )


        CustomText(
            text = "프로필 사진 가이드 보기",
            color = CustomColor.gray300,
            type = CustomTextType.bodyLarge,
            underline = true,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 14.dp)
                .clickable(
                    role = Role.Button,
                    onClick = { /* TODO: 사진 가이드 보기 */ }
                ),
            size = 14.sp
        )
    }
}

// 3열 그리드 (간격/패딩/정사각형 유지)


// 카드 1칸 (화이트 카드 + 소프트 섀도우 + 중앙 원형 + 아이콘)
