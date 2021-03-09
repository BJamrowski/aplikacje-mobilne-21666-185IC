package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public  void onClickAdd(View view) {
        TextView output  = (TextView) findViewById(R.id.wynik);

        Spinner number = (Spinner) findViewById(R.id.spinner);

        Spinner number2 = (Spinner) findViewById(R.id.spinner2);


        int value = Integer.parseInt((String) number.getSelectedItem());

        int value2 = Integer.parseInt((String) number2.getSelectedItem());

        score= value + value2;

        output.setText(String.valueOf(score));
    }

    public  void onClickSubstract(View view) {
        TextView output  = (TextView) findViewById(R.id.wynik);

        Spinner number = (Spinner) findViewById(R.id.spinner);

        Spinner number2 = (Spinner) findViewById(R.id.spinner2);


        int value = Integer.parseInt((String) number.getSelectedItem());

        int value2 = Integer.parseInt((String) number2.getSelectedItem());

        score= value - value2;

        output.setText(String.valueOf(score));
    }

    public  void onClickTimes(View view) {
        TextView output  = (TextView) findViewById(R.id.wynik);

        Spinner number = (Spinner) findViewById(R.id.spinner);

        Spinner number2 = (Spinner) findViewById(R.id.spinner2);


        int value = Integer.parseInt((String) number.getSelectedItem());

        int value2 = Integer.parseInt((String) number2.getSelectedItem());

        score= value * value2;

        output.setText(String.valueOf(score));
    }

    public  void onClickDivide(View view) {
        TextView output  = (TextView) findViewById(R.id.wynik);

        Spinner number = (Spinner) findViewById(R.id.spinner);


        Spinner number2 = (Spinner) findViewById(R.id.spinner2);


        int value = Integer.parseInt((String) number.getSelectedItem());

        int value2 = Integer.parseInt((String) number2.getSelectedItem());

        if (value2 == 0 ){
            output.setText("Nie dziel przez 0!");
        }
        else{
            score= value / value2;

            output.setText(String.valueOf(score));
        }

    }

}