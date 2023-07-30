package com.example.xox_game.models.game

data class GameBoardCell(
    var gameCharType: GameCharType? = null,
    var isSelected: Boolean = false
)
