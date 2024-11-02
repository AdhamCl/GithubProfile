package com.rafikconsole.githubprofile.utils

import android.content.Intent
import android.net.Uri

fun openEmail(context: android.content.Context, email: String) {
    // Create an Intent to send an email
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        // Set the data for the intent using a "mailto:" URI
        data = Uri.parse("mailto:$email")
    }

    // Start the email activity using the provided context
    context.startActivity(intent)
}
