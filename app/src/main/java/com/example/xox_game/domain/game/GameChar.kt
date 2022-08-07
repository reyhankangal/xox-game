package com.example.xox_game.domain.game

data class GameChar(
    val type: GameCharType,
    val text: String = type.text
) {
}