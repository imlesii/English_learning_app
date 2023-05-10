package alesyasvitina.com.englishlearningapp
import a.svitina.english_learning_for_developers.root.Root
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import alesyasvitina.com.englishlearningapp.ui.theme.EnglishLearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnglishLearningAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Root()
                }
            }
        }
    }
}
@Preview
@Composable
fun RootPreview() {
    EnglishLearningAppTheme {
        Root()
    }
}