package com.example.mobilekomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesHandler {

        private SharedPreferences prefs;

        public SharedPreferencesHandler(Context cntx) {
            prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
        }

        public void setUsername(String username) {
            prefs.edit().putString("username", username).commit();
        }

        public String getUsername() {
            String username = prefs.getString("username","");
            return username;
        }

        public void setUserId(String id) {
            prefs.edit().putString("id", id).commit();
        }

        public String getUserId() {
            String id = prefs.getString("id","");
            return id;
        }


        public void setServer(String serverAddress) {
            prefs.edit().putString("serverAddress", serverAddress).commit();
        }

        public String getServer() {
            String serverAddress = prefs.getString("serverAddress","");
            return serverAddress;
        }

        public void setItem(String item) {
            prefs.edit().putString("item", item).commit();
        }

        public String getItem() {
            String item = prefs.getString("item","");
            return item;
        }
    }

