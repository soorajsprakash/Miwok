package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // create a new word object --- [CONSTRUCTOR]
    public Word(String defaultTranslation, String miwokTranslation){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;

    }

    // get default translation
    public String getDefaultTranslation(){
        return  mDefaultTranslation;
    }

    // get miwok translation
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    // get image
    public int getImageResourceId() { return mImageResourceId; }


    // method to find if a view have an image view
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
