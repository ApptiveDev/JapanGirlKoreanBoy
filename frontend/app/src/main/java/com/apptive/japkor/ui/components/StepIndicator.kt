package com.apptive.japkor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 회색 팔레트
private val Gray100 = Color(0xFFF5F5F5)
private val Gray400 = Color(0xFFBDBDBD)

/**
 * 4단계 가로 스텝 인디케이터
 * - 총 막대 수: 4 (기본값)
 * - 막대 두께: 3dp
 * - 현재 단계: Gray100, 나머지: Gray400
 * - currentStep는 1..totalSteps 범위로 클램핑됨
 */
@Composable
fun StepIndicator(
    modifier: Modifier = Modifier,
    currentStep: Int,
    totalSteps: Int = 4,
    activeColor: Color = Gray100,
    inactiveColor: Color = Gray400,
) {
    val clampedIndex = currentStep.coerceIn(1, totalSteps) - 1
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(totalSteps) { index ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(5.dp)
                    .background(
                        color = if (index == clampedIndex) activeColor else inactiveColor,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                    )
            )
        }
    }
}
