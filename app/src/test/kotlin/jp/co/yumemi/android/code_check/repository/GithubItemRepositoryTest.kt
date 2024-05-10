package jp.co.yumemi.android.code_check.repository

import jp.co.yumemi.android.code_check.model.GithubRepoSearchResponse
import jp.co.yumemi.android.code_check.network.GithubApiService
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

/**
 * A test suite for GithubItemRepository that checks the repository's response handling.
 *
 * This class tests the GithubItemRepository's ability to process and handle data fetched from the Github API service.
 * Includes tests for successful data retrieval, handling of empty data responses, and error conditions
 * like HTTP 404 responses.
 *
 * @see GithubItemRepository
 */
@RunWith(MockitoJUnitRunner::class)
class GithubItemRepositoryTest {

    @Mock
    private lateinit var itemApiService: GithubApiService

    private lateinit var githubItemRepository: GithubItemRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        githubItemRepository = GithubItemRepository(itemApiService)
    }

    /**
     * Test case to verify successful fetching of GitHub repository information.
     */
    @Test
    fun `test getGithubRepoInfo returns success response with data`() = runBlocking {
        val searchText = "android"
        val fakeResponse = GithubRepoSearchResponse(10, false, listOf())

        Mockito.`when`(itemApiService.getItems(searchText)).thenReturn(Response.success(fakeResponse))

        // When
        val result = githubItemRepository.getGithubRepoInfo(searchText)

        // Then
        assertNotNull(result)
        assertEquals(fakeResponse, result)
    }

    /**
     * Test case to verify fetching of GitHub repository information with no data.
     */
    @Test
    fun `test getGithubRepoInfo returns success response without data`() = runBlocking {
        val searchText = "empty"
        val fakeResponse = GithubRepoSearchResponse(0, false, listOf())

        Mockito.`when`(itemApiService.getItems(searchText)).thenReturn(Response.success(fakeResponse))

        // When
        val result = githubItemRepository.getGithubRepoInfo(searchText)

        // Then
        assertNotNull(result)
        assertTrue(result?.items?.isEmpty() ?: false)
    }

    /**
     * Tests that getGithubRepoInfo returns null when the API response is not successful.
     * This simulates receiving an error from the API (e.g., HTTP 404 Not Found) and checks
     * that the repository correctly handles this by returning null, indicating no data was fetched.
     */
    @Test
    fun `test getGithubRepoInfo handles errors`() = runBlocking {
        val searchText = "error"
        val errorResponse = Response.error<GithubRepoSearchResponse>(
            404, ResponseBody.create(null, "Not Found")
        )

        Mockito.`when`(itemApiService.getItems(searchText)).thenReturn(errorResponse)

        // When
        val result = githubItemRepository.getGithubRepoInfo(searchText)

        // Then
        assertNull(result)
    }
}