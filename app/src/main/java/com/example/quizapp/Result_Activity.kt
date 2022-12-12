package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_Activity : AppCompatActivity() {

    private var name:TextView?=null
    private var score:TextView?=null
    private var finish_btn:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        name = findViewById(R.id.name)
        score = findViewById(R.id.score)
        finish_btn = findViewById(R.id.finish_btn)

        val scoreTxt = "Your score is ${Constants.getCorrectAnswer()} out of ${Constants.getQuestions().size}"

        name?.text = Constants.getname()
        score?.text = scoreTxt
        finish_btn?.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
        }


    }
}