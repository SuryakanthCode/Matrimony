package com.example.matrimonysampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import androidx.room.Upsert
import com.example.matrimonysampleapp.model.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
    fun getAllProfiles(): Flow<List<Profile>>

    @Query("DELETE FROM profile WHERE profileId = :profileId")
    suspend fun deleteProfile(profileId: Int)

    @Upsert(Profile::class)
    suspend fun insertOrUpdateUsers(profile: List<Profile>)
}