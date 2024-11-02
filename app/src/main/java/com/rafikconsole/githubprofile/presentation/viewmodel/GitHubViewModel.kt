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


}
