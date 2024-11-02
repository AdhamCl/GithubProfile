package com.rafikconsole.githubprofile.domain.model

import com.google.gson.annotations.SerializedName

// Data class representing a GitHub repository, containing various attributes associated with a repository.
data class GitHubRepo(
    val name: String, // The name of the repository.

    // The owner of the repository, which is a GitHubUser object representing the repository's owner.
    val owner: GitHubUser, // The owner of the repository, which is important for identifying the repository creator or organization.

    // The repository's HTML URL, mapped from the JSON field "html_url".
    @SerializedName("html_url")
    val htmlUrl: String, // The URL to the repository's GitHub page.

    val description: String?, // An optional description of the repository. It can be null if no description is provided.

    val fork: Boolean, // A boolean flag indicating whether the repository is a fork of another repository.

    // The repository's creation timestamp, mapped from the JSON field "created_at".
    @SerializedName("created_at")
    val createdAt: String, // The timestamp for when the repository was created.

    // The repository's last updated timestamp, mapped from the JSON field "updated_at".
    @SerializedName("updated_at")
    val updatedAt: String, // The timestamp for the most recent update to the repository.

    // The repository's last push timestamp, mapped from the JSON field "pushed_at".
    @SerializedName("pushed_at")
    val pushedAt: String, // The timestamp for the most recent push to the repository.

    val stargazersCount: Int, // The number of users who have starred the repository.

    val watchersCount: Int, // The number of users watching the repository.

    val language: String?, // The main programming language used in the repository. It can be null if unspecified.

    // The number of forks of this repository, mapped from the JSON field "forks_count".
    @SerializedName("forks_count")
    val forksCount: Int, // The number of forks of the repository.

    // The number of open issues in the repository, mapped from the JSON field "open_issues_count".
    @SerializedName("open_issues_count")
    val openIssuesCount: Int, // The number of open issues in the repository.

    val visibility: String, // The visibility of the repository (e.g., "public", "private").

    val watchers: Int, // The total number of watchers of the repository, which may be different from watchersCount.

    // The default branch of the repository, mapped from the JSON field "default_branch".
    @SerializedName("default_branch")
    val defaultBranch: String // The default branch (e.g., "main", "master") of the repository.
)
