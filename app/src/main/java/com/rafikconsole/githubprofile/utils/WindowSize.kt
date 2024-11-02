package com.rafikconsole.githubprofile.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

// Data class to represent the window size with width and height as WindowType enums
data class WindowSize(
    val width: WindowType,
    val height: WindowType,
)

// Enum class representing different window types based on screen size
enum class WindowType {
    Compact, Medium, Expanded
}

// Composable function to remember and provide the current window size
@Composable
fun rememberWindowSize(): WindowSize {
    // Get the current configuration, which contains information about the screen dimensions
    val configuration = LocalConfiguration.current

    // Determine the window size based on screen width and height
    return WindowSize(
        width = when {
            // If screen width is less than 600dp, classify as Compact
            configuration.screenWidthDp < 600 -> WindowType.Compact

            // If screen width is between 600dp and height is greater than width, classify as Compact
            configuration.screenWidthDp > 600 && configuration.screenWidthDp < configuration.screenHeightDp -> WindowType.Compact

            // If screen width is between 600dp and 840dp, classify as Medium
            configuration.screenWidthDp < 840 -> WindowType.Medium

            // If screen width is 840dp or more, classify as Expanded
            else -> WindowType.Expanded
        },
        height = when {
            // If screen height is less than 600dp, classify as Compact
            configuration.screenHeightDp < 600 -> WindowType.Compact

            // If screen height is between 600dp and 840dp, classify as Medium
            configuration.screenHeightDp < 840 -> WindowType.Medium

            // If screen height is 840dp or more, classify as Expanded
            else -> WindowType.Expanded
        }
    )
}
