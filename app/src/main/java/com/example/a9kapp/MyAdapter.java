package com.example.a9kapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<cardViewItem> mCardViewList;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        public TextView mTextView2;

        public MyViewHolder(View itemView){
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.cardText1);
            mTextView2 = itemView.findViewById(R.id.cardText2);
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        cardViewItem currentItem = mCardViewList.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mCardViewList.size();
    }
}
