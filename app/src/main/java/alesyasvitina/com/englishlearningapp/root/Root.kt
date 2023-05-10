package a.svitina.english_learning_for_developers.root

import a.svitina.english_learning_for_developers.test.Tests
import a.svitina.english_learning_for_developers.theory.Theory
import alesyasvitina.com.englishlearningapp.R
import alesyasvitina.com.englishlearningapp.statistic.StatisticPage
import alesyasvitina.com.englishlearningapp.ui.theme.SecondaryLight
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.navigation.compose.*

private val LINKS = object {
    val root = "root"
    val theory = "theory"
    val tests = "tests"
    val statistic = "statistic"
}

@Composable
fun Root() {
    val nav = rememberNavController()
    val activity = (LocalContext.current as? Activity)
    NavHost(navController = nav, startDestination = LINKS.root) {
        composable(LINKS.root) {
            Image(
                painter = painterResource(id = R.drawable.root_background),
                contentDescription = "Root Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.background(color = Color(0x88000000))) {
                        Text(
                            text = "Добро пожаловать в обучающее приложение по английскому языку для программистов!",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp),
                            color = SecondaryLight,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle.Default.copy(
                                fontSize = 16.sp
                            )
                        )
                    }
                    Button(onClick = { nav.navigate(LINKS.theory) }) {
                        Text("Читать теорию")
                    }
                    Button(onClick = { nav.navigate(LINKS.tests) }) {
                        Text("Решать тесты")
                    }
                    Button(onClick = { nav.navigate(LINKS.statistic) }) {
                        Text("Статистика по тестам")
                    }
                    Button(onClick = { activity?.finish() }) {
                        Text("Выход из приложения")
                    }
                }
            }
        }
        composable(LINKS.theory) {
            Theory(
                navGoToRoot = {
                    nav.navigate(LINKS.root)
                },
                navGoToTests = {
                    nav.navigate(LINKS.tests)
                }
            )
        }
        composable(LINKS.tests) {
            Tests(onExit = { nav.navigate(LINKS.root) })
        }
        composable(LINKS.statistic) {
            StatisticPage(onExit = { nav.navigate(LINKS.root) })
        }
    }
}