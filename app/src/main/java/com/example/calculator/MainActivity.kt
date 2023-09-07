package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var operationBe = true

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //first row
        binding.allDelete.setOnClickListener{
            Toast.makeText(this, "allDelete", Toast.LENGTH_SHORT).show()
            binding.operations.text = "0"
            binding.answer.text = "0"
        }
        binding.percentage.setOnClickListener {inputNumber(it)}
        binding.oneDelete.setOnClickListener {
            if(binding.operations.length() > 0)
            {
                binding.operations.text = binding.operations.text.
                subSequence(0, binding.operations.length() - 1 )
            }
        }
        binding.division.setOnClickListener {inputNumber(it)}
        //second row
        binding.one.setOnClickListener {inputNumber(it)}
        binding.two.setOnClickListener {inputNumber(it)}
        binding.three.setOnClickListener {inputNumber(it)}
        binding.multiplication.setOnClickListener {inputOperation(it)}
        //third row
        binding.four.setOnClickListener {inputNumber(it)}
        binding.five.setOnClickListener {inputNumber(it)}
        binding.six.setOnClickListener {inputNumber(it)}
        binding.subtraction.setOnClickListener {inputOperation(it)}
        //four row
        binding.seven.setOnClickListener {inputNumber(it)}
        binding.eight.setOnClickListener {inputNumber(it)}
        binding.nine.setOnClickListener {inputNumber(it)}
        binding.addition.setOnClickListener {inputOperation(it)}
        //five row
        binding.point.setOnClickListener {inputNumber(it)}
        binding.zero.setOnClickListener {inputNumber(it)}
        binding.equalMark.setOnClickListener {}

/*        val buttons = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        buttons.forEach { button ->
            button.setOnClickListener { view ->
                val buttonText = (view as Button).text
                showToast("Кнопка $buttonText была нажата")
            }
        }
    }*/
    }

    private fun inputNumber(view : View){

            val text = (view as Button).text
            binding.operations.append(text)
            operationBe = true

    }

    private fun inputOperation(view: View){
        if (operationBe){
            val text = (view as Button).text
            binding.operations.append(text)
            operationBe = false
        }
    }


}