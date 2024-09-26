package com.example.matrimony.data.repo

import androidx.lifecycle.LiveData
import com.example.matrimony.data.db.ProfileDao
import com.example.matrimony.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepositoryImpl(
    private val dao: ProfileDao
) : ProfileRepository {
    override fun getProfile(): LiveData<List<Profile>> {
        return dao.getAllProfiles()
    }

    override suspend fun insertProfile(profile: List<Profile>) {
        dao.insertProfile(profile)
    }

    override suspend fun deleteProfile(profileId: String) {
        dao.deleteProfile(profileId)
    }
}