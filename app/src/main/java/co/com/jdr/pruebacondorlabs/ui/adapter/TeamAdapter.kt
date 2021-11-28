package co.com.jdr.pruebacondorlabs.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.jdr.pruebacondorlabs.R
import co.com.jdr.pruebacondorlabs.data.model.Team
import co.com.jdr.pruebacondorlabs.databinding.HolderTeamBinding
import com.squareup.picasso.Picasso

class TeamAdapter (var teamList: List<Team>,
                    var teamCallback: (team: Team) -> Unit): RecyclerView.Adapter<TeamAdapter.TeamHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Team>){
        teamList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        val binding = HolderTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TeamHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        with(holder){
            with(teamList[position]){
                binding.tvTeamName.text = this.strTeam
                binding.tvStadiumName.text = this.strStadium

                Picasso.get().load(this.strTeamBadge)
                    .placeholder(R.drawable.splash_screen)
                    .into(binding.imgTeam)

                binding.root.setOnClickListener {
                    teamCallback.invoke(this)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    class TeamHolder(val binding: HolderTeamBinding): RecyclerView.ViewHolder(binding.root)


}