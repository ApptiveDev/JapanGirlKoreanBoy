package com.apptive.japkor.ui.requiredinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apptive.japkor.navigation.Screen
import com.apptive.japkor.ui.components.CustomText
import com.apptive.japkor.ui.components.CustomTextType
import com.apptive.japkor.ui.theme.CustomColor

@Composable
fun RequiredInfoCompleteScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomText(
                text = "신청이 완료되었어요!",
                type = CustomTextType.mainBoldSmall
            )
            Spacer(modifier = Modifier.height(12.dp))
            CustomText(
                text = "곧 연결 결과를 알려드릴게요.",
                type = CustomTextType.bodyLarge,
                color = CustomColor.gray400
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.Language.route) {
                        popUpTo(Screen.Language.route) { inclusive = false }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = CustomColor.gray300)
            ) {
                CustomText(
                    text = "확인",
                    type = CustomTextType.bodyLarge,
                    color = Color.Black
                )
            }
        }
    }
}
