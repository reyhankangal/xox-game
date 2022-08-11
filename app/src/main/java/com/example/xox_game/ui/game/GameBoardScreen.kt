package com.example.xox_game.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.xox_game.components.MGameBoard
import com.example.xox_game.components.MGameTimer
import com.example.xox_game.ui.theme.*


@Preview
@Composable
fun GameBoardScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(Size32))
        MGameTimer()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            MGameBoard()
        }
    }
}