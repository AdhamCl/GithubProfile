package com.rafikconsole.githubprofile.domain.repository

import com.rafikconsole.githubprofile.domain.model.GitHubFollower
import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.domain.model.GitHubRepo
import com.rafikconsole.githubprofile.domain.model.GitHubUser

// Interface defining a repository that handles data retrieval for GitHub-related operations.
interface GitHubRepository {

    // Function to get a user's profile data.
    // The function is suspending, meaning it can be executed asynchronously.
    suspend fun getUser(
        username: String // Accepts the username to retrieve the user's profile data.
    ): GitHubUser // Returns the user's profile as a GitHubUser object.

    // Function to retrieve the list of repositories for a user.
    // It also suspends the function to ensure it's called asynchronously.
    suspend fun getUserRepos(
        username: String // Accepts the username to fetch the user's repositories.
    ): List<GitHubRepo> // Returns a list of repositories as GitHubRepo objects.

    // Function to get the list of followers for a specific user.
    // The function is suspending to support async operations.
    suspend fun getUserFollowers(
        username: String // The username for which followers need to be fetched.
    ): List<GitHubFollower> // Returns a list of followers as GitHubFollower objects.

    // Function to get the list of users the specified user is following.
    // Like other functions, it is suspending for asynchronous execution.
    suspend fun getUserFollowing(
        username: String // Accepts the username to retrieve the following list.
    ): List<GitHubFollower> // Returns a list of followed users as GitHubFollower objects.

    // Function to retrieve the list of organizations the user is part of.
    // This function is suspending as well to handle async operations.
    suspend fun getUserOrgS(
        username: String // The username for which organizations need to be fetched.
    ): List<GitHubOrg> // Returns a list of organizations as GitHubOrg objects.
}