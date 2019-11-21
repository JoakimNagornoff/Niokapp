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

import java.util.ArrayList;

public class ControllStep3Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step3);

        nextButton = findViewById(R.id.button_nextthree);


        ArrayList<cardViewItem> passengerCardTwo = new ArrayList<>();
        passengerCardTwo.add(new cardViewItem("Passagerarplats","Fönster"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats","golv"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats", "stänger"));
        passengerCardTwo.add(new cardViewItem("Passageraplats", "säten"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats", "tak"));


        ArrayList<cardViewItem> cardViewList = new ArrayList<>();
        cardViewList.addAll(passengerCardTwo);

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
                float awg = mPreference.getFloat("awg", 2);

                      //  float scoreThree = mPreference.getFloat("awg", 2);
                       // float awgThree = (scoreThree + awg) / 2;
                        editor.putFloat("awgThree", awg);
                        editor.apply();


                Intent nextIntent = new Intent(getApplicationContext(), ControllStep4Activity.class);
                startActivity(nextIntent);
            }
        });
    }
}
