package com.rafikconsole.githubprofile.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openUrl(context: Context, url: String) {
    // Check if the URL starts with "http://" or "https://"
    val formattedUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
        url // Use the URL as-is if it starts with either of these prefixes
    } else {
        "https://$url" // Otherwise, prepend "https://"
    }

    // Create an Intent to view the URL
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(formattedUrl))
    // Start the activity using the provided context
    context.startActivity(intent)
}
