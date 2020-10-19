package com.example.dog

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    lateinit var insert_data: Button
    lateinit var display_data: Button
    lateinit var search_data: Button
    private val insert = AddData()
    private val display = DisplayData()
    private val search = SearchData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        insert_data =findViewById(R.id.insert_btn)
        display_data=findViewById(R.id.display_btn)
        search_data=findViewById(R.id.search_btn)
        insert_data.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, insert)
                    .commit()
            }
        display_data.setOnClickListener {
               supportFragmentManager
                   .beginTransaction()
                   .replace(R.id.main_frame, display)
                  .commit()
            }
        search_data.setOnClickListener {
               supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, search)
                    .commit()
           }

        }
    }
