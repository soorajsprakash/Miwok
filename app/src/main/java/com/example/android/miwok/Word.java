package com.example.android.miwok;

import android.media.MediaPlayer;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudioResourceId;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // create a new word object --- [CONSTRUCTOR]
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

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

    // get the audio
    public int getAudioResourceId() { return mAudioResourceId; }

    // method to find if a view have an image view
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
