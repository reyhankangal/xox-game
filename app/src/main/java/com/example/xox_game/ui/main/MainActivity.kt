package com.example.xox_game.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.xox_game.models.game.GameBoardCell
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.models.game.Level
import com.example.xox_game.ui.game.GameBoardScreen
import com.example.xox_game.ui.theme.XoxgameTheme
import com.example.xox_game.utils.GameUtils
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            XoxgameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val onClickCell: (position: Int, charType: GameCharType) -> Unit =
                        { position, charType ->
                            mainViewModel.updateCell(position, charType)
                        }
                    GameBoardScreen(onClickCell, Level.LEVEL_1.count, mainViewModel.gameBoardCells)
                }
            }
        }
    }
}