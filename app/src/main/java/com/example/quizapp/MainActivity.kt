package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.button_start)
        val et = findViewById<EditText>(R.id.et)

        btnStart.setOnClickListener {
            if(et.text.isEmpty()){
                Toast.makeText(this , "Please enter your name",Toast.LENGTH_LONG).show()
            }else{
                Constants.setName(et.text.toString())
                val intent = Intent(this , QuizQuestionActivity::class.java)
                startActivity(intent)

            }
        }


    }
}