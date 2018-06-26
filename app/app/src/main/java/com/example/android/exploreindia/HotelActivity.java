package com.example.android.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_3rd_screen);
        super.onCreate(savedInstanceState);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("The Taj Mahal Hotel","No.1, Man Singh Rd, South Block, Man Singh Road Area, New Delhi","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.tajmahalhotel));
        words.add(new Word("The Eros Hotel","S1, American Plaza, ITT Building, Lala Lajpat Rai Road, Nehru Place, New Delhi","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.eroshotel));
        words.add(new Word("The Lodhi","Lodhi Rd, CGO Complex, Pragati Vihar, New Delhi ","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.thelodhihotel));
        words.add(new Word("JRD Luxury Boutique Hotel","B-7/113A, Ch. Harsukh Marg, Block B 7, Arjun Nagar, Safdarjung Enclave, New Delhi","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.jrdluxuryhotel));
        words.add(new Word("The Oberoi, New Delhi","Dr. Zakir Hussain Marg, Delhi Golf Club, Golf Links, New Delhi","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.theoberoihotel));
        words.add(new Word("Jaypee Vasant Continental","Basant Lok, Vasant Vihar, New Delhi","11:00 am - Check-in, 12:00 pm - Checkout",R.drawable.jphotel));
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
