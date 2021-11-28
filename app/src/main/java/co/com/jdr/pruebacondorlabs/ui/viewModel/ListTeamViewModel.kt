package co.com.jdr.pruebacondorlabs.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.data.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListTeamViewModel @Inject constructor(var teamRepository: TeamRepository): ViewModel() {

    var listTeam = MutableLiveData<List<Team>>()

    var isLoading = MutableLiveData<Boolean>()

    fun getTeams(league: String){
        isLoading.value = true
        viewModelScope.launch {
            val result = teamRepository.getTeams(league)
            listTeam.value = result
            isLoading.value = false
        }
    }
}