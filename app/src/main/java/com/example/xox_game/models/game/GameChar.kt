package com.example.xox_game.models.game

data class GameChar(
    val type: GameCharType,
    val text: String = type.text
) {
}