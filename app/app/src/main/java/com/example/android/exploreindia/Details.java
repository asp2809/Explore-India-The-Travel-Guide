package com.example.android.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView name, address, timings;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        timings=findViewById(R.id.timing);
        image=findViewById(R.id.image);
        SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = obj.edit();
        name.setText(obj.getString("name", ""));
        address.setText(obj.getString("address", ""));
        timings.setText(obj.getString("timing", ""));
        image.setImageResource(obj.getInt("image", 0));
        editor.commit();
    }

    public void gotowebsite(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.delhitourism.gov.in/delhitourism/index.jsp"));
        startActivity(i);
    }
}
