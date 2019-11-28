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
import android.widget.TextView;

import java.util.ArrayList;

public class ControllStep3Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    Button nextButton;
    TextView Tv1;
    TextView Tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step3);

        nextButton = findViewById(R.id.button_nextthree);
        Tv1 = findViewById(R.id.TextViewBussNmr);
        Tv2 = findViewById(R.id.TextViewBusType);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String s = (String) b.get("number");
            Tv2.setText(s);
            String n = (String) b.get("name");
            Tv1.setText(n);
        }


        ArrayList<cardViewItem> passengerCardTwo = new ArrayList<>();
        passengerCardTwo.add(new cardViewItem("Passagerarplats","Fönster"));
        passengerCardTwo.add(new cardViewItem("Passageraplats", "Fönsterkarm"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats","Golv"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats", "Stänger"));
        passengerCardTwo.add(new cardViewItem("Passagerarplats", "Tak"));


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
                        editor.putFloat("awgThree", awg);
                        editor.apply();

                Bundle b = new Bundle();
                String s = Tv1.getText().toString();
                b.putString("number", s);
                String n = Tv2.getText().toString();
                b.putString("number",n);

                Intent newIntent = new Intent(getApplicationContext(), ControllStep4Activity.class);
                newIntent.putExtra("number", n);
                newIntent.putExtra("name", s);
                startActivity(newIntent);
            }
        });
    }
}
