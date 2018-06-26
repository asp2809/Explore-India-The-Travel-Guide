package com.example.android.exploreindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ImageButton funfact, touristplaces, hotandres, cuisines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        funfact=findViewById(R.id.funfacts);
        funfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,Funfact.class);
                startActivity(i);
            }
        });
        touristplaces=findViewById(R.id.touristplaces);
        touristplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,TouristActivity.class);
                startActivity(i);
            }
        });
        hotandres=findViewById(R.id.hotandres);
        hotandres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,HotelActivity.class);
                startActivity(i);
            }
        });
        cuisines=findViewById(R.id.cuisines);
        cuisines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,CuisineActivity.class);
                startActivity(i);
            }
        });
    }
}
