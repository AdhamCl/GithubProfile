package com.rafikconsole.githubprofile.presentation.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rafikconsole.githubprofile.presentation.ui.screens.splash.SplashScreen
import com.rafikconsole.githubprofile.utils.Constants.SPLASH_SCREEN


// ExperimentalMaterial3Api annotation indicates that this function uses experimental APIs from Material 3.
@ExperimentalMaterial3Api
fun NavGraphBuilder.splashScreenComposable(
    navigateToGetUserScreen: () -> Unit // Lambda function for navigating to the get user screen.
) {
    // Define a composable route in the navigation graph.
    composable(
        route = SPLASH_SCREEN, // The route identifier for the splash screen.
    ) {
        // Render the SplashScreen composable, passing the navigation function as a parameter.
        SplashScreen(navigateToGetUserScreen)
    }
}
