package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //resource id for background color for the list of words
    private  int mColorResourceID;

//    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceID = colorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent ) {

        View listItemView = convertView;
        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        // get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID list
        TextView mivokTextView = (TextView) listItemView.findViewById(R.id.mivok_text_view);
        // Get the miwok translation from the current Word object and set this text on the name TextView
        mivokTextView.setText(currentWord.getMiwokTranslation());


        // Find the TextView in the list_item.xml layout with the ID list
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the current Word object and set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find the ImageView in the list_item.xml layout with the ID list
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            // if an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // set the theme color for the list of item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // find the color that resource id maps to
        textContainer.setBackgroundColor(color);


        //audio


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView
        // Return super.getView(position, convertView, parent);
        return listItemView;

    }
}
