package com.example.koinsample

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

class UriHelper(private val baseUrl: String) {

    fun launchCurrencyUrl(context: Context, slug: String) {
        launchUrl(context, Uri.parse("$baseUrl$slug"))
    }

    fun launchUrl(context: Context, uri: Uri) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .addDefaultShareMenuItem()
            .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            .setShowTitle(true)
            .build()
        customTabsIntent.launchUrl(context, uri)
    }
}