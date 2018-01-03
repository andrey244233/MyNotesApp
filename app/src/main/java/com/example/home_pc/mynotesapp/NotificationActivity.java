package com.example.home_pc.mynotesapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NativeActivity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home_pc.mynotesapp.MainActivityPackage.MainActivity.SET_NOTIFICATION_REQUEST_CODE;

public class NotificationActivity extends AppCompatActivity {


    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Calendar calendar;
    private int yearToSave;
    private int monthToSave;
    private int dayToSave;
    private int hour;
    private int minutes;
    public static String DATA = "data";
    Button bt_yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        calendar = Calendar.getInstance();

        showDialog(1);
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 1:
            datePickerDialog = new DatePickerDialog(NotificationActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Log.v("tag", "ON CREATE DIALOG" + "year " + year + "month " + month + "day " + dayOfMonth);
                    yearToSave = year;
                    monthToSave = month;
                    dayToSave = dayOfMonth;
                    Log.v("tag", "ON CREATE DIALOG" + "year " + yearToSave + "month " + monthToSave + "day " + dayToSave);
                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            showDialog(2);
            return datePickerDialog;
            case 2:
            timePickerDialog = new TimePickerDialog(NotificationActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hour = hourOfDay;
                    minutes = minute;
                    Log.v("tag", "ON CREATE DIALOG" + "hour " + hour + "minutes " + minutes);
                    Date date = new Date(yearToSave, monthToSave, dayToSave, hour, minutes);
                    Intent intent = new Intent();
                    intent.putExtra(DATA, date);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }, calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    true);
            return timePickerDialog;
        }
        return super.onCreateDialog(id);
    }


//    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//            yearToSave = year;
//            monthToSave = month;
//            dayToSave = dayOfMonth;
//            Log.v("tag", "year " + year + "month " + month + "day " + dayOfMonth);
//        }
//    };


//    private void showDialog() {
//
//
////        DatePicker.init(calendar.get(Calendar.YEAR), int, int, OnDateChangedListener).
//
//        DatePicker.OnDateChangedListener dateChangedListener = new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                yearToSave = year;
//                monthToSave = monthOfYear;
//                dayToSave = dayOfMonth;
//                Log.v("tag", "year " + year + "month " + monthToSave + "day " + dayOfMonth);
//            }
//        };
//
//
//        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                yearToSave = year;
//                monthToSave = month;
//                dayToSave = dayOfMonth;
//                Log.v("tag", "year " + year + "month " + month + "day " + dayOfMonth);
//            }
//        };
//
//        DatePickerDialog dialog = new DatePickerDialog(
//                NotificationActivity.this,
//                dateSetListener,
//                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
//
//
//        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Отмена", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//
//        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("tag", "year " + yearToSave + "month " + monthToSave + "day " + dayToSave);
//                showTime();
//            }
//        });
//
//        dialog.getDatePicker().init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), dateChangedListener);
//        dialog.show();
//    }
//
//    @Override
//    public void onBackPressed() {
//        // super.onBackPressed();
//        finish();
//    }


//    private void showTime() {
//        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                hour = hourOfDay;
//                minutes = minute;
//                Log.v("tag", "hour " + hour + "minutes  " + minutes);
//            }
//        };
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(
//                NotificationActivity.this,
//                timeSetListener,
//                calendar.get(Calendar.HOUR_OF_DAY),
//                calendar.get(Calendar.MINUTE),
//                true);
//
//        timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.v("tag", "hour " + hour + "minutes  " + minutes);
//                Date date = new Date(yearToSave, monthToSave, dayToSave, hour, minutes);
//                Intent intent = new Intent();
//                intent.putExtra(DATA, date);
//                setResult(SET_NOTIFICATION_REQUEST_CODE, intent);
//                finish();
//            }
//        });
//
//        timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "отмена", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //     showDialog();
//            }
//        });
//
//        timePickerDialog.show();
//    }
}
