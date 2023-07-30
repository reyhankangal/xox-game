package com.example.xox_game.utils

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.xox_game.models.game.GameBoardCell
import com.example.xox_game.models.game.GameChar
import com.example.xox_game.models.game.GameCharType

object GameUtils {

    fun createEmptyListBySize(size: Int): SnapshotStateList<GameBoardCell> {
        val list = mutableStateListOf<GameBoardCell>()
        for(i in 1..(size * size)) {
            list.add(GameBoardCell())
        }
        return list
    }
}