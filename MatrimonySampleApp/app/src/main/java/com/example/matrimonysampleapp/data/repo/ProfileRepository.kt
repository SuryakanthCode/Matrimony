package com.example.matrimonysampleapp.data.repo

import com.example.matrimonysampleapp.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): Flow<List<Profile>>

    suspend fun insertProfile(profile: List<Profile>)

    suspend fun deleteProfile(profileId: Int)
}