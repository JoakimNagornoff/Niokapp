package com.example.a9kapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ControllStep1Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager mlayoutManager;

    TextView textView1;
    TextView textView2;
    int bussNMR;
    RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controll_step1);

        textView1 = (TextView) findViewById(R.id.TextView1);
        textView2 = (TextView) findViewById(R.id.TextView2);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if(b!=null){
            String j = (String)b.get("name");
            //int bussNMR =(int)b.get("buss");

            //textView1.setText(bussNMR);
            textView2.setText(j);
        }
       ArrayList<cardViewItem> cardViewList= new ArrayList<>();
        cardViewList.add(new cardViewItem("1/5", "Förarplats - Spegel"));
        cardViewList.add(new cardViewItem("2/5", "Förarplats - stol"));
        cardViewList.add(new cardViewItem("3/5", "Förarplats - fönster"));
        cardViewList.add(new cardViewItem("4/5", "Förarplats - instrumentpanel"));
        cardViewList.add(new cardViewItem("5/5", "Förarplats - väggar & tak"));


        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(cardViewList);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
       radioGroup1 = findViewById(R.id.RadioGroup1);
    }

    //RadioGroup1
    public void onRadioButtonClicked(View view ){
        boolean checked = ((RadioButton)view).isChecked();
      //  selectedRadioButton = (RadioButton)findViewById(radioGroup1.getCheckedRadioButtonId());

        switch (view.getId()){
            case R.id.radioButton1:
                if(checked)
                Log.d("radio", "checked");
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
    }

}
