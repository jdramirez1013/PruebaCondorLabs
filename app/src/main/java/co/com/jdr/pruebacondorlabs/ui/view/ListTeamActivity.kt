package co.com.jdr.pruebacondorlabs.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.com.jdr.pruebacondorlabs.databinding.ActivityListTeamBinding
import co.com.jdr.pruebacondorlabs.ui.view.fragment.ListTeamFragment
import dagger.hilt.android.AndroidEntryPoint

lateinit var binding : ActivityListTeamBinding

@AndroidEntryPoint
class ListTeamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, ListTeamFragment())
                .commitNow()
        }

    }
}