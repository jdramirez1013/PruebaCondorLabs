package co.com.jdr.pruebacondorlabs.data.model

import com.google.gson.annotations.SerializedName

data class ResponseGetTeams (
    @SerializedName("teams")
    var teams : List<Team> = arrayListOf()
)