package com.example.test_06.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.test_06.Constants
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = Constants.UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
