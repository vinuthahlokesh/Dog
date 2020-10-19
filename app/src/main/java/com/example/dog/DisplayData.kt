package com.example.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room


class DisplayData : Fragment(R.layout.fragment_display_data) {
    private lateinit var dogDatabase: DogDatabase
    private lateinit var display : RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dogDatabase = Room.databaseBuilder(view.context,DogDatabase::class.java,"DogDataBase").build()
        display = view.findViewById(R.id.display)
        display.layoutManager = LinearLayoutManager(view.context)
        displayData()
    }
    fun displayData(){
        val list : MutableList<Dogdata> = mutableListOf()
        Thread{
            list.addAll(dogDatabase.dogDao().readAll())
            display.post {
                if (list.isEmpty()) Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
                else{
                    val dispList : MutableList<String> = mutableListOf()
                    list.forEach {
                        dispList.add("${it.name} ${it.breed} ${it.colour} ${it.age}")
                    }
                    display.adapter = Adapter(dispList)
                }
            }
        }.start()
    }

}