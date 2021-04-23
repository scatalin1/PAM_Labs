package com.cat.myapplication.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cat.myapplication.api.Model
import com.cat.myapplication.databinding.PurseRowBinding

class AdapterPurses (val array: ArrayList<Model>):
        RecyclerView.Adapter<AdapterPurses.ViewHolder>(){

    class ViewHolder(val binding: PurseRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItems(purse: Model){
            binding.purseName.setText(purse.name.split(" ")[0])
            binding.purseAmount.setText(purse.name.split(" ")[1])
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PurseRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(array[position])
        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent = Intent( context, MainActivity3::class.java)
            intent.putExtra("name", array[position].name)
            context.startActivity(intent)
        }
    }

}