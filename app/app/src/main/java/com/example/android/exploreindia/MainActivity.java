package com.example.android.exploreindia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    private LocationManager locationManager;
    ImageButton delhi, wb, mumbai;
    AutoCompleteTextView auto1;
    Button location1;
    ImageView button1;

    //JSON data from the link should be initialized to cities here
    String[] cities = {"Guwahati", "Patna", "Nagpur", "Bhopal", "Indore", "Gorakhpur", "Kolkata", "New Delhi", "Mumbai", "Bhubhaneshwar", "Munger", "Gurugram", "Noida", "Darjelling", "Kalyani", "Ahmedabad", "Bangalore", "Hydrabad"};
//    double[] latitudes = {26.148043, ‎28.535517, 25.612677, 21.146633, 23.259933};
//    double[] longitudes = {91.731377, ‎77.391029, ‎85.158875, 79.088860, ‎77.412613};
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto1 = findViewById(R.id.auto1);
        ArrayAdapter<String> adobj = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cities);
        auto1.setThreshold(1);
        auto1.setAdapter(adobj);
        Toast.makeText(MainActivity.this, "We now support only " + cities.length + " cities as of now!!", Toast.LENGTH_SHORT).show();
        delhi = findViewById(R.id.delhi);
        location1 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        auto1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "You chose " + auto1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MINIMUM_TIME_BETWEEN_UPDATES, MINIMUM_DISTANCE_CHANGE_FOR_UPDATES, (android.location.LocationListener) new MyLocationListener());

        location1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCurrentLocation();
            }
        });

        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = obj.edit();
                editor.putFloat("latitude", (float) 28.644800);
                editor.putFloat("longitude", (float) 77.216721);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        wb = (ImageButton) findViewById(R.id.wb);
        wb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = obj.edit();
                editor.putFloat("latitude", (float) 22.572645);
                editor.putFloat("longitude", (float) 88.363892);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        mumbai = (ImageButton) findViewById(R.id.mumbai);
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = obj.edit();
                editor.putFloat("latitude", (float) 19.228825);
                editor.putFloat("longitude", (float) 72.854118);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    protected void showCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Log.v("MainActivity", "" + location);
        if (location != null) {
            String message = String.format(
                    "Current Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            SharedPreferences obj = getSharedPreferences("mydb", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = obj.edit();
            editor.putFloat("latitude", (float) location.getLatitude());
            editor.putFloat("longitude", (float) location.getLongitude());
            editor.apply();
            Geocoder gcd = new Geocoder(MainActivity.this, Locale.getDefault());
            List<Address> addresses = null;
            try {
                addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addresses.size() > 0) {
                Toast.makeText(MainActivity.this, "You are in " + addresses.get(0).getLocality(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(MainActivity.this, "Some Error Occured!", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(MainActivity.this, "Location not found", Toast.LENGTH_SHORT).show();
        }
    }

    public class MyLocationListener implements LocationListener {

        public void onLocationChanged(Location loc) {
            String message = String.format(
                    "New Location \n Longitude: %1$s \n Latitude: %2$s",
                    loc.getLongitude(), loc.getLatitude()
            );
        }
        public void onProviderDisabled(String arg0) {

        }
        public void onProviderEnabled(String provider) {

        }
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    }
}