package com.rafikconsole.githubprofile.domain.model

import com.google.gson.annotations.SerializedName

// Data class representing a GitHub organization, containing attributes associated with an organization.
data class GitHubOrg(
    val login: String, // The login or name of the GitHub organization.

    // The organization's avatar URL, mapped from the JSON field "avatar_url" using @SerializedName.
    @SerializedName("avatar_url")
    val avatarUrl: String, // The URL to the avatar image of the organization.

    val description: String? // An optional description of the organization. It can be null if no description is available.
)
