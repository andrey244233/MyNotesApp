package com.example.home_pc.mynotesapp;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject {

    @PrimaryKey
    private long id;
    private String text;
    private Boolean notification;
    private String timeCreated;


    public Note(String text, Boolean notification, String timeCreated) {
        this.text = text;
        this.notification = notification;
        this.timeCreated = timeCreated;
    }

    public Note() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
