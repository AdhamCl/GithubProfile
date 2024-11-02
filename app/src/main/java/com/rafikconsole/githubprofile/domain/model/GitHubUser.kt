package com.rafikconsole.githubprofile.domain.model

import com.google.gson.annotations.SerializedName

// Data class representing a GitHub user, containing various attributes associated with a user's profile.
data class GitHubUser(
    val login: String, // The GitHub username or login name of the user.

    // The user's avatar URL, mapped from the JSON field "avatar_url".
    @SerializedName("avatar_url")
    val avatarUrl: String, // The URL to the user's avatar image.

    // The user's GitHub profile URL, mapped from the JSON field "html_url".
    @SerializedName("html_url")
    val htmlUrl: String, // The URL to the user's GitHub profile page.

    val type: String, // The type of user (e.g., "User" or "Organization").

    val name: String?, // The user's real name, which can be null if not provided.

    val company: String?, // The company where the user works, can be null if not provided.

    val blog: String?, // The user's personal blog or website, can be null.

    val location: String?, // The user's location, can be null if not specified.

    val email: String?, // The user's email address, can be null if the user chose not to share it.

    val hireable: Boolean?, // A flag indicating whether the user is open to job opportunities, can be null.

    val bio: String?, // A brief biography of the user, can be null if not provided.

    // The user's Twitter username, mapped from the JSON field "twitter_username".
    @SerializedName("twitter_username")
    val twitter: String?, // The user's Twitter handle, can be null if not provided.

    // The number of public repositories the user has, mapped from the JSON field "public_repos".
    @SerializedName("public_repos")
    val publicRepos: Int, // The number of public repositories owned by the user.

    // The number of public gists the user has, mapped from the JSON field "public_gists".
    @SerializedName("public_gists")
    val publicGists: Int, // The number of public gists owned by the user.

    val followers: Int, // The number of followers the user has.

    val following: Int, // The number of users the user is following.

    // The date when the user created their GitHub account, mapped from the JSON field "created_at".
    @SerializedName("created_at")
    val createdAt: String, // The account creation timestamp.

    // The date when the user's profile was last updated, mapped from the JSON field "updated_at".
    @SerializedName("updated_at")
    val updatedAt: String // The timestamp for the most recent update to the user's profile.
)
