package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlanesCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Plane> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Plane.planes
        );
        ListView listPlanes = findViewById(R.id.list_planes);
        listPlanes.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listPlanes,
                                    View itemView,
                                    int position,
                                    long id) {
                //Pass the drink the user clicks on to DrinkActivity
                Intent intent = new Intent(PlanesCategoryActivity.this,
                        PlaneActivity.class);
                intent.putExtra(PlaneActivity.EXTRA_DRINKID, (int) id);
                startActivity(intent);
            }
        };
        //Assign the listener to the list view
        listPlanes.setOnItemClickListener(itemClickListener);
    }


}