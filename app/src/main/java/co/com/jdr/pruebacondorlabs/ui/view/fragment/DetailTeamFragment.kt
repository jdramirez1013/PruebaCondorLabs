package co.com.jdr.pruebacondorlabs.ui.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import co.com.jdr.pruebacondorlabs.R
import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.databinding.FragmentDetailTeamBinding
import co.com.jdr.pruebacondorlabs.ui.viewModel.DetailTeamViewModel
import co.com.jdr.pruebacondorlabs.ui.viewModel.ListDetailTeamViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import android.content.Intent
import android.net.Uri


@AndroidEntryPoint
class DetailTeamFragment : Fragment() {

    private lateinit var viewModel: DetailTeamViewModel
    private val listDetailTeam: ListDetailTeamViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailTeamBinding
    private var team: Team = Team()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailTeamBinding.inflate(layoutInflater, container, false)

        binding.clase = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailTeamViewModel::class.java]



        listDetailTeam.teamSelected.observe(viewLifecycleOwner){
            team = it
            binding.tvTeamName.text = it.strTeam
            binding.tvYear.text = it.intFormedYear
            binding.tvDescription.text = it.strDescriptionES
            binding.tvWeb.text = it.strWebsite
            binding.tvFace.text = it.strFacebook
            binding.tvTwitter.text = it.strTwitter
            binding.tvInstagram.text = it.strInstagram
            binding.tvYoutube.text = it.strYoutube

            Picasso.get().load(it.strTeamBadge)
                .placeholder(R.drawable.splash_screen)
                .into(binding.imgBadge)

            Picasso.get().load(it.strTeamJersey)
                .placeholder(R.drawable.splash_screen)
                .into(binding.imgJersey)

        }
    }

    fun openUrl(type: String){

        var url= ""
        when(type){
            "web" -> {
                url = team.strWebsite
            }
            "facebook" -> {
                url = team.strFacebook
            }
            "twitter" -> {
                url = team.strTwitter
            }
            "instagram" -> {
                url = team.strInstagram
            }
            "youtube" -> {
                url = team.strYoutube
            }
        }

        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "https://$url"

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)

    }

}