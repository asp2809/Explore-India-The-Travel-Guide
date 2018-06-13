package com.example.rupak.explore;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] str1={"West Bengal","Assam","Uttar Pradesh","Haryana","Himachal Pradesh"};
    ImageButton b1;

    AutoCompleteTextView a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=findViewById(R.id.auto1);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,str1);
        a1.setThreshold(1);
        a1.setAdapter(adp);
        b1=findViewById(R.id.button1);

    }
}
