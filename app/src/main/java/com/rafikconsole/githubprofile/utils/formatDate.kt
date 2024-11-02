package com.rafikconsole.githubprofile.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun formatDate(dateString: String): String {
    return try {
        // Create a SimpleDateFormat for parsing the input date string
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        parser.timeZone = TimeZone.getTimeZone("UTC") // Set the timezone to UTC for parsing

        // Parse the date string into a Date object
        val parsedDate = parser.parse(dateString)

        // Create a SimpleDateFormat for formatting the date into a desired format
        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        // Format the parsed Date object into the desired string format
        formatter.format(parsedDate!!) // Use !! to assert that parsedDate is not null
    } catch (e: Exception) {
        // Return the original date string in case of any parsing errors
        dateString
    }
}
