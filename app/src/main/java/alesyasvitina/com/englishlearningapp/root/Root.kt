package a.svitina.english_learning_for_developers.root
import a.svitina.english_learning_for_developers.test.Tests
import a.svitina.english_learning_for_developers.theory.Theory
import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.navigation.compose.*
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
                        text = "Добро пожаловать в обучающее приложение по английскому языку для программистов!",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                    Button(onClick = { nav.navigate(LINKS.theory) }) {
                        Text("Читать теорию")
                    }
                    Button(onClick = { nav.navigate(LINKS.tests) }) {
                        Text("Решать тесты")
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
    }
}