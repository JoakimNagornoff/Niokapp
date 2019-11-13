package com.example.a9kapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<cardViewItem> mCardViewList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mScore;
        RadioGroup radioGroup;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.cardText1);
            mTextView2 = itemView.findViewById(R.id.cardText2);
            mScore = itemView.findViewById(R.id.Result_textView);
            radioGroup = itemView.findViewById(R.id.RadioGroup1);
        }

    }
    public MyAdapter(ArrayList<cardViewItem> cardViewList){
        mCardViewList = cardViewList;

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
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                Log.d("radio", "position: " + position);
            switch (checkedId){
                case R.id.radioButton1:
                    currentItem.setmScore(1);
                    break;
                case R.id.radioButton2:
                    currentItem.setmScore(2);
                    break;
                case R.id.radioButton3:
                    currentItem.setmScore(3);
                    break;
                case  R.id.radioButton4:
                    currentItem.setmScore(4);
                    break;
                case R.id.radioButton5:
                    currentItem.setmScore(5);
                    break;
            }
                int sum = 0;
                for(cardViewItem  item : mCardViewList){
                    sum += item.getmScore();
                }
                Log.d("radioSUM","" + sum);
                int awg = sum / mCardViewList.size();
                Log.d("radioAWG","" + awg);

                /*String str = String.valueOf(awg);
                holder.TextView3.setText(str);*/

                //Bygga en knapp som tar oss vidare till nästa aktivietet
                //
            }
        });
    }
    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }

}
