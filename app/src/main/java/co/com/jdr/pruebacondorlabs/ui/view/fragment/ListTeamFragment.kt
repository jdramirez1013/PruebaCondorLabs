package co.com.jdr.pruebacondorlabs.ui.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.jdr.pruebacondorlabs.R
import co.com.jdr.pruebacondorlabs.ui.viewModel.ListTeamViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTeamFragment : Fragment() {

    private lateinit var viewModel: ListTeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ListTeamViewModel::class.java]




    }

}