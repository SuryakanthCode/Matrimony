package com.example.matrimony.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.matrimony.model.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
    fun getAllProfiles(): LiveData<List<Profile>>

    @Query("DELETE FROM profile WHERE profileId = :profileId")
    suspend fun deleteProfile(profileId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: List<Profile>)
}