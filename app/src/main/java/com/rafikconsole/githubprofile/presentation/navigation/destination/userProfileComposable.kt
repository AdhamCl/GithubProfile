package com.rafikconsole.githubprofile.presentation.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rafikconsole.githubprofile.presentation.ui.screens.userprofile.UserProfileScreen
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.Constants.USER_PROFILE_SCREEN


// ExperimentalMaterial3Api annotation indicates that this function uses experimental APIs from Material 3.
@ExperimentalMaterial3Api
fun NavGraphBuilder.userProfileComposable(
    gitHubViewModel: GitHubViewModel // ViewModel for managing UI-related data in a lifecycle-conscious way.
) {
    // Define a composable route in the navigation graph.
    composable(
        route = USER_PROFILE_SCREEN, // The route identifier for the user profile screen.
    ) {
        // Render the UserProfileScreen composable, passing the ViewModel as a parameter.
        UserProfileScreen(gitHubViewModel)
    }
}
