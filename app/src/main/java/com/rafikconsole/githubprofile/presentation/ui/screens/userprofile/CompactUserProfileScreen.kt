package com.rafikconsole.githubprofile.presentation.ui.screens.userprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rafikconsole.githubprofile.R
import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.presentation.theme.AppBackgroundColor
import com.rafikconsole.githubprofile.presentation.theme.ButtonColor
import com.rafikconsole.githubprofile.presentation.theme.EXTRA_LARGE_PADDING
import com.rafikconsole.githubprofile.presentation.theme.HorizontalDividerColor
import com.rafikconsole.githubprofile.presentation.theme.LARGE_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.LARGE_PADDING
import com.rafikconsole.githubprofile.presentation.theme.LARGE_WIDTH
import com.rafikconsole.githubprofile.presentation.theme.NoHireableColor
import com.rafikconsole.githubprofile.presentation.theme.SMALL_HEIGHT
import com.rafikconsole.githubprofile.presentation.theme.SMALL_PADDING
import com.rafikconsole.githubprofile.presentation.theme.TextColor
import com.rafikconsole.githubprofile.presentation.theme.TitleColor
import com.rafikconsole.githubprofile.presentation.theme.YesHireableColor
import com.rafikconsole.githubprofile.presentation.ui.components.CreatedAndUpdatedDates
import com.rafikconsole.githubprofile.presentation.ui.components.FollowersItem
import com.rafikconsole.githubprofile.presentation.ui.components.InformationRow
import com.rafikconsole.githubprofile.presentation.ui.components.OrganizationItem
import com.rafikconsole.githubprofile.presentation.ui.components.RepositoryItem
import com.rafikconsole.githubprofile.presentation.ui.components.SectionHeader
import com.rafikconsole.githubprofile.presentation.ui.components.StatisticItem
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import com.rafikconsole.githubprofile.utils.openEmail
import com.rafikconsole.githubprofile.utils.openUrl
import kotlinx.coroutines.launch


