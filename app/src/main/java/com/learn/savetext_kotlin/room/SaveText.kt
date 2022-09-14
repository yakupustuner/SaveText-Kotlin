package com.learn.savetext_kotlin.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savetext")
data class SaveText(
    @ColumnInfo(name = "comment")
    var comment: String?,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)
