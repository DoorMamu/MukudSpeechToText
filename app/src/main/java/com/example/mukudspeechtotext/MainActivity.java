package com.example.mukudspeechtotext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private TextView tv_speak_btn;
private TextView tv_voice_ip_btn;
private final int REQ_CODE_SPEECH_INPUT=100;
private int STORAGE_PERMISSION_CODE=23;
Calendar calendar;
Button intstr;
SimpleDateFormat simpleDateFormat;
String timesysa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //**************Step1*******************
        //tv_speak_btn=findViewById(R.id.btnSpeak);
        tv_voice_ip_btn=findViewById(R.id.btnVoice);
        tv_voice_ip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                bolhalkehalke();
            }
        });

    }

    private void bolhalkehalke() {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //other than web search //talk anything
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //get the language//dictionary buffer
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi speak Something");
        try {
            startActivityForResult(intent,100);
        }
        catch (ActivityNotFoundException e)
        {

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 100:
                    if (requestCode==RESULT_OK && null!=data)
                    {
                        ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        tv_voice_ip_btn.setText(result.get(0));
                        //save speech to text file

                    }
                break;
        }
    }
}
