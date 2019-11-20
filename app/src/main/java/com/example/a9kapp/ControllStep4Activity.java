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

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;


    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step4);

        nextButton = (Button) findViewById(R.id.button_nextFour);

        editText1 = (EditText) findViewById(R.id.editTextStep1);
        editText2 = (EditText)findViewById(R.id.editTextStep2);
        editText3 = (EditText)findViewById(R.id.editTextStep3);
        editText4 = (EditText) findViewById(R.id.editTextStep4);

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

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(getApplicationContext(), DisplayActivity.class);
                startActivity(nextIntent);
            }
        });

    }
}
