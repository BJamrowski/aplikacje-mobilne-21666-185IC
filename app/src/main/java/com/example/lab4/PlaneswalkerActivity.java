package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaneswalkerActivity extends AppCompatActivity {


    public static final String EXTRA_DRINKID =  "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planeswalker);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Planeswalker planeswalker = Planeswalker.planeswalkers[drinkNo];

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(planeswalker.getImageResourceId());
        photo.setContentDescription(planeswalker.getName());

        TextView name = findViewById(R.id.name);
        name.setText(planeswalker.getName());

        TextView description = (TextView)findViewById(R.id.descritpions);
        description.setText(planeswalker.getDescription());
    }
}