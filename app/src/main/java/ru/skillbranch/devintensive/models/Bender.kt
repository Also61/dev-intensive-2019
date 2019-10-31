package ru.skillbranch.devintensive.models

class Bender(var status: Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion():String = when (question){

                Question.NAME -> Question.NAME.question
                Question.PROFESSION -> Question.PROFESSION.question
                Question.MATERIAL -> Question.MATERIAL.question
                Question.BDAY -> Question.BDAY.question
                Question.SERIAL  -> Question.SERIAL .question
                Question.IDLE -> Question.IDLE.question
    }

    private fun checkAnswer(answer:String): Pair<String, Triple<Int,Int,Int>>{
       return when (question) {
            Question.IDLE -> {question.nextQuestion()
            question.question to status.color}

           else ->  if (question.answers.contains(answer)) {
                question = question.nextQuestion()
                "Отлично - ты справился\n${question.question}" to status.color
            }else if(wrong == 3){
               wrong = 0

               question = Question.NAME
               status = Status.NORMAL
               "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
           }
           else {
                status = status.nextStatus()
                wrong = wrong + 1
                "Это неправильный ответ\n${question.question}" to status.color
            }
        }
    }

    var wrong = 0
    fun listenAnswer(answer:String): Pair<String, Triple<Int,Int,Int>>{

     return when(question){
         Question.NAME -> if(answer[0].isLetter() && answer[0].isUpperCase()) checkAnswer(answer)
         else  {"Имя должно начинаться с заглавной буквы\n${question.question}" to status.color}

         Question.PROFESSION -> if(answer[0].isLetter() && answer[0].isLowerCase()) checkAnswer(answer)
         else {"Профессия должна начинаться со строчной буквы\n" +
                 "${question.question}" to status.color }

         Question.MATERIAL ->  {
             var check = true
             answer.forEach {
                 if(it.isDigit()){
                     check = false
                 }
             }
             if(!check){"Материал не должен содержать цифр\n" +
                     "${question.question}" to status.color } else checkAnswer(answer)
         }

         Question.BDAY -> {
             var check = true

             answer.forEach {
                 if(!it.isDigit()){
                     check = false
                 }
             }
             if(check) checkAnswer(answer) else {"Год моего рождения должен содержать только цифры\n" +
                     "${question.question}" to status.color}
         }

         Question.SERIAL -> {
             var check = true

             answer.forEach {
                 if(!it.isDigit()){
                     check = false
                 }
             }
             if(check && answer.length == 7) checkAnswer(answer)  else {"Серийный номер содержит только цифры, и их 7\n" +
                     "${question.question}" to status.color
             }
         }
         else -> checkAnswer(answer)
     }


    }


    enum class Status(val color : Triple<Int,Int,Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICLAL(Triple(255,0,0));

        fun nextStatus(): Status {
            return if(this.ordinal< values().lastIndex){
                values()[this.ordinal + 1]
            }else{
                values()[0]
            }
        }
    }


    enum class Question(val question: String,val answers:List<String>){
        NAME("Как меня зовут?", listOf("Бендер","Bender")){
            override fun nextQuestion(): Question = PROFESSION
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик","bender")){
            override fun nextQuestion(): Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл","дерево","iron","metal","wood","Металл","Дерево","Iron","Metal","Wood")){
            override fun nextQuestion(): Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE
        };

        abstract fun nextQuestion():Question

    }
}