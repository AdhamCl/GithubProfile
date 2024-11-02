package com.rafikconsole.githubprofile.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.presentation.theme.LARGE_PADDING
import com.rafikconsole.githubprofile.presentation.theme.MEDIUM_WIDTH
import com.rafikconsole.githubprofile.presentation.theme.ORG_IMAGE_SIZE
import com.rafikconsole.githubprofile.presentation.theme.SMALL_PADDING
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import com.rafikconsole.githubprofile.presentation.theme.TitleColor

@Composable
fun OrganizationItem(
    org: GitHubOrg, // The GitHub organization data
    onOrganizationClick: (String) -> Unit // Callback function to handle organization click events
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, // Align items vertically in the center
        modifier = Modifier
            .fillMaxWidth() // Make the row fill the maximum width
            .padding(vertical = SMALL_PADDING, horizontal = LARGE_PADDING) // Add padding around the row
            .clickable { onOrganizationClick(org.login) } // Make the row clickable and invoke callback with org.login
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = org.avatarUrl), // Load the organization's avatar
            contentDescription = stringResource(R.string.organizationAvatar), // Description for accessibility
            modifier = Modifier
                .size(ORG_IMAGE_SIZE) // Set the size for the organization image
                .clip(CircleShape)  // Clip the image to a circle shape
                .background(Color.Gray.copy(alpha = 0.2f)), // Add a light gray background with some transparency
            contentScale = ContentScale.Crop // Crop the image to fit the bounds
        )

        Spacer(modifier = Modifier.width(MEDIUM_WIDTH)) // Add space between the image and text

        Column(
            modifier = Modifier.fillMaxWidth() // Make the column fill the maximum width
        ) {
            Text(
                text = org.login, // Display the organization's login name
                style = MaterialTheme.typography.titleMedium, // Use titleMedium style for the organization name
                fontWeight = FontWeight.Bold, // Make the organization name bold
                color = TitleColor // Set the color for the organization name
            )

            Spacer(modifier = Modifier.height(4.dp)) // Add space below the organization name

            org.description?.let { // Check if description exists
                Text(
                    text = it, // Display the organization's description
                    color = TextColor, // Set the color for the description text
                    style = MaterialTheme.typography.bodyMedium, // Use bodyMedium style for the description
                    maxLines = 2, // Limit the description to two lines
                    overflow = TextOverflow.Ellipsis  // Show ellipsis if the text overflows
                )
            }
        }
    }
}
