package co.com.jdr.pruebacondorlabs.data.network

import co.com.jdr.pruebacondorlabs.data.model.ResponseGetTeams
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("v1/json/2/search_all_teams.php")
    suspend fun getTeams(@Query("l") league: String): Response<ResponseGetTeams>

}