package com.rafikconsole.githubprofile.presentation.state

import com.rafikconsole.githubprofile.domain.model.GitHubFollower
import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.domain.model.GitHubRepo
import com.rafikconsole.githubprofile.domain.model.GitHubUser

// Data class representing the state of a GitHub user profile in the application.
data class GitHubProfileState(
    val user: GitHubUser? = null, // The GitHub user profile data; nullable to handle cases where the user data is not available.
    val repos: List<GitHubRepo> = emptyList(), // A list of repositories owned by the user; defaults to an empty list if not provided.
    val followers: List<GitHubFollower> = emptyList(), // A list of followers of the user; defaults to an empty list.
    val following: List<GitHubFollower> = emptyList(), // A list of users that the user is following; defaults to an empty list.
    val organizations: List<GitHubOrg> = emptyList(), // A list of organizations the user belongs to; defaults to an empty list.
    val isLoading: Boolean = false, // Indicates whether the profile data is currently being loaded; defaults to false.
    val error: String? = null // An optional error message; nullable to indicate the absence of an error.
)
