package com.udacity.project4.shared.pref

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.udacity.project4.MyApp

enum class SharedPrefKey {
    IS_LOGGED,
}

/**
 * Created by Sha on 4/20/17.
 */
class SharedPref(pref: SharedPreferences) : AppSharedPref(pref) {

    var isLoggedIn: Boolean
        get() = getBoolean(SharedPrefKey.IS_LOGGED, false)
        set(value) {
            putBoolean(value, SharedPrefKey.IS_LOGGED)
        }

    val isNotLoggedIn: Boolean
        get() = !isLoggedIn

    companion object {
        val instance: SharedPref
            get() {
                return SharedPref(PreferenceManager.getDefaultSharedPreferences(MyApp.context))
            }
    }
}