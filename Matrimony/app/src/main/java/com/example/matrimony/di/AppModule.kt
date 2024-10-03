package com.example.matrimony.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.matrimony.data.db.ProfileDao
import com.example.matrimony.data.db.ProfileDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesProfileDatabase(@ApplicationContext context: Context): ProfileDatabase {
        return Room.databaseBuilder(
            context,
            ProfileDatabase::class.java,
            ProfileDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun providesProfileDao(db: ProfileDatabase): ProfileDao {
        return db.profileDao()
    }
}