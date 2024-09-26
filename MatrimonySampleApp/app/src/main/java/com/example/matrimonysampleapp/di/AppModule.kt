package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.matrimonysampleapp.data.db.ProfileDatabase
import com.example.matrimonysampleapp.data.repo.ProfileRepository
import com.example.matrimonysampleapp.data.repo.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProfileDatabase(app: Application): ProfileDatabase {
        return Room.databaseBuilder(
            app,
            ProfileDatabase::class.java,
            ProfileDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideProfileRepository(db: ProfileDatabase): ProfileRepository {
        return ProfileRepositoryImpl(db.profileDao)
    }


}