package com.example.quizapp

object Constants {

   private var name:String? =null
    private var correctAnswers:Int=0

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val question = "What country does this flag\n belong to?"
        questionList.add(Question(1 ,question , R.drawable.argentina,"Argentina" , "China" , "Brazil" , "Morocco"  ,"Argentina" ))
        questionList.add(Question(2 ,question , R.drawable.astralia,"Egypt" , "Canada" , "Astralia" , "China"  ,"Astralia" ))
        questionList.add(Question(3 ,question , R.drawable.belgium,"Argentina" , "Belgium" , "Sudan" , "Argentina"  ,"Belgium" ))
        questionList.add(Question(4 ,question , R.drawable.canada,"Argentina" , "China" , "Brazil" , "Canada"  ,"Canada" ))
        questionList.add(Question(5 ,question , R.drawable.egypt,"Egypt" , "Sudan" , "Morocco" , "Brazil"  ,"Egypt" ))
        questionList.add(Question(6 ,question , R.drawable.india,"Sudan" , "China" , "India" , "Morocco"  ,"India" ))
        questionList.add(Question(7 ,question , R.drawable.morocco,"Morocco" , "India" , "France" , "Egypt"  ,"Morocco" ))
        questionList.add(Question(8 ,question , R.drawable.palestine,"Argentina" , "Palestine" , "Brazil" , "Morocco"  ,"Palestine" ))
        questionList.add(Question(9 ,question , R.drawable.south_korea,"France" , "China" , "India" , "South_korea"  ,"South_korea" ))
        questionList.add(Question(10 ,question , R.drawable.brazil,"Argentina" , "China" , "Brazil" , "Morocco"  ,"Brazil" ))
        return questionList


    }
    fun setName(setname:String){
        name=setname
    }
    fun getname(): String? {
        return name
    }
    fun getCorrectAnswer(): Int {
        return correctAnswers
    }

    fun addCorrectAnswers(){
        correctAnswers++
    }



}