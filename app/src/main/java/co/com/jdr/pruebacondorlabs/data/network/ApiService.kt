package co.com.jdr.pruebacondorlabs.data.network

import co.com.jdr.pruebacondorlabs.data.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(val apiClient: ApiClient) {


    suspend fun getTeams(league: String): List<Team> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getTeams(league)
            response.body()?.teams ?: arrayListOf()
        }
    }


}