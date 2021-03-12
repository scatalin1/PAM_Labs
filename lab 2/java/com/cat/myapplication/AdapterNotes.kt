package com.cat.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cat.myapplication.databinding.NoteBinding

class AdapterNotes (val array: ArrayList<Note>):
    RecyclerView.Adapter<AdapterNotes.ViewHolder>(){

    class ViewHolder(val binding: NoteBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItems(note: Note){
            binding.type.setText(note.type)
            binding.description.setText(note.description)
            binding.amount.setText(note.amount)
            binding.purse.setText(note.purse)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(array[position].type.equals("income")){
            holder.binding.parentRelative.setBackgroundColor(Color.parseColor("#97C1D3"))
        }
        else if(array[position].type.equals("spending")){
            holder.binding.parentRelative.setBackgroundColor(Color.parseColor("#C0D6DF"))
        }
        else if(array[position].type.equals("spending")){
            holder.binding.parentRelative.setBackgroundColor(Color.parseColor("#DBE9EE"))
        }
        holder.bindItems(array[position])
    }
}