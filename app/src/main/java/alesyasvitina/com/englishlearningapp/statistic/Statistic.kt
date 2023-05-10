package alesyasvitina.com.englishlearningapp.statistic
import java.time.LocalDateTime
data class Statistic(
    val id: Long? = null,
    val datetime: LocalDateTime,
    val resultInPercent: Long,
    val timeSpentInSeconds: Long
)
