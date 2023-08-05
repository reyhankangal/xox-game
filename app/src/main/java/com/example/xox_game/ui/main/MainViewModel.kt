package com.example.xox_game.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.xox_game.models.game.GameBoardCell
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.models.game.Level
import com.example.xox_game.utils.GameUtils

class MainViewModel : ViewModel() {

    private var gameBoardStateList = mutableStateListOf<GameBoardCell>()
    val gameBoardCells: SnapshotStateList<GameBoardCell>
        get() = gameBoardStateList


    init {
        gameBoardStateList = GameUtils.createEmptyListBySize(Level.LEVEL_1.count)
    }

    fun updateCell(position: Int, charType: GameCharType) {
        gameBoardStateList[position].apply {
            gameCharType = charType
            isSelected = true
        }
    }

    fun resetCells() {
        gameBoardStateList.forEach { cell ->
            cell.apply {
                gameCharType = null
                isSelected = false
            }
        }
    }

}