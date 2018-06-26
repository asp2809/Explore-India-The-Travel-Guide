package com.example.android.exploreindia;

public class Word {
    private  String mName;
    private String mTiming;
    private String mAddress;
    private int mImageResourceId;
    public static final int NO_IMAGE = -1;

    public Word(String Name, String Address, String Timing,int ImageResourceId){
        mName = Name;
        mTiming = Timing;
        mAddress = Address;
        mImageResourceId = ImageResourceId;
    }
//    public Word(String Name, String Timing, String Address){
//        mName = Name;
//        mTiming = Timing;
//        mAddress = Address;
//    }
    public String getAddress() {
        return mAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String get_Name() {
        return mName;
    }

    public String getTiming() {
        return mTiming;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE;
    }
}
