package io.github.hbalti.examenandriod.network


import android.content.Context

object LoginPref {

    /**
     * Name of the default OAuth shared preferences.
     */
    val PREFS = "DEFAULT_OAUTH"


    /**
     * Access Token
     */
    private val TOKEN = "Token"


    /**
     * Clear all Data
     *
     * @param context calling context
     */
    fun clear(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }


    /**
     * @param context     calling context
     * @param accessToken access token
     */
    fun saveAccessToken(context: Context, accessToken: String) {
        val sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(TOKEN, accessToken).apply()
    }

    /**
     * @param context calling context
     * @return access token
     */
    fun getAccessToken(context: Context): String {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return prefs.getString(TOKEN, "")!!
    }

}

