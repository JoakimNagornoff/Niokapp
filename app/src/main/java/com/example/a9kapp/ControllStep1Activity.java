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
    private SharedPreferences mPreference;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button nextButton;
    RadioButton radio1;


    int bussNMR;
    RadioGroup radioGroup1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step1);

        textView1 = (TextView) findViewById(R.id.TextView1);
        textView2 = (TextView) findViewById(R.id.TextView2);
        textView3 = (TextView) findViewById(R.id.TextView3);
        recyclerView = findViewById(R.id.my_recycler_view);
        nextButton = findViewById(R.id.button_next);

        radio1 = findViewById(R.id.radioButton1);

        //intent från activitet innan.
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String j = (String) b.get("name");
            //int bussNMR =(int)b.get("buss");

            //textView1.setText(bussNMR);
            //  textView2.setText(j);
        }


        //skapar arraylist med driverCard.(Förarplats)
        ArrayList<cardViewItem> driverCard = new ArrayList<>();
        driverCard.add(new cardViewItem("Förarplats", "Stol"));
        driverCard.add(new cardViewItem("Förarplats", "Spegel"));
        driverCard.add(new cardViewItem("Förarplats", "Vindrutor/Fönster"));
        driverCard.add(new cardViewItem("Förarplats", "FönsterPanel"));
        driverCard.add(new cardViewItem("Förarplats", "Instrumentpanel"));


        //adderar nya listan till cardViewList
        ArrayList<cardViewItem> cardViewList = new ArrayList<>();
        cardViewList.addAll(driverCard);


        //sätter recyclerviewen och aktiverar adapter.
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(cardViewList,this);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), ControllStep2Activity.class);
                startActivity(newIntent);
            }
        });

    }
}



