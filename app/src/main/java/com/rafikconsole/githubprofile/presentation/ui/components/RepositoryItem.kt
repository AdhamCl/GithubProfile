package com.rafikconsole.githubprofile.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.domain.model.GitHubRepo
import com.rafikconsole.githubprofile.presentation.theme.AppBackgroundColor
import com.rafikconsole.githubprofile.presentation.theme.EXTRA_SMALL_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.EXTRA_SMALL_PADDING
import com.rafikconsole.githubprofile.presentation.theme.MEDIUM_PADDING
import com.rafikconsole.githubprofile.presentation.theme.REPO_ICON_SIZE
import com.rafikconsole.githubprofile.presentation.theme.RepositoryItemBackgroundColor
import com.rafikconsole.githubprofile.presentation.theme.SMALL_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.SMALL_PADDING
import com.rafikconsole.githubprofile.presentation.theme.SMALL_ROUNDED_CORNER_SHAPE
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import com.rafikconsole.githubprofile.presentation.theme.TitleColor
import com.rafikconsole.githubprofile.presentation.theme.languageColors
import com.rafikconsole.githubprofile.utils.formatDate
import com.rafikconsole.githubprofile.utils.openUrl


@Composable
fun RepositoryItem(repo: GitHubRepo, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Make the column fill the maximum width
            .padding(vertical = SMALL_PADDING) // Add vertical padding
            .clickable { openUrl(context, repo.htmlUrl) } // Make the column clickable to open the repository URL
            .background(
                RepositoryItemBackgroundColor, // Set the background color for the repository item
                RoundedCornerShape(SMALL_ROUNDED_CORNER_SHAPE) // Apply rounded corners
            )
            .padding(MEDIUM_PADDING) // Add padding inside the column
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Align items vertically in the center
            modifier = Modifier.fillMaxWidth() // Make the row fill the maximum width
        ) {
            Text(
                text = repo.name, // Display the repository name
                fontWeight = FontWeight.Bold, // Make the name bold
                style = MaterialTheme.typography.bodyLarge, // Use bodyLarge style for the text
                modifier = Modifier.weight(1f), // Allow the text to take up available space
                maxLines = 1, // Limit to one line
                overflow = TextOverflow.Ellipsis, // Show ellipsis for overflow
                color = TitleColor // Set the color for the title
            )
            Box(
                modifier = Modifier
                    .background(color = AppBackgroundColor, shape = RoundedCornerShape(SMALL_ROUNDED_CORNER_SHAPE)) // Background color and shape
                    .border(BorderStroke(1.dp, TextColor), shape = RoundedCornerShape(SMALL_ROUNDED_CORNER_SHAPE)) // Border and shape
                    .padding(horizontal = SMALL_PADDING, vertical = EXTRA_SMALL_PADDING) // Padding inside the box
            ) {
                Text(
                    text = repo.visibility.uppercase(), // Display the repository visibility
                    style = MaterialTheme.typography.labelSmall, // Use labelSmall style
                    color = TextColor // Text color based on theme
                )
            }
        }

        repo.description?.let { // Check if description exists
            Spacer(modifier = Modifier.height(EXTRA_SMALL_HEIGHT)) // Add space below the row
            Text(
                text = it, // Display the repository description
                style = MaterialTheme.typography.bodyMedium, // Use bodyMedium style for the description
                color = TextColor // Set the color for the description text
            )
        }

        Spacer(modifier = Modifier.height(SMALL_HEIGHT)) // Add space below the description

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // Arrange items with space between them
            modifier = Modifier.fillMaxWidth() // Make the row fill the maximum width
        ) {
            repo.language?.let { language -> // Check if language exists
                Row(verticalAlignment = Alignment.CenterVertically) { // Align items vertically in the center
                    // Draw the circle
                    val textColor = TextColor
                    Canvas(
                        modifier = Modifier
                            .size(REPO_ICON_SIZE) // Circle size
                            .padding(end = EXTRA_SMALL_PADDING) // Space between circle and text
                    ) {
                        // Use the color for the language, or a default color if not found
                        drawCircle(
                            color = languageColors[language] ?: textColor // Default color if language not found
                        )
                    }

                    // Display the language name
                    Text(
                        text = "Language: $language", // Display the language
                        style = MaterialTheme.typography.bodySmall, // Use bodySmall style
                        color = TextColor // Set the color for the text
                    )
                }
            }

            Row {
                Icon(
                    painter = painterResource(id = R.drawable.eye), // Your star icon
                    contentDescription = "view", // Description for accessibility
                    modifier = Modifier.size(REPO_ICON_SIZE), // Adjust size as needed
                    tint = TextColor // Set icon color
                )
                Text(
                    text = "${repo.stargazersCount}", // Display the stargazers count
                    style = MaterialTheme.typography.bodySmall, // Use bodySmall style
                    color = TextColor, // Set the color for the text
                    modifier = Modifier.padding(start = EXTRA_SMALL_PADDING) // Add padding between icon and text
                )
            }

            Row {
                Icon(
                    painter = painterResource(id = R.drawable.fork), // Your fork icon
                    contentDescription = "Forks", // Description for accessibility
                    modifier = Modifier.size(REPO_ICON_SIZE), // Adjust size as needed
                    tint = TextColor // Set icon color
                )
                Text(
                    text = "${repo.forksCount}", // Display the forks count
                    style = MaterialTheme.typography.bodySmall, // Use bodySmall style
                    color = TextColor, // Set the color for the text
                    modifier = Modifier.padding(start = EXTRA_SMALL_PADDING) // Add padding between icon and text
                )
            }
        }

        Spacer(modifier = Modifier.height(SMALL_HEIGHT)) // Add space below the stats

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // Arrange items with space between them
            modifier = Modifier.fillMaxWidth() // Make the row fill the maximum width
        ) {
            Text(
                text = "Updated: ${formatDate(repo.updatedAt)}", // Display the last updated date
                style = MaterialTheme.typography.bodySmall, // Use bodySmall style
                color = TitleColor // Set the color for the text
            )

            Text(
                text = "Created: ${formatDate(repo.createdAt)}", // Display the created date
                style = MaterialTheme.typography.bodySmall, // Use bodySmall style
                color = TextColor // Set the color for the text
            )
        }
    }
}
