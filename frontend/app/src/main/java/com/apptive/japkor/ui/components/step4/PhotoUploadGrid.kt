package com.apptive.japkor.ui.components.step4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PhotoUploadGrid() {
    Column(modifier = Modifier.fillMaxWidth()) {
        val cells = (0 until 6).toList()
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            cells.chunked(3).forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    row.forEach { idx ->
                        PhotoUploadButton(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f),   // 정사각형
                            onClick = { /* TODO: photo pick for idx */ }
                        )
                    }
                }
            }
        }
    }
}