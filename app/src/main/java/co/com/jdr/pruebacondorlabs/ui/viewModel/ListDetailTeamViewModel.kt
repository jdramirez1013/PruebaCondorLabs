package co.com.jdr.pruebacondorlabs.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.com.jdr.pruebacondorlabs.data.model.Team
import javax.inject.Inject

class ListDetailTeamViewModel @Inject constructor(): ViewModel() {

    val teamSelected= MutableLiveData<Team>()

    fun selectedTeam(team: Team) {
        teamSelected.value = team
    }
}