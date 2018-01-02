package com.example.home_pc.mynotesapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yy' ' HH:mm");
        String currentData = sdf.format(new Date());
        return currentData;
    }

}
