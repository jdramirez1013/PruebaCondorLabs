package co.com.jdr.pruebacondorlabs.ui.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.jdr.pruebacondorlabs.R
import co.com.jdr.pruebacondorlabs.databinding.FragmentListTeamBinding
import co.com.jdr.pruebacondorlabs.ui.adapter.TeamAdapter
import co.com.jdr.pruebacondorlabs.ui.viewModel.ListDetailTeamViewModel
import co.com.jdr.pruebacondorlabs.ui.viewModel.ListTeamViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTeamFragment : Fragment() {

    private lateinit var viewModel: ListTeamViewModel
    private lateinit var binding: FragmentListTeamBinding
    private lateinit var adapter: TeamAdapter
    private val listDetailTeam: ListDetailTeamViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListTeamBinding.inflate(inflater, container, false)

        binding.clase = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ListTeamViewModel::class.java]



        adapter = TeamAdapter(ArrayList()){
            listDetailTeam.selectedTeam(it)

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, DetailTeamFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        viewModel.listTeam.observe(viewLifecycleOwner, {
            adapter.updateList(it)
            binding.rvTeam.smoothScrollToPosition(0)
        })

        binding.rvTeam.layoutManager = LinearLayoutManager(this.requireContext())
        binding.rvTeam.adapter = adapter

        viewModel.isLoading.observe(viewLifecycleOwner){
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

    }

    fun onLeagueSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
        viewModel.getTeams(binding.spLeague.selectedItem.toString())
    }


}