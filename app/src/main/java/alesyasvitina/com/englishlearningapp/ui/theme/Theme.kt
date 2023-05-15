package alesyasvitina.com.englishlearningapp.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
private val DarkColorPalette = darkColors(
    primary = MainLight,
    primaryVariant = MainDark,
    secondary = SecondaryLight
)
private val LightColorPalette = lightColors(
    primary = MainMiddle,
    primaryVariant = MainDark,
    secondary = SecondaryLight
)
@Composable
fun EnglishLearningAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}