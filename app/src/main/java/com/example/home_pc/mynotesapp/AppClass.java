package com.example.home_pc.mynotesapp;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

      //  initRealm(getApplicationContext());
       // Log.v("tag", "init realm");
    }
}
