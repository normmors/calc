package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var operationBe = false

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //first row
        binding.allClean.setOnClickListener{allClean()}
        binding.percentage.setOnClickListener {inputNumber(it)}
        binding.oneDelete.setOnClickListener {oneDelete()}
        binding.division.setOnClickListener {inputOperation(it)}
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
        binding.equalMark.setOnClickListener {result(it)}

    }

    private fun allClean(){
        binding.operations.text = "0"
        binding.answer.text = "0"
        binding.operations.textSize = 30F
        binding.answer.textSize = 25F
        operationBe = false
    }

    private fun oneDelete(){
        if(binding.operations.length() > 1) {
            binding.operations.text = binding.operations.text.
            subSequence(0, binding.operations.length() - 1 )
            operationBe = true
        }
        else{
            binding.operations.text = "0"
            binding.operations.textSize = 30F
            binding.answer.textSize = 25F
        }
    }
    private fun inputNumber(view : View){

        val text = (view as Button).text
        if(binding.operations.text.startsWith("0")){
            binding.operations.text = binding.operations.text.toString().replace("0", "")
            binding.operations.append(text)
        }else {
            binding.operations.append(text)
            binding.answer.append(text)
            operationBe = true
        }
    }
    private fun inputOperation(view: View){

        val text = (view as Button).text

        if(binding.operations.text.endsWith("÷")
            || binding.operations.text.endsWith("×")
            || binding.operations.text.endsWith("-")
            || binding.operations.text.endsWith("+")){
            binding.operations.text = binding.operations.text.
            subSequence(0, binding.operations.length() - 1 )
            binding.operations.append(text)
        }
        //if (operationBe)
        else{
            binding.operations.append(text)
            operationBe = false
        }
    }

    private fun result(view: View){
        binding.operations.textSize = 25F
        binding.answer.textSize = 30F

    }


}