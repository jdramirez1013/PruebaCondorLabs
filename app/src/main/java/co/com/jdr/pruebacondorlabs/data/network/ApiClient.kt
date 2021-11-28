package co.com.jdr.pruebacondorlabs.data.network

import co.com.jdr.pruebacondorlabs.data.model.ResponseGetTeams
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("gateway/process")
    suspend fun getTeams(): Response<ResponseGetTeams>

}