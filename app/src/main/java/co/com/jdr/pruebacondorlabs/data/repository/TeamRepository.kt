package co.com.jdr.pruebacondorlabs.data.repository

import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.data.network.ApiService
import javax.inject.Inject

class TeamRepository @Inject constructor(val api: ApiService) {

    suspend fun getTeams(league: String): List<Team>{
        return api.getTeams(league)
    }

}