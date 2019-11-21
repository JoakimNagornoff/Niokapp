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

        SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(this);



        float awgOne = mPreference.getFloat("awgOne", -1);
        Log.d("awg 1  ", "" + awgOne);

        float awgTwo = mPreference.getFloat("awgTwo", 1);
        Log.d("awg 2  ", "" + awgTwo);

        float awgThree = mPreference.getFloat("awgThree", 2);
        Log.d("awg 3  ", "" + awgThree);

        float awgFour = mPreference.getFloat("awgFour", 3);
        Log.d("awg 4  ", "" + awgFour);






    }
}
