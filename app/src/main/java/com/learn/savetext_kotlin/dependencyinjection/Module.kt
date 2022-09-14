package com.learn.savetext_kotlin.dependencyinjection


import android.content.Context
import androidx.room.Room
import com.learn.savetext_kotlin.Application
import com.learn.savetext_kotlin.adapter.SaveTextAdapter
import com.learn.savetext_kotlin.repo.SaveTextRepository
import com.learn.savetext_kotlin.repo.SaveTextRepositoryInterFace
import com.learn.savetext_kotlin.room.SaveTextDao
import com.learn.savetext_kotlin.room.SaveTextDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {



    @Singleton
    @Provides
    fun injectDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context,SaveTextDatabase::class.java,"SaveTextDb")
        .build()

    @Singleton
    @Provides
    fun injectDo(db: SaveTextDatabase) = db.saveTextDao()

    @Singleton
    @Provides
    fun injectRe(dao: SaveTextDao) = SaveTextRepository(dao) as SaveTextRepositoryInterFace

    @Singleton
    @Provides
    fun provideAdapter():SaveTextAdapter = SaveTextAdapter(arrayListOf())

   @Singleton
   @Provides
   fun provideApplication(@ApplicationContext application :Context): Application{
       return application as Application
   }
}