package com.example.xox_game.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
    onReset: () -> Unit,
    size: Int,
    gameBoardCells: List<GameBoardCell>
) {

    val nextChar = remember {
        mutableStateOf(GameCharType.UNKNOWN)
    }

    val isClickedStart = remember {
        mutableStateOf(false)
    }

    val isSelected = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(nextChar.value) {
        if (nextChar.value == GameCharType.O) {
            delay(5000)
            onClickCell.invoke(gameBoardCells.decideNextPosition(), GameCharType.O)
            isSelected.value = true
        }
    }

    LaunchedEffect(isSelected.value) {
        if (isSelected.value) {

        }
    }

    LaunchedEffect(isClickedStart.value) {
        nextChar.value = if (isClickedStart.value) GameCharType.X else GameCharType.UNKNOWN
    }

    val onFinishedListener: () -> Unit = {
        nextChar.value = nextChar.value.not()
        isSelected.value = false
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(Size16))
        Button(
            modifier = Modifier.size(Size112, Size64),
            onClick = {
                if (isClickedStart.value) {
                    onReset.invoke()
                }
                isClickedStart.value = isClickedStart.value.not()
            }) {
            Text(text = if (isClickedStart.value) "End" else "Start")
        }
        Spacer(modifier = Modifier.size(Size16))
        MGameTimer(nextChar.value, onFinishedListener)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
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
                                enabled = !cell.isSelected && nextChar.value == GameCharType.X && !isSelected.value
                            ) {
                                onClickCell.invoke(index, GameCharType.X)
                                isSelected.value = true
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
    }
}