package com.example.a9kapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.shapes.Shape;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<cardViewItem> mCardViewList;
    private Context context;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        RadioGroup radioGroup;


        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.cardText1);
            mTextView2 = itemView.findViewById(R.id.cardText2);
            radioGroup = itemView.findViewById(R.id.RadioGroup1);
        }

    }


   /* public void saveRadioButtons() {
        mPreference = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putBoolean("first", radio1.isChecked());
        //editor.putBoolean("second", radio2.isChecked());
        editor.apply();

    }
   /* public void loadRadioButtons(){
        mPreference = PreferenceManager.getDefaultSharedPreferences(context);
        radio1.setChecked(mPreference.getBoolean("first", false));
        radio2.setChecked(mPreference.getBoolean("second", false));
        }*/

    //context method


    public MyAdapter(ArrayList<cardViewItem> cardViewList, Context context){
        mCardViewList = cardViewList;
        this.context = context;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

        //hämtar get method från cardViewItem class och sätter texten i ViewHoldern
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        final cardViewItem currentItem = mCardViewList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("radio", "position: " + position);
                switch (checkedId) {
                    case R.id.radioButton1:
                        currentItem.setmScore(1);
                        break;
                    case R.id.radioButton2:
                        currentItem.setmScore(2);
                        break;
                    case R.id.radioButton3:
                        currentItem.setmScore(3);
                        break;
                    case R.id.radioButton4:
                        currentItem.setmScore(4);
                        break;
                    case R.id.radioButton5:
                        currentItem.setmScore(5);
                        break;
                }
                float sum = 0;
                for (cardViewItem item : mCardViewList) {
                    sum += item.getmScore();
                }
                float awg = sum / mCardViewList.size();
                Log.d("awg", "" + awg);
                //  float awgTwo = sum / mCardViewList.size();
                SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor editor = mPreference.edit();

                editor.putFloat("awg", awg);
                editor.apply();




               /* int count = mPreference.getInt("count", -1);
              //  int count2 = mPreference.getInt("count2", 1);
                switch(count) {
                    case -1:
                        Log.d("count ", "case1 : " + count);
                        float score = mPreference.getFloat("awg", -1);
                        float awgOne = (score + awg) / 2;
                        Log.d("score", "score1 :" + score);
                        editor.putFloat("awgOne", awgOne);
                        editor.putInt("count", 1);
                        editor.apply();
                        break;
                    case 1:
                        Log.d("count", "case2 :" + count);
                        float scoreTwo = mPreference.getFloat("awg", 1);
                        Log.d("score", "score2 : " + scoreTwo);
                        float awgTwo = (scoreTwo + awg) / 2;
                        editor.putFloat("awgTwo", awgTwo);
                        editor.putInt("count", 2);
                        editor.apply();
                        break;
                    case 2:
                        Log.d("count", "case3 : " + count);
                        float scoreThree = mPreference.getFloat("awg", 2);
                        float awgThree = (scoreThree + awg) /2;
                        editor.putFloat("awgThree", awgThree);
                        editor.putInt("count", 3);
                        editor.apply();
                        break;
                    case 3:
                        Log.d("count", "case4 : " + count);
                        float scoreFour = mPreference.getFloat("awg", 3);
                        float awgFour = (scoreFour + awg) /2;
                        editor.putFloat("awgFour", awgFour);
                        editor.putInt("count", 4);
                        editor.apply();
                        break;
                }*/
            }



        });

    }
    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }




}
