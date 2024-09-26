package com.example.matrimonysampleapp.userinterface.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matrimonysampleapp.constant.GetProfileData
import com.example.matrimonysampleapp.data.repo.ProfileRepository
import com.example.matrimonysampleapp.model.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    private var getProfilesJob: Job? = null

    init {
        getProfiles()
    }

    fun onEvent(event: String) {
        when (event) {
            EVENT.ONVIEW.name -> {
                viewModelScope.launch {
                    getProfiles()
                }
            }

            EVENT.ONINSERT.name -> {
                viewModelScope.launch { profileRepository.insertProfile(GetProfileData.profileList) }
            }

            EVENT.ONDELETE.name -> {

            }

        }
    }

    private fun getProfiles() {
        getProfilesJob = profileRepository.getProfile().onEach { profile ->
            _state.value = state.value.copy(
                profiles = profile
            )
        }.launchIn(viewModelScope)
    }
}