package com.example.xox_game.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.xox_game.ui.theme.*


@Composable
fun MProgressIndicator(enabled: Boolean) {
    val progressValue = 0f
    CircularProgressIndicator(
        color = ProgressIndicatorColor,
        modifier = Modifier
            .padding(Padding16)
            .size(Size112),
        progress = if(enabled) {
            val infiniteTransition = rememberInfiniteTransition()
            val progressAnimationValue by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = progressValue,
                animationSpec = infiniteRepeatable(animation = tween(10000))
            )
            progressAnimationValue
        } else 1f
    )
}