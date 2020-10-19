package com.example.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_search_data.*


class SearchData : Fragment(R.layout.fragment_search_data) {
     lateinit var dogDatabase: DogDatabase
     lateinit var recyclerView: RecyclerView
    lateinit var search:Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       recyclerView = view.findViewById(R.id.recyclerview)
        search = view.findViewById(R.id.search_btn)
        dogDatabase = Room.databaseBuilder(view.context, DogDatabase::class.java, "FormDatabase").build()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        search.setOnClickListener {
            displayByName(edtname.text.toString())
        }
    }

    fun displayByName(name: String) {
        val list: MutableList<Dogdata> = mutableListOf()
        Thread {
            list.addAll(dogDatabase.dogDao().readByName(name))
            recyclerView.post {
                if (list.isEmpty()) Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
                else{
                    val dispList: MutableList<String> = mutableListOf()
                    list.forEach {
                        dispList.add("${it.name} ${it.breed} ${it.colour} ${it.age}")
                    }
                    recyclerView.adapter = Adapter(dispList)
                }
            }
        }.start()
    }
}

