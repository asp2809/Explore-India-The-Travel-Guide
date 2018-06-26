package com.example.android.exploreindia;

import android.app.Activity;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currentWord = getItem(position);
        TextView name = listView.findViewById(R.id.name);
        name.setText(currentWord.get_Name());
        TextView timing = listView.findViewById(R.id.timing);
        timing.setText(currentWord.getTiming());
        TextView address = listView.findViewById(R.id.address);
        address.setText(currentWord.getAddress());
        CardView cardView = listView.findViewById(R.id.card);
        if(currentWord.hasImage())
            cardView.setBackgroundResource(currentWord.getImageResourceId());
        else
            cardView.setVisibility(View.GONE);
        return listView;
    }
}
