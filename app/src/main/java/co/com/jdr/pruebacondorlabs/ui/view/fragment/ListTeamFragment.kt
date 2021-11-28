package co.com.jdr.pruebacondorlabs.ui.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ListTeamViewModel::class.java]

        viewModel.getTeams("Spanish La Liga")

        adapter = TeamAdapter(ArrayList()){
            listDetailTeam.selectedTeam(it)

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, DetailTeamFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        viewModel.listTeam.observe(viewLifecycleOwner, {
            adapter.updateList(it)
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

}