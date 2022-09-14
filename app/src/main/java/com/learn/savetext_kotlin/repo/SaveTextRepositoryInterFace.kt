package com.learn.savetext_kotlin.repo

import androidx.lifecycle.LiveData
import com.learn.savetext_kotlin.room.SaveText

interface SaveTextRepositoryInterFace {

    suspend fun insertText(saveText: SaveText)
    suspend fun deleteText(saveText: SaveText)
    fun getAll() : LiveData<List<SaveText>>
}