package com.example.dog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val list: List<String>) : RecyclerView.Adapter<Adapter.FormViewHolder>(){
        class FormViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val formItem : TextView = view.findViewById(R.id.textview)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.FormViewHolder {
            return FormViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view,parent,false))
        }

        override fun onBindViewHolder(holder: Adapter.FormViewHolder, position: Int) {
            holder.formItem.text = list[position]
        }

        override fun getItemCount(): Int = list.size

    }


