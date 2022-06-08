package com.example.data

import com.example.data.api.ArtObjectAPIService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtObjectAPIServiceTest {
    private lateinit var service: ArtObjectAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder().baseUrl(server.url("")).addConverterFactory(GsonConverterFactory.create()).build().create(ArtObjectAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(
        fileName: String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getCollections_sentRequest_receivedExpected(){
        runBlocking{
            enqueueMockResponse("artobjectsresponse.json")
            val responseBody = service.getArtObjects(language = "en", page = 1, pageRange = 10)
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).contains("/api/en/collection?key=")
            println(responseBody.body()?.artObjects?.get(1)?.headerImage?.guid)
        }
    }

    @Test
    fun getCollections_receivedResponse_correctContent(){
        runBlocking{
            enqueueMockResponse("artobjectsresponse.json")
            val responseBody = service.getArtObjects(language = "en", page = 1, pageRange = 10).body()
            val artList = responseBody!!.artObjects
            val art = artList[0]
            assertThat(art.principalOrFirstMaker).isEqualTo("Abraham Roentgen")
            assertThat(art.id).isEqualTo("nl-BK-16676")
        }
    }
}
