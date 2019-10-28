package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import 	android.view.inputmethod.InputMethodManager

// Extension - метод сокрытия клавиатуры
fun Activity.hideKeyboard():Unit{
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
}

