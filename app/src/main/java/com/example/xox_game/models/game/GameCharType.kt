package com.example.xox_game.models.game

enum class GameCharType(val text: String) {
    X("X"),
    O("O")
}

fun GameCharType.switch(): GameCharType {
    return if (this == GameCharType.X) GameCharType.O else GameCharType.X
}
