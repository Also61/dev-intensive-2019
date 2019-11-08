package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils

data class Profile (
    val firstName:String,
    val lastName:String,
    val about:String,
    val repository:String,
    val raiting:Int = 0,
    val respect:Int = 0){

    val rank:String = "Junior Android Developer"
    val nickName:String = createNickName(this.firstName, this.lastName)


    private fun createNickName(firstName: String,lastName: String):String{

        val nickFirst = if (firstName.isNotEmpty() && firstName != "" && firstName != " ")
         Utils.transliteration(firstName,"")
        else ""

        val nickLast =  if (lastName.isNotEmpty() && lastName != "" && lastName != " ")
         Utils.transliteration(lastName,"")
        else ""

        return if(nickFirst!= "" && nickLast != "")
            nickFirst + '_' + nickLast
        else if(nickFirst != "")
            nickFirst
        else if (nickLast != "")
            nickLast
        else
            ""
    }

    fun toMap():Map<String, Any> = mapOf(
        "nickName" to nickName,
        "rank" to rank,
        "firstName" to firstName,
        "lastName" to lastName,
        "about" to about,
        "repository" to repository,
        "raiting" to raiting,
        "respect" to respect
    )



}