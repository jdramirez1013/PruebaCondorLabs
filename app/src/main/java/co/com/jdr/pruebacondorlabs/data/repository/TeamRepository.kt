package co.com.jdr.pruebacondorlabs.data.repository

import co.com.jdr.pruebacondorlabs.data.local.TeamDAO
import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.data.network.ApiService
import javax.inject.Inject

class TeamRepository @Inject constructor(val api: ApiService, val teamDAO: TeamDAO) {

    suspend fun getTeams(league: String): List<Team>{

        val localList = teamDAO.findByLeague(league)

        if(localList.isNotEmpty()){
            return  localList
        }

        val response = api.getTeams(league)

        response.forEach {
            teamDAO.InsertData(it)
        }

        return response
    }

}