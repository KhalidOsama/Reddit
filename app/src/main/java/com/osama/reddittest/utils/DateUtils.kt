package com.osama.reddittest.utils

import android.content.res.Resources
import androidx.core.os.ConfigurationCompat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun printDateFromUtc(dateInUtc: Long) : String {
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a",
            ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0))
        sdf.timeZone = Calendar.getInstance().timeZone
        return sdf.format(Date(dateInUtc))
    }
}