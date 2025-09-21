package com.apptive.japkor.ui.login


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.components.auth.GoogleSignUpButton
import com.apptive.japkor.ui.theme.CustomColor


@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .safeContentPadding(),
        contentAlignment = Alignment.Center
    ) {
        // 좌측 상단 뒤로가기 아이콘 추가
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "뒤로가기",
                tint = Color.Black
            )
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CustomText(
                text = "앱이름",
                type = CustomTextType.headlineSmall
            )
            CustomText(
                text = "여기 앱이름에 대한 설명이에요. 슬로건 같은 한 문장.",
                type = CustomTextType.bodyMedium,
                color = CustomColor.mediumGray
            )

            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = CustomColor.lightGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomText(
                    text = "로그인",
                    type = CustomTextType.titleMedium
                )

                GoogleSignUpButton(
                    onSignedIn = {
                        android.util.Log.d("LoginScreen", "onSignedIn 콜백 호출됨")
                        navController.navigate("requiredinfo")
                    },
                )


            }

        }
    }
}