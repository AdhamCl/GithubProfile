package com.rafikconsole.githubprofile.presentation.navigation.destination

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rafikconsole.githubprofile.presentation.ui.screens.getUser.GetUserScreen
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.Constants.GET_USER_SCREEN


// ExperimentalMaterial3Api annotation indicates that this function uses experimental APIs from Material 3.
@ExperimentalMaterial3Api
fun NavGraphBuilder.getUserComposable(
    gitHubViewModel: GitHubViewModel, // ViewModel for managing UI-related data in a lifecycle-conscious way.
    navigateToUserProfileScreen: () -> Unit // Lambda function for navigating to the user profile screen.
) {
    // Define a composable route in the navigation graph.
    composable(
        route = GET_USER_SCREEN, // The route identifier for the screen.
    ) {
        // Render the GetUserScreen composable, passing the ViewModel and navigation function as parameters.
        GetUserScreen(gitHubViewModel, navigateToUserProfileScreen)
    }
}
