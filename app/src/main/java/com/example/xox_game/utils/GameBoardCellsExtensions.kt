package com.example.xox_game.utils

import com.example.xox_game.models.game.GameBoardCell

fun List<GameBoardCell>.decideNextPosition(): Int {
    val isNotSelectedPositions =
        this.filter { cell -> !cell.isSelected }.mapIndexed { index, _ -> index }
    return isNotSelectedPositions.random()
}

fun List<GameBoardCell>.checkXOX() {

}