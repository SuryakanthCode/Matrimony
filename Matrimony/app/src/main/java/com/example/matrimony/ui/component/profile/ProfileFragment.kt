package com.example.matrimony.ui.component.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.matrimony.R
import com.example.matrimony.databinding.FragmentProfileBinding
import com.example.matrimony.model.Profile

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileImageUri: List<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments?.getParcelable<Profile>("profileItem") as Profile
        arguments.let {
            val adapter = CarouselAdapter(it.imageURI, requireActivity())
            profileImageUri = it.imageURI
            binding.viewPager.adapter = adapter
            binding.circleIndicator.setViewPager(binding.viewPager)
            binding.profile = it
            binding.profileIdTxt.setOnClickListener { findNavController().navigateUp() }
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.sliderNoTxt.text =
                    ((binding.viewPager.currentItem + 1).toString() + " / " + profileImageUri.size.toString())
            }
        })
    }
}