@Composable
fun CompactUserProfileScreen(
    gitHubViewModel: GitHubViewModel
) {
    // Get the current context and initialize scroll state for LazyColumn
    val context = LocalContext.current
    val scrollState = rememberLazyListState()

    // Retrieve user data from the ViewModel
    val user = gitHubViewModel.state.user
    val repos = gitHubViewModel.state.repos
    val followers = gitHubViewModel.state.followers
    val following = gitHubViewModel.state.following
    val organizations = gitHubViewModel.state.organizations
    val scope = rememberCoroutineScope() // Coroutine scope for managing asynchronous operations

    // Get screen configuration for responsive design
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    val gifSize = (screenWidthDp * 0.3f) // Set size for the user's avatar

    // Check if user data is available
    user?.let {
        // Create a LazyColumn for displaying user profile information
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .background(AppBackgroundColor) // Background color for the screen
                .padding(EXTRA_LARGE_PADDING) // General padding
                .padding(top = LARGE_PADDING) // Additional top padding
        ) {
            // Display user avatar and basic information
            item {
                Row(
                    modifier = Modifier.padding(SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // User avatar image
                    Image(
                        painter = rememberAsyncImagePainter(model = user.avatarUrl),
                        contentDescription = stringResource(R.string.avatar),
                        modifier = Modifier
                            .size(gifSize) // Set avatar size
                            .clip(CircleShape) // Clip the image to a circle
                            .background(Color.Gray.copy(alpha = 0.2f)), // Background color for avatar
                        contentScale = ContentScale.Crop // Scale content to fill the container
                    )

                    Spacer(modifier = Modifier.width(LARGE_WIDTH))

                    // User's name and login information
                    Column {
                        Text(
                            text = user.name ?: "N/A", // Display user name or default value
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge,
                            color = TitleColor
                        )
                        Text(
                            text = user.login,
                            color = TextColor,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))

                // Display user bio if available
                user.bio?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = LARGE_HEIGHT),
                        color = TextColor
                    )
                }

                // Information rows for location, company, blog, email, twitter, and hireable status
                user.location?.takeIf { it.isNotBlank() }?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.location),
                        label = stringResource(R.string.location),
                        value = user.location
                    )
                }
                user.company?.takeIf { it.isNotBlank() }?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.company),
                        label = stringResource(R.string.company),
                        value = user.company
                    )
                }
                user.blog?.takeIf { it.isNotBlank() }?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.blog),
                        label = stringResource(R.string.blog),
                        value = it,
                        isLink = true,
                        onClick = { openUrl(context, it) } // Open blog URL
                    )
                }
                user.email?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.email),
                        label = stringResource(R.string.email),
                        value = it,
                        isLink = true,
                        onClick = { openEmail(context, it) } // Open email client
                    )
                }
                user.twitter?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.twitter),
                        label = stringResource(R.string.twitter),
                        value = "@$it",
                        isLink = true,
                        onClick = {
                            openUrl(
                                context,
                                "https://twitter.com/$it"
                            )
                        } // Open Twitter profile
                    )
                }
                user.hireable?.let {
                    InformationRow(
                        icon = painterResource(R.drawable.hireable),
                        label = stringResource(R.string.hireable),
                        value = if (it) "Yes" else "No", // Display hireable status
                        valueColor = if (it) YesHireableColor else NoHireableColor
                    )
                }
            }

            // Divider between sections
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Display statistics about repositories, followers, following, organizations, and gists
            item {
                Text(
                    text = stringResource(R.string.statistics),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    color = TitleColor
                )
                Spacer(modifier = Modifier.height(SMALL_HEIGHT))

                // Row for statistics items
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatisticItem(
                        label = stringResource(R.string.repos),
                        count = user.publicRepos,
                        onClick = { scope.launch { scrollState.animateScrollToItem(4) } } // Scroll to repos section
                    )
                    StatisticItem(
                        label = stringResource(R.string.followers),
                        count = user.followers,
                        onClick = { scope.launch { scrollState.animateScrollToItem(6) } } // Scroll to followers section
                    )
                    StatisticItem(
                        label = stringResource(R.string.following),
                        count = user.following,
                        onClick = { scope.launch { scrollState.animateScrollToItem(8) } } // Scroll to following section
                    )
                    StatisticItem(
                        label = stringResource(R.string.orgs),
                        count = if (organizations.isEmpty()) 0 else organizations.size,
                        onClick = { scope.launch { scrollState.animateScrollToItem(10) } } // Scroll to organizations section
                    )
                    StatisticItem(
                        label = stringResource(R.string.gists),
                        count = user.publicGists,
                        onClick = { } // No action for gists
                    )
                }
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Button to view the user's GitHub profile
            item {
                Button(
                    onClick = { openUrl(context, user.htmlUrl) }, // Open user's GitHub profile
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonColor
                    )
                ) {
                    Text(
                        text = stringResource(R.string.viewGithub),
                        color = TitleColor,
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            // Divider between sections
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Section for repositories
            item {
                SectionHeader(title = stringResource(R.string.repositories))
                if (repos.isEmpty()) {
                    Text(
                        text = stringResource(R.string.noRepositoriesFound),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        color = TextColor
                    )
                } else {
                    repos.forEach { repo -> // Display each repository
                        RepositoryItem(repo = repo, context = context)
                    }
                }
            }

            // Divider between sections
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Section for followers
            item {
                SectionHeader(title = stringResource(R.string.followers))
                if (followers.isEmpty()) {
                    Text(
                        text = stringResource(R.string.noFollowersFound),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        color = TextColor
                    )
                } else {
                    // Group followers into chunks of 3 for display
                    followers.chunked(3).forEach { followerGroup ->
                        FollowersItem(
                            modifier = Modifier.fillMaxWidth(),
                            follower1 = followerGroup.getOrNull(0),
                            follower2 = followerGroup.getOrNull(1),
                            follower3 = followerGroup.getOrNull(2),
                            context = context
                        )
                    }
                }
            }

            // Divider between sections
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Section for following
            item {
                SectionHeader(title = stringResource(R.string.following))
                if (following.isEmpty()) {
                    Text(
                        text = stringResource(R.string.noFollowingAnyone),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        color = TextColor
                    )
                } else {
                    // Group following into chunks of 3 for display
                    following.chunked(3).forEach { followingGroup ->
                        FollowersItem(
                            modifier = Modifier.fillMaxWidth(),
                            follower1 = followingGroup.getOrNull(0),
                            follower2 = followingGroup.getOrNull(1),
                            follower3 = followingGroup.getOrNull(2),
                            context = context
                        )
                    }
                }
            }

            // Divider between sections
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            // Section for organizations
            item {
                SectionHeader(title = stringResource(R.string.organizations))
                if (organizations.isEmpty()) {
                    Text(
                        text = stringResource(R.string.noOrganizationsFound),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleSmall,
                        color = TextColor
                    )
                } else {
                    organizations.forEach { org ->
                        OrganizationItem(
                            org = GitHubOrg(
                                org.login,
                                org.avatarUrl,
                                org.description
                            ),
                            onOrganizationClick = { login ->
                                openUrl(context, "https://github.com/$login")
                            }
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
                HorizontalDivider(thickness = 1.dp, color = HorizontalDividerColor)
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))
            }

            item {
                CreatedAndUpdatedDates(
                    createdAt = user.createdAt,
                    updatedAt = user.updatedAt
                )
                Spacer(modifier = Modifier.height(LARGE_HEIGHT))

            }

        }
    }?: run {
        Text(
            text = stringResource(R.string.userNotFound),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            color = TitleColor
        )
    }
}
