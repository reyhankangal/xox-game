package com.example.xox_game.utils

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.xox_game.domain.game.GameChar
import com.example.xox_game.domain.game.GameCharType

object GameUtils {

    fun createEmptyListBySize(size: Int): SnapshotStateList<GameChar> {
        val list = mutableStateListOf<GameChar>()
        for(i in 1..(size * size)) {
            list.add(GameChar(GameCharType.EMPTY))
        }
        return list
    }
}