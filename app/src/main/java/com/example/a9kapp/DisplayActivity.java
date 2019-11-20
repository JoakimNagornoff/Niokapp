package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        editText1 = (EditText) findViewById(R.id.editTextStep1);
        editText2 = (EditText)findViewById(R.id.editTextStep2);
        editText3 = (EditText)findViewById(R.id.editTextStep3);
        editText4 = (EditText) findViewById(R.id.editTextStep4);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int score4 = sharedPref.getInt("test4", 0);
        Log.d("score4", "" + score4);






    }
}
