package com.example.xox_game.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.ui.theme.*


@Composable
fun MProgressIndicator(isCurrentCharType: GameCharType, onFinished: () -> Unit) {
    var progress by remember {
        mutableStateOf(1f)
    }

    val progressAnimationValue = if (isCurrentCharType == GameCharType.UNKNOWN) {
        progress = 1f
        1f
    } else {
        animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(10000, easing = LinearEasing),
            finishedListener = { _ ->
                onFinished.invoke()
            }
        ).value
    }

    LaunchedEffect(isCurrentCharType) {
        if (isCurrentCharType != GameCharType.UNKNOWN) {
            progress = if (progress == 0f) 1f else 0f
        }
    }

    CircularProgressIndicator(
        color = ProgressIndicatorColor,
        modifier = Modifier
            .padding(Padding16)
            .size(Size112),
        progress = progressAnimationValue,
    )


}