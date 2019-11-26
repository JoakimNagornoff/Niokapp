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
import android.widget.TextView;

import java.util.ArrayList;

public class ControllStep2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    TextView Tv1;
    TextView Tv2;
    Button nextButtomtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step2);

        nextButtomtwo = findViewById(R.id.button_nexttwo);
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

        final SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = mPreference.edit();

        nextButtomtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float awg = mPreference.getFloat("awg", 1);
                        editor.putFloat("awgTwo", awg);
                        editor.apply();


                Bundle b = new Bundle();
                String s = Tv1.getText().toString();
                b.putString("name", s);
                String n = Tv2.getText().toString();
                b.putString("number",n);

                Intent newIntent = new Intent(getApplicationContext(), ControllStep3Activity.class);
                newIntent.putExtra("name", s);
                newIntent.putExtra("number",n);
                startActivity(newIntent);


            }
        });


    }
}
