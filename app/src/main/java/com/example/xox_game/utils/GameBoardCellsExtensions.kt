package com.example.xox_game.utils

import com.example.xox_game.models.game.GameBoardCell

fun List<GameBoardCell>.decideNextPosition(): Int {
    val isNotSelectedPositions = this.filter { !it.isSelected }.map { indexOf(it) }
    return isNotSelectedPositions.random()
}