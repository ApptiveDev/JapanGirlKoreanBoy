package com.apptive.japkor.ui.requiredinfo.steps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.theme.CustomColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Step5Content() {
    val personalityList = listOf(
        "열정적인", "개성있는", "차분한", "낙천적인", "유머있는", "섬세한", "지적인", "듬직한", "외향적인", "내향적인"
    )
    val visualList = listOf(
        "손이 예쁜 사람",
        "예의 바른 사람",
        "운동 좋아하는 사람",
        "책 읽는 사람",
        "음악 좋아하는 사람",
        "요리 잘하는 사람",
        "패션 센스 있는 사람",
        "애교 많은 사람",
        "대화 잘 통하는 사람",
        "취미 생활이 다양한 사람"
    )
    val dateStyleList = listOf(
        "산책 데이트",
        "카페 데이트",
        "영화관 데이트",
        "집 데이트",
        "여행 데이트",
        "운동 데이트",
        "전시회 데이트",
        "음악 감상 데이트",
        "맛집 탐방 데이트",
        "드라이브 데이트"
    )
    var selectedvisuals by remember { mutableStateOf(setOf<String>()) }
    var selectedPersonalities by remember { mutableStateOf(setOf<String>()) }
    var selectedDateStyles by remember { mutableStateOf(setOf<String>()) }
    val personalityMax = 3
    val visualMax = 5
    val dateStyleMax = 5
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = "나의 성격",
                type = CustomTextType.mainBold,
                size = 16.sp
            )
            CustomText(
                text = "(3개 이하)",
                type = CustomTextType.mainBold,
                size = 14.sp,
                color = CustomColor.gray300
            )
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            personalityList.forEach { personality ->
                val isSelected = selectedPersonalities.contains(personality)
                val buttonContainerColor =
                    if (isSelected) CustomColor.gray300 else CustomColor.gray100
                val buttonContentColor = if (isSelected) CustomColor.black else CustomColor.gray400
                Surface(
                    onClick = {
                        selectedPersonalities = if (isSelected) {
                            selectedPersonalities - personality
                        } else {
                            if (selectedPersonalities.size < personalityMax) selectedPersonalities + personality else selectedPersonalities
                        }
                    },
                    color = buttonContainerColor,
                    contentColor = buttonContentColor,
                    shape = RoundedCornerShape(12.dp),
                ) {
                    CustomText(
                        text = personality,
                        type = CustomTextType.body,
                        size = 12.sp,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = "이상형",
                type = CustomTextType.mainBold,
                size = 16.sp
            )
            CustomText(
                text = "(5개 이하)",
                type = CustomTextType.mainBold,
                size = 14.sp,
                color = CustomColor.gray300
            )
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            visualList.forEach { visual ->
                val isSelected = selectedvisuals.contains(visual)
                val buttonContainerColor =
                    if (isSelected) CustomColor.gray300 else CustomColor.gray100
                val buttonContentColor = if (isSelected) CustomColor.black else CustomColor.gray400
                Surface(
                    onClick = {
                        selectedvisuals = if (isSelected) {
                            selectedvisuals - visual
                        } else {
                            if (selectedvisuals.size < visualMax) selectedvisuals + visual else selectedvisuals
                        }
                    },
                    color = buttonContainerColor,
                    contentColor = buttonContentColor,
                    shape = RoundedCornerShape(12.dp),
                ) {
                    CustomText(
                        text = visual,
                        type = CustomTextType.body,
                        size = 12.sp,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = "데이트 스타일",
                type = CustomTextType.mainBold,
                size = 16.sp
            )
            CustomText(
                text = "(5개 이하)",
                type = CustomTextType.mainBold,
                size = 14.sp,
                color = CustomColor.gray300
            )
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            dateStyleList.forEach { style ->
                val isSelected = selectedDateStyles.contains(style)
                val buttonContainerColor =
                    if (isSelected) CustomColor.gray300 else CustomColor.gray100
                val buttonContentColor = if (isSelected) CustomColor.black else CustomColor.gray400
                Surface(
                    onClick = {
                        selectedDateStyles = if (isSelected) {
                            selectedDateStyles - style
                        } else {
                            if (selectedDateStyles.size < dateStyleMax) selectedDateStyles + style else selectedDateStyles
                        }
                    },
                    color = buttonContainerColor,
                    contentColor = buttonContentColor,
                    shape = RoundedCornerShape(12.dp),
                ) {
                    CustomText(
                        text = style,
                        type = CustomTextType.body,
                        size = 12.sp,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}
