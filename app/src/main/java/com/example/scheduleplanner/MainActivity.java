package com.example.scheduleplanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import android.app.Activity;
import android.net.Uri;
import android.view.View.OnClickListener;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {

    Button button;
    CalendarView calendar;
    TextView upNextTitle, nextEventTime, nextEvent;
    private String file;
    private Button read;
    private TextView show;
   // private String FileContent;
   // private EditText file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView) findViewById(R.id.calendarView);
        upNextTitle = (TextView) findViewById(R.id.upNextTitle);
        //nextEventTime = (TextView) findViewById(R.id.nextEventTime);
        nextEvent = (TextView) findViewById(R.id.nextEvent);
        read = findViewById(R.id.refreshMain);
        show = findViewById(R.id.nextEvent);
       // file = findViewById(R.id.editFile);



        Events();
        Activity();
        Holidays();
        Exams();
        Lists();
        read();



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                /* Toast.makeText(getBaseContext(), "Selected Date: " + month + "/" + dayOfMonth + "/" + year, Toast.LENGTH_LONG).show(); */

                upNextTitle.setText("Up Next: " + month + "/" + dayOfMonth + "/" + year);



            }





        });


    }

    public void Events() {

        Button EventsButton = findViewById(R.id.Events);
        EventsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://calendar.tamuk.edu/calendar"));
                startActivity(myWebLink);
            }
        });

    }

    public void Activity() {

        Button ActivityButton = findViewById(R.id.Activities);
        ActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.tamuk.edu/osa/"));
                startActivity(myWebLink);
            }
        });

    }

    public void Holidays() {

        Button HolidaysButton = findViewById(R.id.Holidays);
        HolidaysButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://tamuk.edu/academics/academic-calendar/index.html"));
                startActivity(myWebLink);
            }
        });

    }

    public void Exams() {

        Button ExamsButton = findViewById(R.id.Exams);
        ExamsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://tamuk.edu/academics/academic-calendar/index.html"));
                startActivity(myWebLink);
            }
        });

    }

    public void Lists() {

        Button ListsButton = findViewById(R.id.Lists);
        ListsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Event_Lists.class);
                startActivity(i);

            }

        });
    }

    public void read() {

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               startActivityForResult(new Intent(getApplicationContext(), Event_Lists.class),123);

                //FileContent = file.getText().toString();



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {

                show.setText(data.getStringExtra("message"));



        }
    }
}