package com.learn.savetext_kotlin.viewmodel




import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.learn.savetext_kotlin.Application
import com.learn.savetext_kotlin.repo.SaveTextRepositoryInterFace
import com.learn.savetext_kotlin.room.SaveText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SaveTextViewModel @Inject constructor(
    private val repository : SaveTextRepositoryInterFace,
    private val application : Application

) : ViewModel() {



    var savetextList = repository.getAll()


    fun deleteText(saveText: SaveText) = viewModelScope.launch {
        repository.deleteText(saveText)
    }

    fun insertText(saveText: SaveText) = viewModelScope.launch {
      repository.insertText(saveText)
    }

    fun text(comment: String?){
        if (comment != null) {
            if (comment.isEmpty()){
                Toast.makeText(application.applicationContext,"Error",Toast.LENGTH_LONG).show()
                return
            }
        }
        val saveText = SaveText(comment)
        insertText(saveText)


    }

}