package alesyasvitina.com.englishlearningapp.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import java.util.Random

private val datetimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")

private val COLUMN_SIZE = object {
    val DATE_TIME = 0.45f
    val RESULT = 0.4f
    val TIME_SPENT: Float? = null
}

@Composable
fun StatisticPage(onExit: () -> Unit) {
    val repository = StatisticRepository(LocalContext.current)
    val statisticData = repository.loadAll()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Статистика по тестам",
                fontSize = 32.sp,
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = onExit) {
                Text(text = "Назад")
            }
            Button(
                onClick = { repository.deleteAll() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Очистить")
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                TableRow {
                    TableCell(text = "Дата", header = true, width = COLUMN_SIZE.DATE_TIME)
                    TableCell(text = "Решено", header = true, width = COLUMN_SIZE.RESULT)
                    TableCell(
                        text = "Времени потрачено",
                        header = true,
                        width = COLUMN_SIZE.TIME_SPENT
                    )
                }
            }
            items(statisticData.size) { i ->
                val it = statisticData[i]
                val timeSpentMinutes = it.timeSpentInSeconds / 60
                val timeSpentSeconds = it.timeSpentInSeconds % 60
                TableRow {
                    TableCell(
                        text = it.datetime.format(datetimeFormatter),
                        width = COLUMN_SIZE.DATE_TIME
                    )
                    TableCell(text = "${it.resultInPercent}%", width = COLUMN_SIZE.RESULT)
                    TableCell(
                        text = "${timeSpentMinutes}:${timeSpentSeconds}",
                        width = COLUMN_SIZE.TIME_SPENT
                    )
                }
            }
        }
    }
}

@Composable
private fun TableRow(items: @Composable () -> Unit) {
    Row(
        Modifier
            .border(1.dp, Color.Black)
            .fillMaxWidth()
    ) {
        items()
    }
}

@Composable
private fun TableCell(
    text: String,
    width: Float? = null,
    header: Boolean = false
) {
    var modifier = Modifier.padding(4.dp)
    modifier =
        if (width != null) {
            modifier.fillMaxWidth(width)
        } else {
            modifier.fillMaxWidth()
        }
    Text(
        text = text,
        fontWeight = if (header) FontWeight.Bold else FontWeight.Normal,
        modifier = modifier
    )
}

