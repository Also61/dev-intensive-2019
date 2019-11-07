package ru.skillbranch.devintensive.repositories

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import ru.skillbranch.devintensive.App
import ru.skillbranch.devintensive.models.Profile

object PreferencesRepository {


    private const val FIRST_NAME="FIRST_NAME"
    private const val LAST_NAME="LAST_NAME"
    private const val ABOUT="ABOUT"
    private const val REPOSITORY="REPOSITORY"
    private const val RAITING="RAITING"
    private const val RESPECT="RESPECT"
    private const val APP_THEME="APP_THEME"

    private val prefs: SharedPreferences by lazy {
        val ctx = App.applicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    fun saveAppTheme(theme: Int){
        putValue(APP_THEME to theme)
    }

    fun getAppTheme() : Int = prefs.getInt(APP_THEME, AppCompatDelegate.MODE_NIGHT_NO)

    fun saveProfile(profile: Profile){
        with(profile){

            putValue(FIRST_NAME to firstName)
            putValue(LAST_NAME to lastName)
            putValue(ABOUT to about)
            putValue(REPOSITORY to repository)
            putValue(RAITING to raiting)
            putValue(RESPECT to respect)

        }
    }

    fun getPtofile():Profile = Profile(

            prefs.getString(FIRST_NAME , "")!!,
            prefs.getString(LAST_NAME , "")!!,
            prefs.getString(ABOUT , "")!!,
            prefs.getString(REPOSITORY , "")!!,
            prefs.getInt(RAITING , 0)!!,
            prefs.getInt(RESPECT , 0)!!

    )

    private fun putValue(pair: Pair<String, Any>) = with(prefs.edit()){
        val key = pair.first
        val value = pair.second


        when(value){
            is String -> putString(key,value)
            is Int -> putInt(key,value)
            is Boolean -> putBoolean(key,value)
            is Long -> putLong(key,value)
            is Float -> putFloat(key,value)
            else -> error("Only primitives types can be stored in Shared Preferences")
        }

        apply()
    }


}