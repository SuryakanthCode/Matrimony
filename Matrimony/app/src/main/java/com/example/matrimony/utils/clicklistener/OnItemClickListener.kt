package com.example.matrimony.utils.clicklistener

import com.example.matrimony.model.Profile

interface OnItemClickListener {
    fun onItemClick(profile: Profile, position: Int, selectedString: String)

    fun onItemClickNavToProfile(profile: Profile)
}