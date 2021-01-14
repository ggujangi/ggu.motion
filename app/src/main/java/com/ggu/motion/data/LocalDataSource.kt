package com.ggu.motion.data

import android.content.SharedPreferences

class LocalDataSource(private val pref: SharedPreferences) {

    fun register(name: String) {
        pref.edit().putString(PREF_KEY_NAME, name).apply()
    }

    fun getName() = pref.getString(PREF_KEY_NAME, "")
}