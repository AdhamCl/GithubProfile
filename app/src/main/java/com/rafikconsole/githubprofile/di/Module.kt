package com.rafikconsole.githubprofile.di

import com.rafikconsole.githubprofile.data.remote.GitHubApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// This is a Dagger module responsible for providing network-related dependencies such as Retrofit, OkHttp, and Gson.
@Module
@InstallIn(SingletonComponent::class) // Specifies that this module should be installed in the SingletonComponent, meaning the provided dependencies will have an application-wide singleton scope.
object NetworkModule {

    // Base URL for the GitHub API, used in the Retrofit setup.
    private const val BASE_URL = "https://api.github.com/"

    // Provides a singleton instance of Gson, a library for serializing/deserializing JSON objects.
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create() // Creates a Gson instance using a GsonBuilder.

    // Provides a singleton instance of OkHttpClient, a client for making HTTP requests.
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        // Logging interceptor to log the HTTP requests and responses. It logs basic information like request URL and method.
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC // Logs basic details of the HTTP requests and responses.
        }

        // Builds and returns an OkHttpClient with the logging interceptor added.
        return OkHttpClient.Builder()
            .addInterceptor(logging) // Adds the logging interceptor to the client.
            .build() // Builds the OkHttpClient instance.
    }

    // Provides a singleton instance of Retrofit, a type-safe HTTP client for making API requests.
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Sets the base URL for the GitHub API.
            .addConverterFactory(GsonConverterFactory.create(gson)) // Adds a converter for JSON (using Gson) to parse API responses.
            .client(client) // Sets the OkHttpClient for handling HTTP requests.
            .build() // Builds the Retrofit instance.

    // Provides a singleton instance of GitHubApi, the interface that defines the API endpoints.
    @Provides
    @Singleton
    fun provideGitHubApiService(retrofit: Retrofit): GitHubApi =
        retrofit.create(GitHubApi::class.java) // Creates and returns an implementation of GitHubApi using Retrofit.
}