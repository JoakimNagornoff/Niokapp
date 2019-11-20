package com.example.a9kapp;

public class cardViewItem {
    private String mText1;
    private String mText2;
    private int mScore = 0;
    private boolean isSelected;

    public cardViewItem(String text1, String text2) {
        mText1 = text1;
        mText2 = text2;
    }

    public boolean getSelected(){
        return isSelected;
    }

    public void setSelected(boolean selected){
        isSelected = selected;
    }
    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public String getText1() {
        return mText1;
    }


    public String getText2() {
        return mText2;
    }

}