package com.example.matrimony.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matrimony.constant.GetProfileData
import com.example.matrimony.data.repo.ProfileRepository
import com.example.matrimony.model.Profile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    val profileData: LiveData<List<Profile>> = profileRepository.getProfile()

    init {
        viewModelScope.launch {
            profileRepository.insertProfile(GetProfileData.profileList)
        }
    }

    fun deleteProfile(profileId: String) {
        viewModelScope.launch {
            profileRepository.deleteProfile(profileId)
        }
    }
}