package com.rafikconsole.githubprofile.domain.model

import com.google.gson.annotations.SerializedName

// Data class representing a GitHub follower, containing various attributes associated with a follower.
data class GitHubFollower(
    val login: String, // The username or login name of the GitHub follower.
    val id: Int, // The unique ID associated with the follower on GitHub.

    // The follower's avatar URL, mapped from the JSON field "avatar_url" using @SerializedName.
    @SerializedName("avatar_url")
    val avatarUrl: String, // The URL to the avatar image of the follower.

    // The follower's GitHub profile URL, mapped from the JSON field "html_url".
    @SerializedName("html_url")
    val htmlUrl: String, // The URL to the follower's GitHub profile page.

    val type: String, // The type of GitHub account (e.g., "User" or "Organization").

    // Whether the follower is a site administrator, mapped from the JSON field "site_admin".
    @SerializedName("site_admin")
    val siteAdmin: Boolean // A boolean flag indicating if the user is a GitHub site admin.
)
