package com.learn.savetext_kotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.learn.savetext_kotlin.R
import com.learn.savetext_kotlin.databinding.FragmentSecondBinding
import com.learn.savetext_kotlin.viewmodel.SaveTextViewModel



class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var dataBinding : FragmentSecondBinding
    lateinit var viewModel: SaveTextViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SaveTextViewModel::class.java)
        dataBinding.saveButton.setOnClickListener {
            viewModel.text(dataBinding.textInputEditText.text.toString())
        }

    }


}
