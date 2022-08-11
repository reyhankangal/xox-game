package com.example.xox_game.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.xox_game.domain.game.GameCharType
import com.example.xox_game.ui.theme.FontSize30
import com.example.xox_game.ui.theme.Padding8
import com.example.xox_game.ui.theme.TextColorBlack

@Preview
@Composable
fun MGameTimer() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = GameCharType.X.text,
            color = TextColorBlack,
            fontSize = FontSize30,
            modifier = Modifier.padding(Padding8)
        )
        MProgressIndicator()
        Text(
            text = GameCharType.O.text,
            color = TextColorBlack,
            fontSize = FontSize30,
            modifier = Modifier.padding(Padding8)
        )
    }
}