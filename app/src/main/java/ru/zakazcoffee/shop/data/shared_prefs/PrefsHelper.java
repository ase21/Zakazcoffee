package ru.zakazcoffee.shop.data.shared_prefs;

import android.content.SharedPreferences;

public class PrefsHelper {

    private final String TOKEN = "token";
    private final String ID = "id";

    private SharedPreferences sharedPreferences;

    public PrefsHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setToken(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.apply();
    }

    public String getToken(){
        return sharedPreferences.getString(TOKEN, "");
    }

    public void setCurrentId(String id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ID, id);
        editor.apply();
    }

    public String getId(){
        return sharedPreferences.getString(ID, "");
    }

    public void clearPrefs() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
