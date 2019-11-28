package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
   TextView TV1;
   TextView TV2;

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tvSum;
    Button buttonSave;
    Button nextBuss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TV1 = findViewById(R.id.TextViewBussNmr);
        TV2 = findViewById(R.id.TextViewBusType);

        tv1 = (TextView) findViewById(R.id.tvstep1);
        tv2 = (TextView)findViewById(R.id.tvstep2);
        tv3 = (TextView) findViewById(R.id.tvstep3);
        tv4 = (TextView) findViewById(R.id.tvstep4);
        tvSum = (TextView) findViewById(R.id.tvSUM);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        nextBuss = (Button) findViewById(R.id.nextBuss);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String n = (String) b.get("number");
            TV2.setText(n);
            String j = (String) b.get("name");
            TV1.setText(j);
        }


        SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(this);


        float awgOne = mPreference.getFloat("awgOne", -1);
        String textOne = Float.toString(awgOne);
        tv1.setText(textOne);
        Log.d("awg 1  ", "" + awgOne);

        float awgTwo = mPreference.getFloat("awgTwo", 1);
        String textTwo = Float.toString(awgTwo);
        tv2.setText(textTwo);
        Log.d("awg 2  ", "" + awgTwo);

        float awgThree = mPreference.getFloat("awgThree", 2);
        String textThree = Float.toString(awgThree);
        tv3.setText(textThree);
        Log.d("awg 3  ", "" + awgThree);

        float awgFour = mPreference.getFloat("awgFour", 3);
        String textFour = Float.toString(awgFour);
        tv4.setText(textFour);
        Log.d("awg 4  ", "" + awgFour);


        float averageSum = (awgOne + awgTwo + awgThree + awgFour);
        float sum = averageSum /4;
        String textSum = Float.toString(sum);
        tvSum.setText(textSum);



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            sendEmail();

            }
        });
        nextBuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(getApplicationContext(), ValAvBussActivity.class);
                startActivity(nextIntent);
            }
        });


    }
    public void sendEmail(){
        Bundle email = new Bundle();
        String a = TV2.getText().toString();
        email.putString("name", a);
        String b = TV1.getText().toString();
        email.putString("number", b);
        String c = tvSum.getText().toString();
        email.putString("sum", c);


        String[] TO_EMAILS = {"joakim.nagornoff@live.se"};

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Städ Besiktining av :" + " " + b + " " + a  );
        intent.putExtra(Intent.EXTRA_TEXT, "Besiktnings medelvärde :"+" " + c);
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "välj en email applikation"));
    }




}
