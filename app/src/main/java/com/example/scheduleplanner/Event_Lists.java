package com.example.scheduleplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Event_Lists extends AppCompatActivity {

    private Button readText;
    private TextView showText;
    //private String file = "myfile";
    private EditText file;
    private String FileContent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_lists);

        readText = findViewById(R.id.refresh);
        showText = findViewById(R.id.textView2);
        file = findViewById(R.id.editFile2);
        NewEvent();
        //refresh();




        readText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileContent = file.getText().toString();
                try {
                    FileInputStream fIn = openFileInput(FileContent);
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }

                showText.setText(temp);
            }catch (IOException e){
                    e.printStackTrace();
                }
                }
        });
    }


    public void NewEvent() {

        Button EventsButton = findViewById(R.id.AddEvent);
        EventsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Event_Lists.this, NewEvent.class);
                startActivity(i);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("message",file.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}


