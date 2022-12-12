package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var questionText: TextView? = null
    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var progressText: TextView? = null
    private var progressBar: ProgressBar? = null
    private var btn: Button? = null
    private var image: ImageView? = null
    private var currentPosition = 0
    private val options = ArrayList<TextView>()
    val questions = Constants.getQuestions()
    private var currentSelectedOption:Int?=null






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        questionText = findViewById(R.id.Quesion)
        optionOne = findViewById(R.id.AnswerOne)
        optionTwo = findViewById(R.id.AnswerTwo)
        optionThree = findViewById(R.id.AnswerThree)
        optionFour = findViewById(R.id.AnswerFour)
        progressText = findViewById(R.id.progress_txt)
        progressBar = findViewById(R.id.progressBar)
        btn = findViewById(R.id.button)
        image = findViewById(R.id.imageView)

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btn?.setOnClickListener(this)


        optionOne?.let { options.add(it) }
        optionTwo?.let { options.add(it) }
        optionThree?.let { options.add(it) }
        optionFour?.let { options.add(it) }



        setQuestion(questions)

    }

    private fun setQuestion(questions: ArrayList<Question>) {
        defaultOption()
        questionText?.setText(questions[currentPosition].question)
        optionOne?.setText(questions[currentPosition].optionOne)
        optionTwo?.setText(questions[currentPosition].optionTwo)
        optionThree?.setText(questions[currentPosition].optionThree)
        optionFour?.setText(questions[currentPosition].optionFour)
        image?.setImageResource(questions[currentPosition].image)
        progressText?.setText("${currentPosition + 1}/10")
        progressBar?.progress = currentPosition

        if (currentPosition == questions.size) {
            btn?.text = "FINISH"
        }

    }

    private fun defaultOption() {
        for (option in options) {
            option.setTextColor(Color.BLACK)
            option.setBackgroundResource(R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOption(selectedOptionIndex:Int){
        defaultOption()
        currentSelectedOption=selectedOptionIndex
        val selectedOption= options[selectedOptionIndex]
        selectedOption.setBackgroundResource(R.drawable.selected_option_border_bg)
    }


    private fun checkCorrectOrWrong(){

        if (btn?.text=="GO TO NEXT QUESTION"){
            btn?.text="SUBMIT"
            currentPosition++
            currentSelectedOption=null
            setQuestion(questions)

        }
        else if(btn?.text=="FINISH"){

            val intent = Intent(this , Result_Activity::class.java)
            startActivity(intent)

        }else{
            if(currentSelectedOption!=null){
                val currentOption = options[currentSelectedOption!!]

                if(currentOption.text==questions[currentPosition].correctAnswer){
                    defaultOption()
                    currentOption.setBackgroundResource(R.drawable.correct_option_border_bg)
                    Constants.addCorrectAnswers()

                }
                else{
                    defaultOption()
                    currentOption.setBackgroundResource(R.drawable.wrong_option_border_bg)
                    for (option in options){
                        if(option.text==questions[currentPosition].correctAnswer){
                            option.setBackgroundResource(R.drawable.correct_option_border_bg)
                        }
                    }

                }

                if(currentPosition+1==questions.size){
                    btn?.text="FINISH"
                }else{
                    btn?.text="GO TO NEXT QUESTION"
                    }
            }
        }



    }



    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.AnswerOne->selectedOption(0)
            R.id.AnswerTwo->selectedOption(1)
            R.id.AnswerThree->selectedOption(2)
            R.id.AnswerFour->selectedOption(3)
            R.id.button->checkCorrectOrWrong()

        }


    }
}