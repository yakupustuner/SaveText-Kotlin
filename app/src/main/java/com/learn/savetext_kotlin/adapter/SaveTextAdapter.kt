package com.learn.savetext_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.savetext_kotlin.R
import com.learn.savetext_kotlin.databinding.RecyclerRowBinding
import com.learn.savetext_kotlin.room.SaveText

class SaveTextAdapter(var saveTextList: ArrayList<SaveText>): RecyclerView.Adapter<SaveTextAdapter.SaveTextHolder>(),SaveTextClickListener {

    class SaveTextHolder(var v:RecyclerRowBinding): RecyclerView.ViewHolder(v.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveTextHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecyclerRowBinding>(inflater, R.layout.recycler_row,parent,false)
        return SaveTextHolder(view)
    }

    override fun onBindViewHolder(holder: SaveTextHolder, position: Int) {
       holder.v.savetext = saveTextList[position]


    }

    override fun getItemCount(): Int {
        return saveTextList.size
    }



    override fun onSaveTextClicked(v: View) {

    }
}