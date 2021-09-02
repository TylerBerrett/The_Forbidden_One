package com.tylerb.testapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tylerb.testapp.data.dao.DefaultDao
import com.tylerb.testapp.data.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class DefaultDatabase : RoomDatabase() {
    abstract fun defaultDao(): DefaultDao
}