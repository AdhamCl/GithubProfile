package com.rafikconsole.githubprofile.utils

import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun rememberImeState(): State<Boolean> {
    // Create a mutable state to hold the keyboard visibility status
    val imeState = remember {
        mutableStateOf(false)
    }

    // Initialize the system UI controller (though it's not used further in this function)
    rememberSystemUiController()

    // Get the current view context
    val view = LocalView.current

    // Create a disposable effect that listens for global layout changes
    DisposableEffect(view) {
        // Listener to check if the keyboard is open based on layout changes
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            // Determine if the keyboard is visible
            val isKeyboardOpen = ViewCompat.getRootWindowInsets(view)
                ?.isVisible(WindowInsetsCompat.Type.ime()) ?: true

            // Update the state with the keyboard visibility status
            imeState.value = isKeyboardOpen
        }

        // Add the listener to the view's layout observer
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        // Remove the listener when the composable is disposed to prevent memory leaks
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }

    // Return the state of the IME visibility
    return imeState
}
