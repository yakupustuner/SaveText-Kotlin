package com.learn.savetext_kotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SaveTextDao {

    @Query("SELECT * FROM savetext")
    fun getAll(): LiveData<List<SaveText>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(savetext:SaveText)

    @Delete
    suspend fun deleteText(savetext: SaveText)
}