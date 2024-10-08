package com.example.matrimony.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "profile")
@Parcelize
data class Profile(
    @PrimaryKey
    val id: Int,
    val profileId: String,
    val name: String,
    val age: String,
    val height: String,
    val address: String,
    val imageURI: List<String>
) : Parcelable
