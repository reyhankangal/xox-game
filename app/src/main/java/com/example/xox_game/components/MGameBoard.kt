package com.example.xox_game.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.xox_game.models.game.*
import com.example.xox_game.ui.theme.*
import com.example.xox_game.utils.decideNextPosition
import kotlinx.coroutines.delay


@Composable
fun MGameBoard(
    onClickCell: (position: Int, charType: GameCharType) -> Unit,
    size: Int,
    gameBoardCells: List<GameBoardCell>
) {

    val nextChar = remember {
        mutableStateOf(GameCharType.X)
    }

    val isNextCharX = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(isNextCharX.value) {
        delay(5000)
        onClickCell.invoke(gameBoardCells.decideNextPosition(), GameCharType.O)
        nextChar.value = GameCharType.X
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(size),
        verticalArrangement = Arrangement.Center
    ) {
        itemsIndexed(gameBoardCells) { index, cell ->
            Card(
                backgroundColor = CellBackgroundColor,
                modifier = Modifier
                    .padding(Padding4)
                    .fillMaxWidth()
                    .clickable(
                        enabled = !cell.isSelected && nextChar.value == GameCharType.X
                    ) {
                        onClickCell.invoke(index, GameCharType.X)
                        nextChar.value = GameCharType.O
                        isNextCharX.value = !isNextCharX.value
                    },
                elevation = Elevation8
            ) {
                Text(
                    text = cell.gameCharType?.text ?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = FontSize30,
                    color = if (cell.gameCharType == GameCharType.X) TextColorX else TextColorO,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(Padding16)
                )
            }
        }
    }
}