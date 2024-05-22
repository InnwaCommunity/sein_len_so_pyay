package com.example.crane.config

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private const val PREF ="PREF_Key"
    const val FIRSTTIME = "FIRSTTIME"
    const val userData = "UserData"


    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF,Context.MODE_PRIVATE)
    }

    fun setBoolean(context: Context,value: Boolean,key: String){
        val editor = getPreferences(context).edit()
        editor.putBoolean(key,value)
        editor.apply()
    }
    fun getBoolean(context: Context,key: String): Boolean?{
        return getPreferences(context).getBoolean(key,false)
    }

    fun setString(context: Context,value: String,key: String){
        val editor = getPreferences(context).edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun getString(context: Context,key: String): String? {
        return getPreferences(context).getString(key,null)
    }
}