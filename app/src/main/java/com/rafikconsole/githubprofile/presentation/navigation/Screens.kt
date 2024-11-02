package com.rafikconsole.githubprofile.presentation.navigation

import androidx.navigation.NavHostController
import com.rafikconsole.githubprofile.utils.Constants.GET_USER_SCREEN
import com.rafikconsole.githubprofile.utils.Constants.USER_PROFILE_SCREEN

// The Screens class is responsible for managing navigation actions in the application.
class Screens(
    navController: NavHostController // The NavHostController used for navigation within the app.
) {
    // Lambda function to navigate to the user profile screen.
    val userProfile: () -> Unit = {
        navController.navigate(USER_PROFILE_SCREEN) { // Navigate to USER_PROFILE_SCREEN.
            // Configuration for the navigation action.
            popUpTo(USER_PROFILE_SCREEN) { inclusive = false } // Do not remove the user profile screen from the back stack.
            launchSingleTop = true // Launch the destination only if it's not already on the top of the back stack.
        }
    }

    // Lambda function to navigate to the get user screen.
    val getUser: () -> Unit = {
        navController.navigate(GET_USER_SCREEN) { // Navigate to GET_USER_SCREEN.
            // Additional navigation configuration can be added here if needed.
        }
    }
}
