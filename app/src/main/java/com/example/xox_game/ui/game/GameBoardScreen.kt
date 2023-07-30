package com.example.xox_game.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.xox_game.components.MGameBoard
import com.example.xox_game.components.MGameTimer
import com.example.xox_game.models.game.GameBoardCell
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.ui.main.MainViewModel
import com.example.xox_game.ui.theme.*


@Composable
fun GameBoardScreen(onClickCell: (position: Int, charType: GameCharType) -> Unit, size: Int,gameBoardCells: List<GameBoardCell>) {
    var progressEnabled by remember { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(Size16))
        Button(
            modifier = Modifier.size(Size112, Size64),
            onClick = {
            progressEnabled = progressEnabled.not()
        }) {
            Text(text = if (progressEnabled) "End" else "Start")
        }
        Spacer(modifier = Modifier.size(Size16))
        MGameTimer(progressEnabled)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            MGameBoard(onClickCell, size, gameBoardCells)
        }
    }
}