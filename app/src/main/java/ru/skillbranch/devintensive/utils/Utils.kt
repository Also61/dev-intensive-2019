package ru.skillbranch.devintensive.utils

object Utils {

    //to do fix me

    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts: List<String>? = fullName?.split(" ")

        val firstPart = parts?.getOrNull(0)
        val secondPart = parts?.getOrNull(1)
        val firstName = if(firstPart == "" || firstPart == " ") null else firstPart
        val lastName = if(secondPart == "" || secondPart == " ") null else secondPart



        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        var translitName:String = ""
        for( i  in payload){
            when(i.toString()){
                "а"-> translitName+="a"
                "б" -> translitName +="b"
                "в" -> translitName +="v"
                "г" -> translitName +="g"
                "д" -> translitName +="d"
                "е" -> translitName +="e"
                "ё" -> translitName +="e"
                "ж" -> translitName +="zh"
                "з" -> translitName +="z"
                "и" -> translitName +="i"
                "й" -> translitName +="i"
                "к" -> translitName +="k"
                "л" -> translitName +="l"
                "м" -> translitName +="m"
                "н" -> translitName +="n"
                "о" -> translitName +="o"
                "п" -> translitName +="p"
                "р" -> translitName +="r"
                "с" -> translitName +="s"
                "т" -> translitName +="t"
                "у" -> translitName +="u"
                "ф" -> translitName +="f"
                "х" -> translitName +="h"
                "ц" -> translitName +="c"
                "ч" -> translitName +="ch"
                "ш" -> translitName +="sh"
                "щ" -> translitName +="sh'"
                "ъ" -> translitName +=""
                "ы" -> translitName +="i"
                "ь" -> translitName +=""
                "э" -> translitName +="e"
                "ю" -> translitName +="yu"
                "я" -> translitName +="ya"
                "А"-> translitName+="A"
                "Б" -> translitName +="B"
                "В" -> translitName +="V"
                "Г" -> translitName +="G"
                "Д" -> translitName +="D"
                "Е" -> translitName +="E"
                "Ё" -> translitName +="E"
                "Ж" -> translitName +="Zh"
                "З" -> translitName +="Z"
                "И" -> translitName +="I"
                "Й" -> translitName +="I"
                "К" -> translitName +="K"
                "Л" -> translitName +="L"
                "М" -> translitName +="M"
                "Н" -> translitName +="N"
                "О" -> translitName +="O"
                "П" -> translitName +="P"
                "Р" -> translitName +="R"
                "С" -> translitName +="S"
                "Т" -> translitName +="T"
                "У" -> translitName +="U"
                "Ф" -> translitName +="F"
                "Х" -> translitName +="H"
                "Ц" -> translitName +="C"
                "Ч" -> translitName +="Ch"
                "Ш" -> translitName +="Sh"
                "Щ" -> translitName +="Sh'"
                "Ъ" -> translitName +=""
                "Ы" -> translitName +="I"
                "Ь" -> translitName +=""
                "Э" -> translitName +="E"
                "Ю" -> translitName +="Yu"
                "Я" -> translitName +="Ya"
                " " -> translitName += divider
                else -> translitName += i.toString()
            }
        }
        return translitName
    }

    fun toInitials(firstName: String?,lastName: String?):String?{
        val firstInitial:String?
        val secondInitial:String?
        var initials:String?

        if(firstName != null && firstName != " " && firstName != "")
           initials = firstName[0].toUpperCase().toString() else initials = null


        if(lastName != null && lastName != "" && lastName != " "){
            initials += lastName[0].toUpperCase().toString()}

        return initials
    }
}