package com.example.matrimonysampleapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.matrimonysampleapp.model.Profile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

@Database(entities = [Profile::class], version = 2)
abstract class ProfileDatabase : RoomDatabase() {

    abstract val profileDao: ProfileDao

    companion object {
        const val DATABASE_NAME = "profileDB"
    }
}