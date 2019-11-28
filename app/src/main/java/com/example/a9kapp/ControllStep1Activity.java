package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControllStep1Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    TextView Tv1;
    TextView Tv2;
    Button nextButton;
    RadioButton radio1;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step1);

        Tv1 = (TextView) findViewById(R.id.TextViewBussNmr);
        Tv2 = (TextView) findViewById(R.id.TextViewBusType);
        recyclerView = findViewById(R.id.my_recycler_view);
        nextButton = findViewById(R.id.button_next);

        radio1 = findViewById(R.id.radioButton1);

        //intent från activitet innan.
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
                String j = (String) b.get("name");
                Tv1.setText(j);
                String n = (String) b.get("number");
                Tv2.setText(n);

        }


        //skapar arraylist med driverCard.(Förarplats)
        ArrayList<cardViewItem> driverCard = new ArrayList<>();
        driverCard.add(new cardViewItem("Förarplats", "Speglar"));
        driverCard.add(new cardViewItem("Förarplats", "Vindruta"));
        driverCard.add(new cardViewItem("Förarplats", "Fönster"));
        driverCard.add(new cardViewItem("Förarplats", "FönsterPanel"));
        driverCard.add(new cardViewItem("Förarplats", "Instrumentpanel"));


        //adderar nya listan till cardViewList
        ArrayList<cardViewItem> cardViewList = new ArrayList<>();
        cardViewList.addAll(driverCard);


        //sätter recyclerviewen och aktiverar adapter.
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

                float awg = mPreference.getFloat("awg", -1);
                        editor.putFloat("awgOne", awg);
                        editor.apply();


                Bundle b = new Bundle();
                String s = Tv1.getText().toString();
                b.putString("number", s);
                String n = Tv2.getText().toString();
                b.putString("number",n);

                Intent newIntent = new Intent(getApplicationContext(), ControllStep2Activity.class);
                newIntent.putExtra("number", n);
                newIntent.putExtra("name", s);
                startActivity(newIntent);
            }
        });


    }
}


