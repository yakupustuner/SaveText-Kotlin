package com.learn.savetext_kotlin.repo

import androidx.lifecycle.LiveData
import com.learn.savetext_kotlin.room.SaveText
import com.learn.savetext_kotlin.room.SaveTextDao
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SaveTextRepository @Inject constructor(
    private val saveTextDao: SaveTextDao
): SaveTextRepositoryInterFace {
    override suspend fun insertText(saveText: SaveText) {
        saveTextDao.insertText(saveText)
    }

    override suspend fun deleteText(saveText: SaveText) {
        saveTextDao.deleteText(saveText)

    }

    override fun getAll(): LiveData<List<SaveText>> {
        return saveTextDao.getAll()
    }

}