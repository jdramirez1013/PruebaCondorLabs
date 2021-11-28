package co.com.jdr.pruebacondorlabs.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.jdr.pruebacondorlabs.data.model.Team

@Dao
interface TeamDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(team: Team)


    @Query("SELECT * FROM Team WHERE strLeague = :league")
    suspend fun findByLeague(league: String): List<Team>


}