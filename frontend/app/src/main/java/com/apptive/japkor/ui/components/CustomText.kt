package com.apptive.japkor.ui.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.apptive.japkor.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.W100),
    Font(R.font.pretendard_extralight, FontWeight.W200),
    Font(R.font.pretendard_light, FontWeight.W300),
    Font(R.font.pretendard_regular, FontWeight.W400),
    Font(R.font.pretendard_medium, FontWeight.W500),
    Font(R.font.pretendard_semi_bold, FontWeight.W600),
    Font(R.font.pretendard_bold, FontWeight.W700),
    Font(R.font.pretendard_extra_bold, FontWeight.W800),
    Font(R.font.pretendard_black, FontWeight.W900)
)

val GowunBatnag = FontFamily(
    Font(R.font.gowun_batang_regular, FontWeight.W400),
    Font(R.font.gowun_batang_bold, FontWeight.W700)
)

enum class CustomTextType {
    displayLarge, displayMedium, displaySmall,
    headlineLarge, headlineMedium, headlineSmall,
    titleLarge, titleMedium, titleSmall,
    bodyLarge, bodyMedium, bodySmall,
    labelLarge, labelMedium, labelSmall,
    mainBoldLarge, mainBoldMedium, mainBoldSmall,
    mainRegularLarge, mainRegularMedium, mainRegularSmall
}

private fun getTextStyle(type: CustomTextType): TextStyle = when (type) {
    CustomTextType.displayLarge -> TextStyle(
        fontSize = 57.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard,
        letterSpacing = (-0.25).sp
    )

    CustomTextType.displayMedium -> TextStyle(
        fontSize = 45.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard
    )

    CustomTextType.displaySmall -> TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard
    )

    CustomTextType.headlineLarge -> TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard
    )

    CustomTextType.headlineMedium -> TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard
    )

    CustomTextType.headlineSmall -> TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        fontFamily = Pretendard
    )

    CustomTextType.titleLarge -> TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.W600,
        fontFamily = Pretendard
    )

    CustomTextType.titleMedium -> TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        fontFamily = Pretendard
    )

    CustomTextType.titleSmall -> TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        fontFamily = Pretendard
    )

    CustomTextType.bodyLarge -> TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = Pretendard
    )

    CustomTextType.bodyMedium -> TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = Pretendard
    )

    CustomTextType.bodySmall -> TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        fontFamily = Pretendard
    )

    CustomTextType.labelLarge -> TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        fontFamily = Pretendard
    )

    CustomTextType.labelMedium -> TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        fontFamily = Pretendard
    )

    CustomTextType.labelSmall -> TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.W500,
        fontFamily = Pretendard
    )

    CustomTextType.mainBoldLarge -> TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.W700,
        fontFamily = GowunBatnag
    )

    CustomTextType.mainBoldMedium -> TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        fontFamily = GowunBatnag
    )

    CustomTextType.mainBoldSmall -> TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W700,
        fontFamily = GowunBatnag
    )

    CustomTextType.mainRegularLarge -> TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.W400,
        fontFamily = GowunBatnag
    )

    CustomTextType.mainRegularMedium -> TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontFamily = GowunBatnag
    )

    CustomTextType.mainRegularSmall -> TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = GowunBatnag
    )
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    type: CustomTextType = CustomTextType.bodyMedium,
    style: TextStyle? = null,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    size: TextUnit? = null
) {
    val baseStyle = style ?: getTextStyle(type)
    val appliedStyle = if (size != null) baseStyle.copy(fontSize = size) else baseStyle
    Text(
        text = text,
        modifier = modifier,
        style = appliedStyle,
        color = color,
        textAlign = textAlign
    )
}
