package com.example.matrimony.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.matrimony.model.Profile

@Database(entities = [Profile::class], version = 2)
@TypeConverters(Converters::class)
abstract class ProfileDatabase : RoomDatabase() {

    abstract val profileDao: ProfileDao

    companion object {
        const val DATABASE_NAME = "profileDB"
    }
}