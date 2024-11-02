package com.rafikconsole.githubprofile.presentation.ui.screens.userprofile


import androidx.compose.runtime.Composable
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.WindowType
import com.rafikconsole.githubprofile.utils.rememberWindowSize

@Composable
fun UserProfileScreen(
    gitHubViewModel: GitHubViewModel, // ViewModel to manage GitHub user data
) {
    // Determine the current window size (compact or larger)
    val windowSize = rememberWindowSize()

    // Based on window size, display the appropriate user profile screen layout
    when (windowSize.width) {
        WindowType.Compact -> // If the window is compact
            CompactUserProfileScreen(
                gitHubViewModel = gitHubViewModel, // Pass the ViewModel
            )

        else -> // For medium to expanded window sizes
            MediumToExpandedUserProfileScreen(
                gitHubViewModel = gitHubViewModel, // Pass the ViewModel
            )
    }
}
