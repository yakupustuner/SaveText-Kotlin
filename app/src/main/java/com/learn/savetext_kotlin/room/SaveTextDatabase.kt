package com.learn.savetext_kotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SaveText::class], version = 1)
abstract class SaveTextDatabase : RoomDatabase() {
    abstract fun saveTextDao() : SaveTextDao


}