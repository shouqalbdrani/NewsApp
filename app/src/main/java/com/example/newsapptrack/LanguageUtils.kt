package com.example.newsapptrack

import android.content.Context
import android.content.res.Configuration
import java.util.*

// Handle language switching

object LanguageUtils {
    fun setAppLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}
