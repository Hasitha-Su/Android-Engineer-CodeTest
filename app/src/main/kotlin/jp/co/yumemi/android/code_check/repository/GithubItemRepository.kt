package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.model.GithubRepoSearchResponse
import jp.co.yumemi.android.code_check.network.GithubApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Repository class responsible for fetching GitHub repository data.
 *
 * This class acts as an intermediary between the ViewModel and the GitHub API service.
 * It provides methods to fetch repository data from the remote data source using the provided API service.
 *
 * @param itemApiService The service interface for communicating with the GitHub API.
 *
 */
class GithubItemRepository @Inject constructor(
    private val itemApiService: GithubApiService
) {
    suspend fun getGithubRepoInfo(query: String): GithubRepoSearchResponse? =
        withContext(Dispatchers.IO) {
            getGithubRepositoryList(query)
        }

    /**
     * Fetches a list of GitHub repositories based on a search query.
     *
     * This method makes a network request to the GitHub API and returns the response body if the request is successful.
     * If the response is not successful (e.g., the server returns an error), this method returns null.
     *
     * @param query The search query string used to fetch repository information from GitHub.
     * @return A [GithubRepoSearchResponse] containing the search results if successful, or null if the request fails.
     */
    private suspend fun getGithubRepositoryList(query: String): GithubRepoSearchResponse? {
        val response = itemApiService.getItems(query)
        return if (response.isSuccessful) response.body() else null
    }
}
