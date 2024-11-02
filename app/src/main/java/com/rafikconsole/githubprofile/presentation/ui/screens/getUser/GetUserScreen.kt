package com.rafikconsole.githubprofile.presentation.ui.screens.getUser


import androidx.compose.runtime.Composable
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.WindowType
import com.rafikconsole.githubprofile.utils.rememberWindowSize

@Composable
fun GetUserScreen(
    gitHubViewModel: GitHubViewModel, // ViewModel for GitHub data
    navigateToUserProfileScreen: () -> Unit // Callback for navigating to the user profile screen
) {
    val windowSize = rememberWindowSize() // Get the current window size
    when (windowSize.width) { // Check the width of the window
        WindowType.Compact -> CompactGetUserScreen(gitHubViewModel, navigateToUserProfileScreen) // Render compact UI for small screens
        else -> MediumToExpandedGetUserScreen(gitHubViewModel, navigateToUserProfileScreen) // Render medium to expanded UI for larger screens
    }
}
