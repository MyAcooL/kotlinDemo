package com.cxy.kotlindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxy.kotlindemo.R
import com.cxy.kotlindemo.bean.Friut
import kotlinx.android.synthetic.main.fruit_item_layout.view.*

class FriuterAdapter (val friuterList:List<Friut>):RecyclerView.Adapter<FriuterAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriuterAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fruit_item_layout,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return friuterList.size
    }

    override fun onBindViewHolder(holder: FriuterAdapter.ViewHolder, position: Int) {

        val fruit=friuterList.get(position)
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text=fruit.name
    }



    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val fruitImage:ImageView=view.findViewById(R.id.fruitImage)
        val fruitName:TextView=view.findViewById(R.id.fruitName)

    }

}