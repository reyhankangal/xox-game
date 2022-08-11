package com.example.xox_game.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.xox_game.ui.theme.Padding16
import com.example.xox_game.ui.theme.ProgressIndicatorColor


@Preview
@Composable
fun MProgressIndicator() {
    LinearProgressIndicator(
        color = ProgressIndicatorColor,
        modifier = Modifier.padding(Padding16)
    )
}