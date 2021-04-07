package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArtifactsCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artifacts_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<Artifact> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Artifact.artifacts
        );
        ListView listArtifacts = findViewById(R.id.list_planes);
        listArtifacts.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listArtifacts,
                                    View itemView,
                                    int position,
                                    long id) {
                //Pass the drink the user clicks on to DrinkActivity
                Intent intent = new Intent(ArtifactsCategoryActivity.this,
                        ArtifactActivity.class);
                intent.putExtra(ArtifactActivity.EXTRA_DRINKID, (int) id);
                startActivity(intent);
            }
        };
        //Assign the listener to the list view
        listArtifacts.setOnItemClickListener(itemClickListener);
    }


}