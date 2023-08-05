package com.example.xox_game.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.ui.theme.*

@Composable()
fun MGameTimer(isCurrentCharType: GameCharType, onFinished: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = GameCharType.X.text,
            color = if (isCurrentCharType == GameCharType.X) TextColorBlack else TextColorPassive,
            fontSize = if (isCurrentCharType == GameCharType.X) FontSize50 else FontSize30,
            modifier = Modifier.padding(Padding8)
        )
        MProgressIndicator(isCurrentCharType, onFinished)
        Text(
            text = GameCharType.O.text,
            color = if (isCurrentCharType == GameCharType.O) TextColorBlack else TextColorPassive,
            fontSize = if (isCurrentCharType == GameCharType.O) FontSize50 else FontSize30,
            modifier = Modifier.padding(Padding8)
        )
    }

}