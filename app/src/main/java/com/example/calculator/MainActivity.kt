package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {


    private var startBe = true
    private var operationBe = false
    private var decimalSeparator = true
    private var zeroBe = false
    private var resultat = "0"

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
        binding.point.setOnClickListener {decimalSeparator(it)}
        binding.zero.setOnClickListener {inputNumber(it)}
        binding.equalMark.setOnClickListener {equal()}

    }



    private fun allClean(){
        binding.operations.text = "0"
        binding.answer.text = ""
        binding.operations.textSize = 30F
        binding.answer.textSize = 25F

        resultat = "0"

        operationBe = false
        decimalSeparator = true
        startBe = true
    }

    private fun oneDelete(){
        if(binding.operations.length() > 1) {


            if (binding.operations.text.endsWith(".")){
                decimalSeparator = true
                }

            binding.operations.text = binding.operations.text.
            subSequence(0, binding.operations.length() - 1 )
            operationBe = true

            result()
        }
        else if(startBe){
            allClean()
        }
        else{
            allClean()
        }
    }


    private fun decimalSeparator(view: View){
        val text = (view as Button).text

        if(binding.operations.text.endsWith("÷")
                || binding.operations.text.endsWith("×")
                || binding.operations.text.endsWith("-")
                || binding.operations.text.endsWith("+")){

        }
        else if (decimalSeparator){
            binding.operations.append(text)
            decimalSeparator = false
            startBe = false

            zeroBe = true
        }

    }


    private fun inputNumber(view : View){

        val text = (view as Button).text
        if(startBe){
            allClean()
            binding.operations.textSize = 30F
            binding.answer.textSize = 25F

            binding.operations.text = binding.operations.text.
            subSequence(0, binding.operations.length() - 1 )
            binding.operations.append(text)


            startBe = false

        }
        else if (text == "0"
            && binding.operations.text.endsWith("0")
            && zeroBe ==false){

        }

        else {
            binding.operations.append(text)
            operationBe = true
        }
        result()
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

        else{
            binding.operations.append(text)
            operationBe = false
            decimalSeparator = true


            startBe = false
            zeroBe = false
        }
    }


    private fun equal() {
        binding.operations.textSize = 25F
        binding.answer.textSize = 30F

        resultat = binding.answer.text.toString()
        startBe = true
        result()
    }

    private fun result(){
        //binding.operations.textSize = 25F
        //binding.answer.textSize = 30F

        try {

        var equal = binding.operations.text.toString()
        val results = Expression(equal).calculate()

        if (results.isNaN()){
            binding.answer.text = "Error"
        }else{
            binding.answer.text = results.toString()
        }
        }catch (e: Exception){
            binding.answer.text = "Error"
        }
    }


}