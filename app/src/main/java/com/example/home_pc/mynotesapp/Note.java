package com.example.home_pc.mynotesapp;

public class Note {

    private String text;
    private Boolean notification;

    public Note(String text, Boolean notification) {
        this.text = text;
        this.notification = notification;
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
}
