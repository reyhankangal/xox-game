package com.example.xox_game.models.game

import java.lang.Exception

enum class GameCharType(val text: String) {
    UNKNOWN(""),
    X("X"),
    O("O")
}

fun GameCharType.not(): GameCharType {
    return when(this) {
        GameCharType.X ->  GameCharType.O
        GameCharType.O -> GameCharType.X
        else -> throw Exception("Unknown Game Char Type")
    }
}
