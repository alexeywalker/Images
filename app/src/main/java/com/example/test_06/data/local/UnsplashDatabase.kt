package com.example.test_06.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test_06.data.local.dao.UnsplashImageDao
import com.example.test_06.data.local.dao.UnsplashRemoteKeysDao
import com.example.test_06.model.UnsplashImage
import com.example.test_06.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}