package co.com.jdr.pruebacondorlabs.ui.view

import android.annotation.SuppressLint
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timer().schedule(timerTask {
            goToList()
        }, 2000)
    }

    fun goToList(){
        val intent = Intent(this, ListTeamActivity::class.java)
        startActivity(intent)
        finish()
    }
}