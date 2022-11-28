package com.example.xox_game.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.ui.theme.FontSize30
import com.example.xox_game.ui.theme.Padding8
import com.example.xox_game.ui.theme.TextColorBlack

@Composable
fun MGameTimer(progressEnabled: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = GameCharType.X.text,
            color = TextColorBlack,
            fontSize = FontSize30,
            modifier = Modifier.padding(Padding8)
        )
        MProgressIndicator(progressEnabled)
        Text(
            text = GameCharType.O.text,
            color = TextColorBlack,
            fontSize = FontSize30,
            modifier = Modifier.padding(Padding8)
        )
    }

}