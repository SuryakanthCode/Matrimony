package com.example.matrimony.ui.component.gesture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.matrimony.R
import com.example.matrimony.databinding.FragmentGestureBinding
import com.example.matrimony.model.Profile
import com.example.matrimony.ui.MainViewModel
import com.example.matrimony.utils.clicklistener.OnItemClickListener
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.StackFrom
import com.yuyakaido.android.cardstackview.SwipeableMethod

class GestureFragment : Fragment(R.layout.fragment_gesture), OnItemClickListener {

    private lateinit var binding: FragmentGestureBinding
    internal val viewModel: MainViewModel by hiltNavGraphViewModels(R.id.my_graph)
    private lateinit var profileDetails: List<Profile>
    private lateinit var cardStackManager: CardStackLayoutManager
    private lateinit var stackCardAdapter: CardPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGestureBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stackCardAdapter = CardPagerAdapter(this, arrayListOf(), requireActivity())
        cardStackManager = CardStackLayoutManager(requireActivity())
        binding.cardStackView.apply {
            layoutManager = cardStackManager
            adapter = stackCardAdapter
        }

        cardStackManager.apply {
            setStackFrom(StackFrom.Top)
            setVisibleCount(4)
            setScaleInterval(0.90f)
            setCanScrollVertical(false)
            setSwipeableMethod(SwipeableMethod.Manual)
        }

        viewModel.profileData.observe(viewLifecycleOwner) {
            stackCardAdapter.updateList(it)
            profileDetails = it
        }

        binding.titleTxt.setOnClickListener {
            findNavController().navigateUp()
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

    override fun onItemClickNavToProfile(profile: Profile) {}
}