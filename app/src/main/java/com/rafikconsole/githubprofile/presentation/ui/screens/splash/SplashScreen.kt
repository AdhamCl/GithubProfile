package com.rafikconsole.githubprofile.presentation.ui.screens.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getDrawable
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.presentation.theme.AppBackgroundColor
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToGetUserScreen: () -> Unit // Callback to navigate to the Get User screen
) {
    var startAnimation by remember { mutableStateOf(false) } // State to control animation start
    // Animate the vertical offset and opacity of the splash image
    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp, // Move the image up when animation starts
        animationSpec = tween(1000), // Duration of the animation
        label = "" // Animation label (for debugging, can be left blank)
    )
    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f, // Fade in the image when animation starts
        animationSpec = tween(1000), // Duration of the animation
        label = "" // Animation label (for debugging, can be left blank)
    )

    // Launch effect to trigger animation and navigation after a delay
    LaunchedEffect(key1 = true) {
        startAnimation = true // Start the animation
        delay(1000) // Wait for 1 second before navigating
        navigateToGetUserScreen() // Navigate to the Get User screen
    }

    val configuration = LocalConfiguration.current // Get the current configuration
    val screenWidthDp = configuration.screenWidthDp.dp // Get screen width in dp
    val gifSize = (screenWidthDp * 0.5f) // Calculate GIF size based on screen width
    val context = LocalContext.current // Get the current context

    // Box to center the splash image on the screen
    Box(
        Modifier
            .fillMaxSize() // Fill the entire screen
            .background(AppBackgroundColor), // Set background color
        contentAlignment = Alignment.Center // Center content in the Box
    ) {

        val gifDrawable = remember { // Remember GIF drawable
            getDrawable(context, R.drawable.splash)
        }

        Image(
            modifier = Modifier
                .clip(CircleShape) // Clip image to a circle
                .size(gifSize), // Set image size
            painter = rememberDrawablePainter(drawable = gifDrawable), // Load drawable as painter
            contentDescription = "Splash Gif", // Accessibility description
            contentScale = ContentScale.FillWidth // Scale to fill width
        )
    }
}
