package co.com.jdr.pruebacondorlabs.core

import android.content.Context
import androidx.room.Room
import co.com.jdr.pruebacondorlabs.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit) : ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context)=
        Room.databaseBuilder(
            app,
            Datebase::class.java,
            "PRUEBA_CONDORLABS_DATABASE"
        ).build()

    @Singleton
    @Provides
    fun provideTeamDAO(db: Datebase) = db.teamDao()

}