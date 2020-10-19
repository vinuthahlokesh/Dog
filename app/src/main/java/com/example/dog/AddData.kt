package com.example.dog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_add_data.*

class AddData : Fragment(R.layout.fragment_add_data) {
    private lateinit var dogDatabase: DogDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dogDatabase = Room.databaseBuilder(view.context, DogDatabase::class.java, "DogDataBase").build()
        save_button.setOnClickListener {
            insertData(
                Dogdata(
                    Edt_text_name.text.toString(),
                    Edt_text_breed.text.toString(),
                    Edt_text_colour.text.toString(),
                    Edt_text_age.text.toString()
                )
            )
            Toast.makeText(view.context, "Inserted successfully", Toast.LENGTH_SHORT).show()
        }
    }


    fun insertData(data: Dogdata) {
        Thread {
            dogDatabase.dogDao().insertData(data)
        }.start()
    }

}