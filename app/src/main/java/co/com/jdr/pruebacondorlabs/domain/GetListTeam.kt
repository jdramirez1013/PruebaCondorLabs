package co.com.jdr.pruebacondorlabs.domain

import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.data.repository.TeamRepository
import javax.inject.Inject


class GetListTeam @Inject constructor(var teamRepository: TeamRepository) {

    suspend fun getTeam(league: String): List<Team>{
        return teamRepository.getTeams(league)
    }

}