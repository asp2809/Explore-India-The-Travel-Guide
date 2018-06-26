package com.example.android.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CuisineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_3rd_screen);
        super.onCreate(savedInstanceState);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Chole-Bhature","Rajouri-Garden","9:00 am - 11:00pm",R.drawable.chole_bhature));
        words.add(new Word("Chole-Kulche","Cheche Di Hatti, Kamla Nagar, New Delhi","9:00am-4:00pm",R.drawable.chole_kulche));
        words.add(new Word("Rajma-Chawal","Baba Nagpal Corner,Lajpat Nagar,New Delhi","9:30am-6:00pm",R.drawable.rajma_chawal));
        words.add(new Word("Paranthe","Paranthe Waali Gali, Chandni Chowk","7:00am-8:00pm",R.drawable.paranthe));
        words.add(new Word("Kadi-Chawal","New Punjabi Khana,Nehru Place","9:00am-8:00pm",R.drawable.kadi_chawal));
        WordAdapter wordAdapter = new WordAdapter(this,words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = obj.edit();
                editor.putString("name", words.get(position).get_Name());
                editor.putString("address", words.get(position).getAddress());
                editor.putString("timing", words.get(position).getTiming());
                editor.putInt("image", words.get(position).getImageResourceId());
                editor.commit();
                Intent iobj = new Intent(getApplicationContext(), Details.class);
                startActivity(iobj);
            }
        });
    }

   }
