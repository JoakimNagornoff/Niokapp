package com.example.a9kapp;

public class SavedBussCardViewItem {
    private String  mBussSumAverage;
    private String mBussNumber;
    private String mText1;

    public SavedBussCardViewItem(String text1, String BussNumber, String BussSumAverage){
        mText1 = text1;
        mBussNumber = BussNumber;
        mBussSumAverage = BussSumAverage;
    }

    public String getmBussSumAverage() {
        return mBussSumAverage;
    }

    public void setmBussSumAverage(String mBussSumAverage) {
        this.mBussSumAverage = mBussSumAverage;
    }

    public void setmBussNumber(String mBussNumber) {
        this.mBussNumber = mBussNumber;
    }

    public String getmBussNumber() {
        return mBussNumber;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }
}
