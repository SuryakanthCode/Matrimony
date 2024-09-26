package com.example.matrimony.data.repo

import androidx.lifecycle.LiveData
import com.example.matrimony.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): LiveData<List<Profile>>

    suspend fun insertProfile(profile: List<Profile>)

    suspend fun deleteProfile(profileId: String)
}