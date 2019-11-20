package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class ControllStep2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    Button nextButtomtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step2);

        nextButtomtwo = findViewById(R.id.button_nexttwo);



        //skapar arraylast PassagerarCard
        ArrayList<cardViewItem> passengerCard = new ArrayList<>();
        passengerCard.add(new cardViewItem("Passagerarplats","Fönster"));
        passengerCard.add(new cardViewItem("Passagerarplats","golv"));
        passengerCard.add(new cardViewItem("Passagerarplats", "stänger"));
        passengerCard.add(new cardViewItem("Passageraplats", "säten"));
        passengerCard.add(new cardViewItem("Passagerarplats", "tak"));

        //adderar nya listan till cardViewlist för adaptern.
        ArrayList<cardViewItem> cardViewList = new ArrayList<>();
        cardViewList.addAll(passengerCard);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(cardViewList, this);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        nextButtomtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), ControllStep3Activity.class);
                startActivity(newIntent);
            }
        });


    }
}
