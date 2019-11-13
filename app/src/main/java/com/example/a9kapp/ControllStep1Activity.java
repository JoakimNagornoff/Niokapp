package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
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

    TextView textView1;
    TextView textView2;
    TextView textView3;


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

        //intent från activitet innan.
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String j = (String) b.get("name");
            //int bussNMR =(int)b.get("buss");

            //textView1.setText(bussNMR);
            textView2.setText(j);
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
        mAdapter = new MyAdapter(cardViewList);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}


  /*  //RadioGroup1
    public void onRadioButtonClicked(View view ){
        boolean checked = ((RadioButton)view).isChecked();
      //  selectedRadioButton = (RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());

        switch (view.getId()){
            case R.id.radioButton1:
                if(checked) {

                    Log.d("radio", "" + mScore);
                }
                break;
                case R.id.radioButton2:
                    if(checked)
                    Log.d("radio", "checked2");

                    break;
                    case R.id.radioButton3:
                        if(checked)
                        Log.d("radio", "check3");
                        break;
            case R.id.radioButton4:
                if(checked)
                Log.d("radio", "checked4");
                break;

            case R.id.radioButton5:
                if(checked)
                Log.d("radio", "checked5");
                break;


        }
    }*/



