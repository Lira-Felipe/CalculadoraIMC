package com.example.myfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edtWeight)
        val edtHeight: EditText = findViewById(R.id.edtHeight)

        // show the result on Display
        btnCalculate.setOnClickListener {

            val weightStr = edtWeight.text.toString()
            val heightStr = edtHeight.text.toString()


                if(heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                    val weight: Float = weightStr.toFloat()
                    val height: Float = heightStr.toFloat()

                    val finalHeight: Float = height * height
                    val bmiResult = weight / finalHeight


                    val intent = Intent(this, ActivityResult::class.java)
                        .apply {
                            putExtra("EXTRA_BMI_RESULT", bmiResult)
                        }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Por favor, insira seus dados nos campos" +
                            " vazios.", Toast.LENGTH_LONG).show()
                }
        }
    }
}