package com.example.matrimony.data.repo

import androidx.lifecycle.LiveData
import com.example.matrimony.data.db.ProfileDao
import com.example.matrimony.model.Profile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val dao: ProfileDao
) {

    fun getProfile(): LiveData<List<Profile>> = dao.getAllProfiles()

    suspend fun insertProfile(profile: List<Profile>) = dao.insertProfile(profile)

    suspend fun deleteProfile(profileId: String) = dao.deleteProfile(profileId)
}