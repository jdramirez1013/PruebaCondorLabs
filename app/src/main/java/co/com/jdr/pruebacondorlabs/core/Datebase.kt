package co.com.jdr.pruebacondorlabs.core

import androidx.room.Database
import androidx.room.RoomDatabase
import co.com.jdr.pruebacondorlabs.data.local.TeamDAO
import co.com.jdr.pruebacondorlabs.data.model.Team

@Database(entities = [Team::class], version = 1, exportSchema = false)
abstract class Datebase : RoomDatabase() {

    abstract fun teamDao() : TeamDAO
}