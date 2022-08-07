package com.example.xox_game.ui.game

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xox_game.domain.game.GameChar
import com.example.xox_game.domain.game.GameCharType
import com.example.xox_game.domain.game.Level
import com.example.xox_game.ui.theme.CellBackgroundColor
import com.example.xox_game.ui.theme.TextColorO
import com.example.xox_game.ui.theme.TextColorX
import com.example.xox_game.utils.GameUtils

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun GameBoardScreen() {
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
                    .padding(4.dp)
                    .fillMaxWidth().clickable {
                       list[index]  = selectedGameChar
                    },
                elevation = 8.dp
            ) {
                Text(
                    text = list[index].text,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = if(list[index].type == GameCharType.X) TextColorX else TextColorO,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}