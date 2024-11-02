package com.rafikconsole.githubprofile.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rafikconsole.githubprofile.presentation.navigation.destination.getUserComposable
import com.rafikconsole.githubprofile.presentation.navigation.destination.splashScreenComposable
import com.rafikconsole.githubprofile.presentation.navigation.destination.userProfileComposable
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.Constants.SPLASH_SCREEN

// ExperimentalMaterial3Api annotation indicates that this function uses experimental APIs from Material 3.
@ExperimentalMaterial3Api
@Composable
fun SetupNavigation(
    navController: NavHostController, // The NavHostController used to manage the navigation.
    gitHubViewModel: GitHubViewModel, // The ViewModel for managing UI-related data.
) {
    // Remember the Screens instance associated with the given navController.
    val screen = remember(navController) {
        Screens(navController) // Create a new Screens instance for managing navigation.
    }

    // Define the NavHost for managing the app's navigation graph.
    NavHost(
        navController = navController, // The NavHostController for navigation.
        startDestination = SPLASH_SCREEN // The initial screen to display.
    ) {
        // Define the composable destinations in the navigation graph.
        getUserComposable(gitHubViewModel, screen.userProfile) // Composable for getting a user.
        userProfileComposable(gitHubViewModel) // Composable for displaying the user profile.
        splashScreenComposable(screen.getUser) // Composable for the splash screen.
    }
}
