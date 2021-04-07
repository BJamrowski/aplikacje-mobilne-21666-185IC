package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtifactActivity extends AppCompatActivity {


    public static final String EXTRA_DRINKID =  "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Artifact artifact = Artifact.artifacts[drinkNo];

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(artifact.getImageResourceId());
        photo.setContentDescription(artifact.getName());

        TextView name = findViewById(R.id.name);
        name.setText(artifact.getName());

        TextView description = (TextView)findViewById(R.id.descritpions);
        description.setText(artifact.getDescription());
    }
}