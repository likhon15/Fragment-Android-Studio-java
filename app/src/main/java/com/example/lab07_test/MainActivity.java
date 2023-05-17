package com.example.lab07_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // spinner code
        mySpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
         if(position == 1) {
             // MainActivity2 Intent
             // Intent intent= new Intent(MainActivity.this,MainActivity2.class);
             // startActivity(intent);
             changeFragment(new BlankFragment());
         }else if(position == 2) {
             // MainActivity2 Intent
             // Intent intent= new Intent(MainActivity.this,MainActivity3.class);
             // startActivity(intent);
             changeFragment(new BlankFragment2());
         }else{
             Toast.makeText(this, "please select your option", Toast.LENGTH_SHORT).show();
         }
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutID, fragment);
        ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}