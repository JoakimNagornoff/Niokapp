package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ControllStep4Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    TextView Tv1;
    TextView Tv2;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step4);

        nextButton = (Button) findViewById(R.id.button_nextFour);
        Tv1 = findViewById(R.id.TextViewBussNmr);
        Tv2 = findViewById(R.id.TextViewBusType);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String j = (String) b.get("name");
            Tv2.setText(j);
            String n = (String) b.get("number");
            Tv1.setText(n);
        }



        ArrayList<cardViewItem> passengerCardFour = new ArrayList<>();
        passengerCardFour.add(new cardViewItem("Passagerarplats", "fönster"));
        passengerCardFour.add(new cardViewItem("Passagerarplats","golv"));
        passengerCardFour.add(new cardViewItem("Passagerarplats", "stänger"));
        passengerCardFour.add(new cardViewItem("Passageraplats", "säten"));
        passengerCardFour.add(new cardViewItem("Passagerarplats", "tak"));

        ArrayList<cardViewItem> cardViewList = new ArrayList<>();
        cardViewList.addAll(passengerCardFour);


        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(cardViewList, this);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreference.edit();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float awg = mPreference.getFloat("awg", 3);
              //  float scoreFour = mPreference.getFloat("awg", 3);
             //   float awgFour = (scoreFour + awg) /2;
                editor.putFloat("awgFour", awg);
                editor.apply();


                Bundle b = new Bundle();
                String s = Tv1.getText().toString();
                b.putString("name", s);
                String n = Tv2.getText().toString();
                b.putString("number",n);

                Intent nextIntent = new Intent(getApplicationContext(), DisplayActivity.class);
                nextIntent.putExtra("name", s);
                nextIntent.putExtra("number",n);
                startActivity(nextIntent);
            }
        });

    }
}
