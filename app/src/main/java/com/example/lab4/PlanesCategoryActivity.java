package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class PlanesCategoryActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView listPlanes = findViewById(R.id.list_planes);
        SQLiteOpenHelper mtgDatabaseHelper = new MtgDatabaseHelper(this);
        try {
            db = mtgDatabaseHelper.getReadableDatabase();
            cursor = db.query("MTGwalker",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                    cursor, new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listPlanes.setAdapter(listAdapter);
        }catch (SQLException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


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

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

}