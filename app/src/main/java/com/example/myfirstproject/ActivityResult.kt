package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewResult = findViewById<TextView>(R.id.viewResult)
        val viewClassification = findViewById<TextView>(R.id.viewClassification)

        val result = intent.getFloatExtra("EXTRA_BMI_RESULT", 0.1f)
        viewResult.text = result.toString()


        val classification = if(result < 18.5f){
            "Abaixo do Peso"
        } else if (result in 18.5f..24.9f){
            "Peso Normal"

        } else if (result in 25f..29.9f){
            "Sobrepeso"

        } else if (result in 30.0f..39.9f){
            "Obesidade"
        }else{
            "Obesidade Extrema"
        }

        viewClassification.text = getString(R.string.msg_classification, classification)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}