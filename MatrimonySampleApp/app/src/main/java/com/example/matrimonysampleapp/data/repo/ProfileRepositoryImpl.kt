package com.example.matrimonysampleapp.data.repo

import com.example.matrimonysampleapp.data.db.ProfileDao
import com.example.matrimonysampleapp.data.db.ProfileDatabase
import com.example.matrimonysampleapp.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileRepositoryImpl(
    private val dao: ProfileDao
) : ProfileRepository {
    override fun getProfile(): Flow<List<Profile>> {
        return dao.getAllProfiles()
    }

    override suspend fun insertProfile(profile: List<Profile>) {
        dao.insertOrUpdateUsers(profile)
    }

    override suspend fun deleteProfile(profileId: Int) {
        dao.deleteProfile(profileId)
    }
}