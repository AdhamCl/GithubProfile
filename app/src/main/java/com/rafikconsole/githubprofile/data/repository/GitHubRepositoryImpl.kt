package com.rafikconsole.githubprofile.data.repository

import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.domain.model.GitHubRepo
import com.rafikconsole.githubprofile.domain.model.GitHubUser
import com.rafikconsole.githubprofile.data.remote.GitHubApi
import com.rafikconsole.githubprofile.domain.model.GitHubFollower
import com.rafikconsole.githubprofile.domain.repository.GitHubRepository
import javax.inject.Inject


// Implementation of the GitHubRepository interface, which interacts with the GitHubApi to fetch data.
class GitHubRepositoryImpl @Inject constructor(
    // The GitHubApi service is injected using Dagger's @Inject annotation for Dependency Injection.
    private val apiService: GitHubApi
) : GitHubRepository {

    // Function to fetch a user's profile data by calling the GitHubApi service's getUserProfile method.
    // The suspend keyword ensures this runs asynchronously within a coroutine.
    override suspend fun getUser(username: String): GitHubUser =
        apiService.getUserProfile(username) // Calls the API method to fetch the user's profile.

    // Function to fetch a list of repositories for the user.
    // This function calls the GitHubApi's getUserRepos method to retrieve the repositories.
    override suspend fun getUserRepos(username: String): List<GitHubRepo> =
        apiService.getUserRepos(username) // Calls the API method to get the user's repositories.

    // Function to fetch the list of followers for the user.
    // It makes an API call via the getUserFollowers method from GitHubApi.
    override suspend fun getUserFollowers(username: String): List<GitHubFollower> =
        apiService.getUserFollowers(username) // Calls the API method to get the user's followers.

    // Function to fetch the list of users that the given user is following.
    // It utilizes the getUserFollowing method from GitHubApi to retrieve the data.
    override suspend fun getUserFollowing(username: String): List<GitHubFollower> =
        apiService.getUserFollowing(username) // Calls the API method to get the list of users the user is following.

    // Function to fetch the list of organizations the user is part of.
    // This method calls the getUserOrgS function from GitHubApi to retrieve the organizations.
    override suspend fun getUserOrgS(username: String): List<GitHubOrg> =
        apiService.getUserOrgS(username) // Calls the API method to get the user's organizations.
}