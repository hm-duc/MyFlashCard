package com.hmd.flashcard.data.provider

import android.os.Build
import java.time.LocalTime
import java.util.Calendar

class TimeProvider {
    fun getCurrentHour(): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalTime.now().hour
        } else {
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        }
    }
}