package com.example.myapplication

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.R.id.button3
import com.example.myapplication.R.id.framDropMenu
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    private val AmericanDollar ="AmericanDollar"
    private val AED ="AED"
    private val GBP ="GBP"
    private val EUR ="EUR"

    val values = mapOf(
        AmericanDollar to 1.0,
        AED to 3.67,
        GBP to 0.79,
        EUR to 0.93
    )



    lateinit var toDropMenu : AutoCompleteTextView
    lateinit var framDropMenu : AutoCompleteTextView
    lateinit var btn : Button
    lateinit var amountEt : TextInputEditText
    lateinit var resultEt : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         initializeViews()
        populateDropdownMenu()
      amountEt.addTextChangedListener {
          calculateResult()

      }
        framDropMenu.setOnItemClickListener { parent, view, position, id ->
            calculateResult()
        }
        toDropMenu.setOnItemClickListener { parent, view, position, id ->
            calculateResult()
        }
        

        }
    private fun calculateResult(){
        if(amountEt.text.toString().isNotEmpty()){
            val amount = amountEt.text.toString().toDouble()
            val toValue = values[toDropMenu.text.toString()]
            val framValue = values[framDropMenu.text.toString()]
            val result = amount.times(toValue!!.div(framValue!!))
            resultEt.setText(result.toString())
        } else{
            amountEt.setError("amount field require")

        }

    }

    private fun populateDropdownMenu(){
        val listofCountry = listOf(EUR , AmericanDollar , AED , GBP )
        val adapter = ArrayAdapter(this , R.layout.drop_dawen, listofCountry)
        toDropMenu.setAdapter(adapter)
        framDropMenu.setAdapter(adapter)
    }
    private fun initializeViews(){
        btn = findViewById(button3)
        amountEt = findViewById(R.id.amount1)
        resultEt = findViewById(R.id.restult1)
        toDropMenu =  findViewById(R.id.to2)
        framDropMenu  = findViewById(R.id.framDropMenu)

    }


    }

