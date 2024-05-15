package com.example.crane.config

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    private const val PREF ="PREF_Key"
    const val FIRSTTIME = "FIRSTTIME"


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
}