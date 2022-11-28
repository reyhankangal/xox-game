package com.example.xox_game.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.xox_game.models.game.GameChar
import com.example.xox_game.models.game.GameCharType
import com.example.xox_game.models.game.Level
import com.example.xox_game.ui.theme.*
import com.example.xox_game.utils.GameUtils


@Composable
fun MGameBoard() {
    val selectedGameChar = GameChar(GameCharType.X)
    val level = Level.LEVEL_1
    val list = GameUtils.createEmptyListBySize(level.count)
    LazyVerticalGrid(
        columns = GridCells.Fixed(level.count),
        verticalArrangement = Arrangement.Center
    ) {
        items(list.size) { index ->
            Card(
                backgroundColor = CellBackgroundColor,
                modifier = Modifier
                    .padding(Padding4)
                    .fillMaxWidth()
                    .clickable {
                        list[index] = selectedGameChar
                    },
                elevation = Elevation8
            ) {
                Text(
                    text = list[index].text,
                    fontWeight = FontWeight.Bold,
                    fontSize = FontSize30,
                    color = if(list[index].type == GameCharType.X) TextColorX else TextColorO,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(Padding16)
                )
            }
        }
    }
}