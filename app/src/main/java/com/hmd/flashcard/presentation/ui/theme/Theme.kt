package com.hmd.flashcard.presentation.ui.theme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import java.util.Calendar

enum class TimeSlot {
    Morning, Noon, Evening
}

fun colorSchemeFor(timeSlot: TimeSlot): ColorScheme {
    return when (timeSlot) {
        TimeSlot.Morning -> lightColorScheme(
            primary = MorningPrimary,
            background = MorningBackground,
            surface = White,
            onPrimary = Black,
            onBackground = MorningOnBackground,
        )
        TimeSlot.Noon -> lightColorScheme(
            primary = NoonPrimary,
            background = NoonBackground,
            surface = White,
            onPrimary = White,
            onBackground = EveningOnBackground,
        )
        TimeSlot.Evening -> darkColorScheme(
            primary = EveningPrimary,
            background = EveningBackground,
            surface = EveningSurface,
            onPrimary = White,
            onBackground = Black,
        )
    }
}

fun getCurrentTimeSlot(): TimeSlot {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 6..10 -> TimeSlot.Morning
        in 11..16 -> TimeSlot.Noon
        else -> TimeSlot.Evening
    }
}

@Composable
fun MyFlashCardTheme(
    // Dynamic color is available on Android 12+
    timeSlot: TimeSlot = getCurrentTimeSlot(),
    content: @Composable () -> Unit
) {
    val colorScheme = colorSchemeFor(timeSlot)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}