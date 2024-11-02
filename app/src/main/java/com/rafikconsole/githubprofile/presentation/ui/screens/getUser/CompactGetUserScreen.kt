package com.rafikconsole.githubprofile.presentation.ui.screens.getUser

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getDrawable
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.presentation.theme.AppBackgroundColor
import com.rafikconsole.githubprofile.presentation.theme.ButtonColor
import com.rafikconsole.githubprofile.presentation.theme.ErrorColor
import com.rafikconsole.githubprofile.presentation.theme.LARGE_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.LARGE_PADDING
import com.rafikconsole.githubprofile.presentation.theme.SMALL_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.TitleColor
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.rememberImeState
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@SuppressLint("SuspiciousIndentation")
@Composable
fun CompactGetUserScreen(
    gitHubViewModel: GitHubViewModel, // ViewModel for GitHub data
    navigateToUserProfileScreen: () -> Unit // Callback for navigating to the user profile screen
) {
    var username by remember { mutableStateOf("") } // State to hold the username input
    val focusManager = LocalFocusManager.current // To manage focus for the keyboard
    val keyboardController =
        LocalSoftwareKeyboardController.current // Controller for the software keyboard
    val state = gitHubViewModel.state // Get the current state from ViewModel

    val configuration = LocalConfiguration.current // Get the current configuration
    val screenWidthDp = configuration.screenWidthDp.dp // Get screen width in dp
    val gifSize = (screenWidthDp * 0.7f) // Calculate GIF size based on screen width
    val context = LocalContext.current // Get the current context

    val imeState = rememberImeState() // Remember the state of the IME (keyboard)
    val scrollState = rememberScrollState() // State for managing scroll

    LaunchedEffect(key1 = imeState.value) { // Launch effect when IME state changes
        if (imeState.value) // If keyboard is shown
            scrollState.scrollTo(scrollState.maxValue) // Scroll to the bottom
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBackgroundColor) // Set background color
            .imePadding() // Adjust for IME padding
            .verticalScroll(scrollState) // Make column scrollable
            .padding(LARGE_PADDING), // Add padding
        verticalArrangement = Arrangement.Center, // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        val gifDrawable = remember { // Remember GIF drawable
            getDrawable(context, R.drawable.github)
        }

        Image(
            modifier = Modifier
                .clip(CircleShape) // Clip image to a circle
                .size(gifSize), // Set image size
            painter = rememberDrawablePainter(drawable = gifDrawable), // Load drawable as painter
            contentDescription = "Loading animation", // Accessibility description
            contentScale = ContentScale.FillWidth // Scale to fill width
        )

        var showTooltip by remember { mutableStateOf(false) } // State for tooltip visibility
      Column {
        OutlinedTextField(
            value = username, // Current username value
            onValueChange = { username = it }, // Update username on change
            label = { Text(stringResource(R.string.gitUserName)) }, // Label for the text field
            modifier = Modifier.fillMaxWidth(), // Make text field full width
            maxLines = 1, // Single line input
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text // Set keyboard type to text
            ),
            singleLine = true, // Force single line input
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = TitleColor,
                unfocusedTextColor = TitleColor,
                focusedBorderColor = TitleColor,
                unfocusedBorderColor = TitleColor,
                focusedLabelColor = TitleColor,
                unfocusedLabelColor = TitleColor,
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Info",
                    modifier = Modifier.clickable { showTooltip = !showTooltip },
                    tint = TitleColor
                )
            }
        )
          Spacer(modifier = Modifier.height(SMALL_HEIGHT)) // Space between elements

          if (showTooltip) {
            Text(
                text = "Enter a GitHub username (e.g., \"adhamcl\")",
                color = TitleColor,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
      }

        Spacer(modifier = Modifier.height(SMALL_HEIGHT)) // Space between elements

        Button(
            onClick = { // Button click action
                if (username.isNotBlank()) { // Check if username is not blank
                    gitHubViewModel.fetchUserProfile(username) // Fetch user profile
                    focusManager.clearFocus() // Clear focus from the text field
                    keyboardController?.hide() // Hide the keyboard
                }
            },
            shape = RoundedCornerShape(8.dp), // Rounded corners for button
            modifier = Modifier.fillMaxWidth(), // Make button full width
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor // Set button color
            )
        ) {
            Text(
                text = stringResource(R.string.getProfile), // Button text
                color = TitleColor, // Text color
                fontWeight = FontWeight.Medium, // Font weight
                style = MaterialTheme.typography.bodyLarge // Text style
            )
        }

        Spacer(modifier = Modifier.height(LARGE_HEIGHT)) // Space between elements

        when { // Handle different states
            state.isLoading -> {
                CircularProgressIndicator() // Show loading indicator
            }

            state.error != null -> {
                Text(
                    text = state.error, // Show error message
                    color = ErrorColor, // Error text color
                    style = MaterialTheme.typography.bodyLarge // Text style
                )
            }

            state.user != null -> {
                navigateToUserProfileScreen() // Navigate to user profile if user is found
            }
        }
    }
}
