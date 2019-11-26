package com.example.a9kapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ValAvBussActivity extends AppCompatActivity {

    Button startControll;
    EditText editText1;
    ImageButton imageButton1;
    ImageButton imageButton2;
    TextView firstTextView;
    TextView secondTextView;
    Button buttonOK;
    TextView TextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_val_av_buss);

        startControll = (Button) findViewById(R.id.startControll);
        editText1 = (EditText) findViewById(R.id.EditText1);
        imageButton1 = (ImageButton) findViewById(R.id.FirstImageButton);
        imageButton2 = (ImageButton) findViewById(R.id.SecondImageButton);
        firstTextView = (TextView) findViewById(R.id.TextView3);
        secondTextView = (TextView)findViewById(R.id.TextView4);
        buttonOK = (Button) findViewById(R.id.button_ok);
        TextView4 = (TextView) findViewById(R.id.TextView4);





        startControll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle a = new Bundle();
                String s = firstTextView.getText().toString();
                a.putString("name", s);
                String n = secondTextView.getText().toString();
                a.putString("number",n);

                Intent nextActivity= new Intent(getApplicationContext(), ControllStep1Activity.class);
                nextActivity.putExtra("name",s);
                nextActivity.putExtra("number", n);
                startActivity(nextActivity);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("first", "kort vagn");
                String editTextValue1 = firstTextView.getText().toString();
                firstTextView.setText( editTextValue1 + "kort vagn");
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("second", "led vagn");
                String editTextValue2 = firstTextView.getText().toString();
                firstTextView.setText(editTextValue2 + "led vagn ");
            }
        });
      buttonOK.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int bussNMR = Integer.parseInt(editText1.getText().toString());
              secondTextView.setText(Integer.toString(bussNMR));


          }
      });
    }
}
