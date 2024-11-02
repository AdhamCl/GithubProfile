package com.rafikconsole.githubprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rafikconsole.githubprofile.presentation.theme.GithubProfileTheme
import com.rafikconsole.githubprofile.presentation.viewmodel.GitHubViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rafikconsole.githubprofile.presentation.navigation.SetupNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val gitHubViewModel: GitHubViewModel by viewModels()
    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubProfileTheme {
                    navController = rememberNavController()
                    SetupNavigation(navController,gitHubViewModel)
            }
        }
    }
}





