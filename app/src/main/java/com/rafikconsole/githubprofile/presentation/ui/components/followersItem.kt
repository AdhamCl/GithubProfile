package com.rafikconsole.githubprofile.presentation.ui.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.rafikconsole.githubprofile.domain.model.GitHubFollower
import com.rafikconsole.githubprofile.presentation.theme.FOLLOWERS_IMAGE_SIZE
import com.rafikconsole.githubprofile.presentation.theme.SMALL_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.SMALL_PADDING
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.presentation.theme.MEDIUM_PADDING
import com.rafikconsole.githubprofile.utils.openUrl




@Composable
fun FollowersItem(
    modifier: Modifier,
    follower1: GitHubFollower?,  // First follower, nullable type
    follower2: GitHubFollower?,  // Second follower, nullable type
    follower3: GitHubFollower?,  // Third follower, nullable type
    context: Context             // Context for clickable actions
) {
    Row(
        modifier = modifier
            .fillMaxWidth()           // Make the row fill the maximum width
            .padding(SMALL_PADDING),   // Apply small padding around the row
        verticalAlignment = Alignment.CenterVertically  // Center items vertically
    ) {
        // Display each follower in a weighted view to evenly distribute space
        FollowerView(follower1, context, Modifier.weight(1f))
        FollowerView(follower2, context, Modifier.weight(1f))
        FollowerView(follower3, context, Modifier.weight(1f))
    }
}

@Composable
fun FollowerView(follower: GitHubFollower?, context: Context, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clickable {    // Make the column clickable
                follower?.let { openUrl(context, it.htmlUrl) }  // Open follower's URL if not null
            }
            .padding(end = MEDIUM_PADDING),  // Apply medium padding to the right
        horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
    ) {
        // Check if the follower is not null before displaying
        if (follower != null) {
            Image(
                painter = rememberAsyncImagePainter(model = follower.avatarUrl),  // Load follower's avatar
                contentDescription = follower.login,  // Description for accessibility
                modifier = Modifier
                    .size(FOLLOWERS_IMAGE_SIZE)  // Set size for the image
                    .clip(CircleShape),           // Clip the image to a circle
                contentScale = ContentScale.Crop  // Crop the image to fit the bounds
            )

            Spacer(modifier = Modifier.height(SMALL_HEIGHT))  // Add space between the image and text

            Text(
                text = follower.login,  // Display follower's login name
                fontWeight = FontWeight.Bold,  // Make text bold
                color = TextColor,    // Set text color
                maxLines = 1,         // Limit to one line
                overflow = TextOverflow.Ellipsis,  // Show ellipsis if text overflows
                style = MaterialTheme.typography.titleSmall  // Use small title style for text
            )
        } else {
            Text(
                text = stringResource(R.string.empty),  // Display follower's login name
                fontWeight = FontWeight.Bold,  // Make text bold
                color = TextColor,    // Set text color
                overflow = TextOverflow.Ellipsis,  // Show ellipsis if text overflows
                style = MaterialTheme.typography.titleSmall  // Use small title style for text
            )
        }
    }
}
