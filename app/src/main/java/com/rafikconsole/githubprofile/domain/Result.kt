package com.rafikconsole.githubprofile.domain

// Sealed class representing the result of an operation, either a success or a failure.
sealed class Result<out T> {
    // Data class representing a successful operation with a generic data type.
    data class Success<out T>(val data: T) : Result<T>()

    // Data class representing a failed operation with an exception.
    data class Failure(val exception: Exception) : Result<Nothing>()
}
