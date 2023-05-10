package alesyasvitina.com.englishlearningapp
import a.svitina.english_learning_for_developers.root.Root
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.*
import alesyasvitina.com.englishlearningapp.ui.theme.EnglishLearningAppTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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