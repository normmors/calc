package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            Toast.makeText(this, "allDelete", Toast.LENGTH_SHORT).show()
            binding.operations.text = ""
            binding.answer.text = ""
        }

        binding.percentage.setOnClickListener {calculateActions(it)}

        binding.oneDelete.setOnClickListener {
            if(binding.operations.length() > 0)
            {
                binding.operations.text = binding.operations.text.
                subSequence(0, binding.operations.length() - 1 )
            }
        }

        binding.division.setOnClickListener {calculateActions(it)}


        binding.one.setOnClickListener {calculateActions(it)}
        binding.two.setOnClickListener {calculateActions(it)}
        binding.three.setOnClickListener {calculateActions(it)}
        binding.multiplication.setOnClickListener {calculateActions(it)}


        binding.four.setOnClickListener {calculateActions(it)}
        binding.five.setOnClickListener {calculateActions(it)}
        binding.six.setOnClickListener {calculateActions(it)}
        binding.subtraction.setOnClickListener {calculateActions(it)}


        binding.seven.setOnClickListener {calculateActions(it)}
        binding.eight.setOnClickListener {calculateActions(it)}
        binding.nine.setOnClickListener {calculateActions(it)}
        binding.addition.setOnClickListener {calculateActions(it)}


        binding.point.setOnClickListener {calculateActions(it)}
        binding.zero.setOnClickListener {calculateActions(it)}
        binding.equalMark.setOnClickListener {}




//        val buttons = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
//        buttons.forEach { button ->
//            button.setOnClickListener { view ->
//                val buttonText = (view as Button).text
//                showToast("Кнопка $buttonText была нажата")
//            }
//        }
//    }

//        binding.oneDelete.setOnClickListener {
//            if(it is Button){
//                binding.operations.append(it.text)
//            }
//        }
    }
    private fun calculateActions(view : View){
        if(view is Button)
        {
            binding.operations.append(view.text)
        }
    }

//    fun oneDelete(view: View){
//        if(binding.operations.length() > 0){
//            binding.operations.text = binding.operations.text.subSequence(0, binding.operations.length() - 1 )
//        }
//    }

}