package com.learn.savetext_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.savetext_kotlin.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var saveTextFragmentFactory: SaveTextFragmentFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = saveTextFragmentFactory
        setContentView(R.layout.activity_main)
    }
}