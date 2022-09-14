package com.learn.savetext_kotlin.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.learn.savetext_kotlin.adapter.SaveTextAdapter
import javax.inject.Inject

class SaveTextFragmentFactory @Inject constructor(
    private val saveTextAdapter: SaveTextAdapter
)  : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
       return when(className){
            FirstFragment::class.java.name -> FirstFragment(saveTextAdapter)
            else -> super.instantiate(classLoader, className)
        }

    }
}