package com.example.xox_game.utils

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.xox_game.models.game.GameBoardCell

object GameUtils {

    fun createEmptyListBySize(size: Int): SnapshotStateList<GameBoardCell> {
        return List(size * size) { GameBoardCell() }.toMutableStateList()
    }
}