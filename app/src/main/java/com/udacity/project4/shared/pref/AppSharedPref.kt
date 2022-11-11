package com.udacity.project4.shared.pref

import android.content.SharedPreferences
import com.google.gson.Gson

open class AppSharedPref(private val pref: SharedPreferences) {
    private var editor: SharedPreferences.Editor = pref.edit()

    protected fun putString(value: String?, key: SharedPrefKey) {
        editor.putString(key.name, value)
        editor.apply()
    }

    protected fun putInt(value: Int, key: SharedPrefKey) {
        editor.putInt(key.name, value)
        editor.apply()
    }

    protected fun putLong(value: Long, key: SharedPrefKey) {
        editor.putLong(key.name, value)
        editor.apply()
    }

    protected fun putFloat(value: Float, key: SharedPrefKey) {
        editor.putFloat(key.name, value)
        editor.apply()
    }

    protected fun putBoolean(value: Boolean, key: SharedPrefKey) {
        editor.putBoolean(key.name, value)
        editor.apply()
    }

    protected fun getString(key: SharedPrefKey, def: String): String? {
        return pref.getString(key.name, def)
    }

    protected fun getInt(key: SharedPrefKey, def: Int): Int {
        return pref.getInt(key.name, def)
    }

    fun getLong(key: SharedPrefKey, def: Long): Long {
        return pref.getLong(key.name, def)
    }

    protected fun getFloat(key: SharedPrefKey, def: Float): Float {
        return pref.getFloat(key.name, def)
    }

    protected fun getBoolean(key: SharedPrefKey, def: Boolean): Boolean {
        return pref.getBoolean(key.name, def)
    }

    fun <T> putAsJson(value: T, key: SharedPrefKey) {
        editor.putString(key.name, Gson().toJson(value))
        editor.apply()
    }

    fun <T> fromJson(key: SharedPrefKey, clazz: Class<T>): T? {
        val json = getString(key, "")
        if (json.isNullOrEmpty()) return null
        return Gson().fromJson(json, clazz)
    }

    fun clear() {
        editor.clear()
        editor.apply()
    }

}
