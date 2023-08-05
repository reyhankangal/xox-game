package com.example.xox_game.ui.game

import androidx.compose.runtime.*
import com.example.xox_game.components.MGameBoard
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.ui.main.MainViewModel


@Composable
fun GameBoardScreen(
    onClickCell: (position: Int, charType: GameCharType) -> Unit,
    onReset: () -> Unit,
    size: Int,
    viewModel: MainViewModel
) {
    MGameBoard(onClickCell = onClickCell, onReset, size = size, viewModel.gameBoardCells)
}