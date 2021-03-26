package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlaneswalkerCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planeswalker_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Planeswalker> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Planeswalker.planeswalkers
        );
        ListView listPlaneswalkers = findViewById(R.id.list_planeswalkers);
        listPlaneswalkers.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listPlaneswalkers,
                                    View itemView,
                                    int position,
                                    long id) {
                //Pass the drink the user clicks on to DrinkActivity
                Intent intent = new Intent(PlaneswalkerCategoryActivity.this,
                        PlaneswalkerActivity.class);
                intent.putExtra(PlaneswalkerActivity.EXTRA_DRINKID, (int) id);
                startActivity(intent);
            }
        };
        //Assign the listener to the list view
        listPlaneswalkers.setOnItemClickListener(itemClickListener);
    }


}