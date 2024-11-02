package com.rafikconsole.githubprofile.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafikconsole.githubprofile.presentation.state.GitHubProfileState
import com.rafikconsole.githubprofile.domain.usecase.FetchGitHubUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.rafikconsole.githubprofile.domain.Result

@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val fetchGitHubUserUseCase: FetchGitHubUserUseCase
) : ViewModel() {

    var state by mutableStateOf(GitHubProfileState())
        private set

    fun fetchUserProfile(username: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            // Call the use case
            when (val result = fetchGitHubUserUseCase(username)) {
                is Result.Success -> {
                    state = result.data // Update the state with the successful result
                }
                is Result.Failure -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.exception.message ?: "Unexpected error occurred."
                    )
                }

            }
        }
    }
}