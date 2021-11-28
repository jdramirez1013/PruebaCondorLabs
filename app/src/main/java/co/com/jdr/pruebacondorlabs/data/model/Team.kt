package co.com.jdr.pruebacondorlabs.data.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idTeam")
    var idTeam: String = "",

    @SerializedName("strTeam")
    var strTeam: String = "",

    @SerializedName("strLeague")
    var strLeague: String = "",

    @SerializedName("intFormedYear")
    var intFormedYear: String = "",

    @SerializedName("strDescriptionES")
    var strDescriptionES: String = "",

    @SerializedName("strStadium")
    var strStadium: String = "",

    @SerializedName("strTeamBadge")
    var strTeamBadge: String = "",

    @SerializedName("strTeamJersey")
    var strTeamJersey: String = "",

    @SerializedName("strWebsite")
    var strWebsite: String = "",

    @SerializedName("strFacebook")
    var strFacebook: String = "",

    @SerializedName("strTwitter")
    var strTwitter: String = "",

    @SerializedName("strInstagram")
    var strInstagram: String = "",

    @SerializedName("strYoutube")
    var strYoutube: String = ""
)
