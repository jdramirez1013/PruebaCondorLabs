package co.com.jdr.pruebacondorlabs.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Team")
data class Team(

    @PrimaryKey
    @SerializedName("idTeam")
    var idTeam: String = "",

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    var strTeam: String = "",

    @ColumnInfo(name = "strLeague")
    @SerializedName("strLeague")
    var strLeague: String = "",

    @ColumnInfo(name = "intFormedYear")
    @SerializedName("intFormedYear")
    var intFormedYear: String = "",

    @ColumnInfo(name = "strDescriptionES")
    @SerializedName("strDescriptionES")
    var strDescriptionES: String? = "",

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    var strStadium: String = "",

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    var strTeamBadge: String = "",

    @ColumnInfo(name = "strTeamJersey")
    @SerializedName("strTeamJersey")
    var strTeamJersey: String? = "",

    @ColumnInfo(name = "strWebsite")
    @SerializedName("strWebsite")
    var strWebsite: String = "",

    @ColumnInfo(name = "strFacebook")
    @SerializedName("strFacebook")
    var strFacebook: String = "",

    @ColumnInfo(name = "strTwitter")
    @SerializedName("strTwitter")
    var strTwitter: String = "",

    @ColumnInfo(name = "strInstagram")
    @SerializedName("strInstagram")
    var strInstagram: String = "",

    @ColumnInfo(name = "strYoutube")
    @SerializedName("strYoutube")
    var strYoutube: String = ""
)
