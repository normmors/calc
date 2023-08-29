package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.allDelete.setOnClickListener(){
            Toast.makeText(this, "No information", Toast.LENGTH_SHORT).show()
            binding.operations.text = ""
        }

    }


        fun numberAct(view : View){
            if(view is Button)
            {

                binding.operations.append(view.text)
            }
        }


}