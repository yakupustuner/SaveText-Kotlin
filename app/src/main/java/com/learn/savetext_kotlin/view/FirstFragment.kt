package com.learn.savetext_kotlin.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.savetext_kotlin.R
import com.learn.savetext_kotlin.adapter.SaveTextAdapter
import com.learn.savetext_kotlin.databinding.FragmentFirstBinding
import com.learn.savetext_kotlin.room.SaveText
import com.learn.savetext_kotlin.viewmodel.SaveTextViewModel
import javax.inject.Inject



class FirstFragment @Inject constructor(
    val saveTextAdapter: SaveTextAdapter
) : Fragment(R.layout.fragment_first) {
    private lateinit var dataBinding : FragmentFirstBinding
    lateinit var viewModel : SaveTextViewModel

    private val callBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
           val p0 = viewHolder.layoutPosition
            val selectedText = saveTextAdapter.saveTextList[p0]
            viewModel.deleteText(selectedText)
            Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()

        }


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SaveTextViewModel::class.java)
        Observers()


        dataBinding.recyclerView.adapter = saveTextAdapter
        dataBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(callBack).attachToRecyclerView(dataBinding.recyclerView)
        dataBinding.fab.setOnClickListener {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }



    }

    @SuppressLint("NotifyDataSetChanged")
    private fun Observers(){
        viewModel.savetextList.observe(viewLifecycleOwner, Observer {
            saveTextAdapter.saveTextList = it as ArrayList<SaveText>
            saveTextAdapter.notifyDataSetChanged()

        })
    }









}