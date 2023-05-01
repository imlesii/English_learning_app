package a.svitina.english_learning_for_developers.root

import a.svitina.english_learning_for_developers.test.Tests
import a.svitina.english_learning_for_developers.theory.Theory
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private val LINKS = object {
    val root = "root"
    val theory = "theory"
    val tests = "tests"
}

@Composable
fun Root() {
    val nav = rememberNavController()
    val activity = (LocalContext.current as? Activity)
    NavHost(navController = nav, startDestination = LINKS.root) {
        composable(LINKS.root) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Добро пожаловать в туториал по английскому языку для программистов",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                    Button(onClick = { nav.navigate(LINKS.theory) }) {
                        Text("К теории")
                    }
                    Button(onClick = { nav.navigate(LINKS.tests) }) {
                        Text("К тестам")
                    }
                    Button(onClick = { activity?.finish() }) {
                        Text("Выход")
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
    }
}