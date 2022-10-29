package com.example.scheduleplanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import android.view.View;
import android.widget.*;

public class NewEvent extends AppCompatActivity {

    private Button write;
    private EditText Name,Desc,Date,file;
    //private String file="myfile";
    private String NameContent;
    private String DescContent;
    private String DateContent;
    private String FileContent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        write = findViewById(R.id.AddEventButton);
        Name = findViewById(R.id.NameOfEvent);
        Desc = findViewById(R.id.Description);
        Date = findViewById(R.id.Date);
        file = findViewById(R.id.editFile);



        write.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                NameContent = Name.getText().toString();
                DescContent = Desc.getText().toString();
                DateContent = Date.getText().toString();
                FileContent = file.getText().toString();
                String NewLine = "\n\r";
                String Space = "                      ";
                String str;

                try{
                    FileOutputStream fOut = openFileOutput(FileContent, Context.MODE_PRIVATE);
                    fOut.write(NameContent.getBytes());
                    fOut.write(Space.getBytes());
                    fOut.write(DateContent.getBytes());
                    fOut.write(NewLine.getBytes());
                    fOut.write(NewLine.getBytes());
                    fOut.write(DescContent.getBytes());
                    fOut.write(NewLine.getBytes());
                    fOut.close();
                    File fileDir = new File(getFilesDir(),FileContent);
                    Toast.makeText(getBaseContext(), "File saved at " + fileDir, Toast.LENGTH_LONG).show();


                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

}