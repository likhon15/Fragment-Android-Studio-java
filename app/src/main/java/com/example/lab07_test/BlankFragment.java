package com.example.lab07_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BlankFragment extends Fragment {
    View myView;
    EditText weightText, heightText;
    TextView outputView;
    Button myBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_blank, container, false);
        weightText=myView.findViewById(R.id.firstVal);
        heightText=myView.findViewById(R.id.secondVal);
        outputView=myView.findViewById(R.id.showRES);
        myBtn=myView.findViewById(R.id.bmiBtn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DecimalFormat df = new DecimalFormat("0.00");
                Double weight, height, bmi;
                weight = Double.parseDouble(weightText.getText().toString());
                height=  Double.parseDouble(heightText.getText().toString());
                bmi =  weight / (height*height);
                outputView.setText("BMI is " + df.format(bmi));
            }
        });
        return myView;
    }
}