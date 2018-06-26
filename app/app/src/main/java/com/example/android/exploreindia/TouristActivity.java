package com.example.android.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TouristActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_3rd_screen);
        super.onCreate(savedInstanceState);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("The Red Fort","Netaji Subhash Marg, Lal Qila, Chandni Chowk","Sunrise till Sunset",R.drawable.redfort));
        words.add(new Word("Qutub Minar","Mehrauli, New Delhi, Delhi 110030 \n","9:00am-4:00pm",R.drawable.qutbminar));
        words.add(new Word("India Gate","Rajpath Marg, India Gate, New Delhi, Delhi 110001 ","9:30am-6:00pm",R.drawable.indiagate));
        words.add(new Word("Jama Masjid","Meena Bazaar, Jama Masjid, Chandni Chowk, New Delhi","7:00am-8:00pm",R.drawable.jamamasjid));
        words.add(new Word("Lotus Temple","Lotus Temple Rd, Bahapur, Shambhu Dayal Bagh, Kalkaji, New Delhi","9:00am-8:00pm",R.drawable.lotustemple));
        words.add(new Word("Akshardham","Noida Mor, Pandav Nagar, New Delhi","9:00am-8:00pm",R.drawable.akshardham));
        words.add(new Word("Rashtrapati Bhavan","Rashtrapati Bhawan, President's Estate, New Delhi","9:00am-8:00pm",R.drawable.rashtrapatibhavan));
        words.add(new Word("Humayun's Tomb","Mathura Road, Opposite Dargah Nizamuddin, New Delhi","6:00am - 6:00pm",R.drawable.humayuntomb));
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
