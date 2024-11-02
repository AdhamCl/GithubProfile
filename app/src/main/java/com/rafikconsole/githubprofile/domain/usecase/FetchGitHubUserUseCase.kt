package com.rafikconsole.githubprofile.domain.usecase

import com.rafikconsole.githubprofile.presentation.state.GitHubProfileState
import com.rafikconsole.githubprofile.data.repository.GitHubRepositoryImpl
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.rafikconsole.githubprofile.domain.Result

// Use case class responsible for fetching a GitHub user's profile data from the repository.
class FetchGitHubUserUseCase @Inject constructor(
    private val repository: GitHubRepositoryImpl // Injecting the GitHubRepositoryImpl dependency.
) {
    // The invoke function is used to fetch the user's profile data by username.
    // It returns a Result wrapping either a GitHubProfileState or an error.
    suspend operator fun invoke(username: String): Result<GitHubProfileState> {
        return try {
            // Fetch user data from the repository.
            val fetchedUser = repository.getUser(username)
            // Fetch user's repositories from the repository.
            val fetchedRepos = repository.getUserRepos(username)
            // Fetch user's followers from the repository.
            val fetchedFollowers = repository.getUserFollowers(username)
            // Fetch users that the given user is following from the repository.
            val fetchedFollowing = repository.getUserFollowing(username)
            // Fetch user's organizations from the repository.
            val fetchedOrgs = repository.getUserOrgS(username)

            // Creating the profile state with the fetched data.
            val state = GitHubProfileState(
                user = fetchedUser, // User's profile data.
                repos = fetchedRepos, // List of repositories.
                followers = fetchedFollowers, // List of followers.
                following = fetchedFollowing, // List of following users.
                organizations = fetchedOrgs, // List of user's organizations.
                isLoading = false, // Data loading is complete.
                error = null // No error occurred.
            )
            // Return a successful result with the populated state.
            Result.Success(state)
        } catch (e: IOException) {
            // Catch network-related errors (e.g., no internet) and return a failure result.
            Result.Failure(IOException("Network error. Please check your connection."))
        } catch (e: HttpException) {
            // Catch HTTP exceptions (e.g., server errors or not found).
            if (e.code() == 404) {
                // If user is not found (404), return a user not found error.
                Result.Failure(Exception("User not found."))
            } else {
                // For other server errors, return a generic server error message.
                Result.Failure(Exception("Server error. Please try again after one hour."))
            }
        } catch (e: Exception) {
            // Catch any other unexpected errors and return a generic error message.
            Result.Failure(Exception("Unexpected error occurred."))
        }
    }
}
