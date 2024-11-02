package com.rafikconsole.githubprofile.data.remote

import com.rafikconsole.githubprofile.domain.model.GitHubFollower
import com.rafikconsole.githubprofile.domain.model.GitHubOrg
import com.rafikconsole.githubprofile.domain.model.GitHubRepo
import com.rafikconsole.githubprofile.domain.model.GitHubUser
import retrofit2.http.GET
import retrofit2.http.Path

// Interface defining API endpoints to interact with GitHub's user-related data.
interface GitHubApi {

    // Function to get a user's profile data.
    // The @GET annotation defines the API endpoint, with {username} being a dynamic path parameter.
    // It suspends the function, meaning it can be called asynchronously in a coroutine.
    @GET("users/{username}")
    suspend fun getUserProfile(
        @Path("username") username: String // The username is passed as a dynamic part of the URL.
    ): GitHubUser // The response is expected to be parsed into a GitHubUser data class.

    // Function to get a list of repositories belonging to a user.
    // Similar to getUserProfile, it retrieves the user's repos based on the username provided.
    @GET("users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String
    ): List<GitHubRepo> // The response is a list of GitHubRepo objects.

    // Function to get the list of followers for a specific user.
    // The @GET annotation defines the endpoint for retrieving followers.
    @GET("users/{username}/followers")
    suspend fun getUserFollowers(
        @Path("username") username: String
    ): List<GitHubFollower> // The response is a list of GitHubFollower objects.

    // Function to get the list of users the specified user is following.
    // The path includes the username, and the response is a list of followers the user is following.
    @GET("users/{username}/following")
    suspend fun getUserFollowing(
        @Path("username") username: String
    ): List<GitHubFollower> // The response is a list of GitHubFollower objects.

    // Function to get the list of organizations the user belongs to.
    // The @GET annotation defines the endpoint for fetching the organizations.
    @GET("users/{username}/orgs")
    suspend fun getUserOrgS(
        @Path("username") username: String
    ): List<GitHubOrg> // The response is a list of GitHubOrg objects.
}