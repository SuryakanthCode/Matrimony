package com.example.matrimony.ui.component.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matrimony.R
import com.example.matrimony.databinding.FragmentHomeBinding
import com.example.matrimony.model.Profile
import com.example.matrimony.ui.MainViewModel
import com.example.matrimony.utils.clicklistener.OnItemClickListener


class HomeFragment : Fragment(), OnItemClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.my_graph)
    private lateinit var profileDetails: List<Profile>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        homeAdapter = HomeAdapter(this, arrayListOf(), requireActivity())
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = homeAdapter
        }

        viewModel.profileData.observe(viewLifecycleOwner) {
            homeAdapter.updateList(it)
            profileDetails = it
        }

        binding.overFlowIcon.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_GestureFragment)
        }
    }


    override fun onItemClick(profile: Profile, position: Int, selectedBtn: String) {
        viewModel.deleteProfile(profile.profileId)
        Toast.makeText(
            requireActivity(),
            " $selectedBtn button clicked, ${profile.name} profile deleted",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onItemClickNavToProfile(profile: Profile) {
        val bundle = Bundle()
        bundle.putParcelable("profileItem", profile)
        val action = R.id.action_homeFragment_to_profileFragment
        findNavController().navigate(action, bundle)
    }
}
