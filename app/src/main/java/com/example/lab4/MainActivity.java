package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor favoritesCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupOptionsListView();
        setupFavoritesListView();
    }

    private void setupOptionsListView(){
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, PlaneswalkerCategoryActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intentPlane = new Intent(MainActivity.this, PlanesCategoryActivity.class);
                        startActivity(intentPlane);
                        break;
                    case 2:
                        Intent intentArtifact = new Intent(MainActivity.this, ArtifactsCategoryActivity.class);
                        startActivity(intentArtifact);
                        break;
                }
            }
        };
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void setupFavoritesListView(){
        ListView listFavorites = findViewById(R.id.list_favorites);
        try {
            SQLiteOpenHelper mtgawlkerDatabasehelper = new MtgDatabaseHelper(this);
            db = mtgawlkerDatabasehelper.getReadableDatabase();
            favoritesCursor = db.query("MTGwalker", new String[] {"_id", "NAME"}, "FAVORITE = 1", null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, favoritesCursor,
                    new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
        }catch (SQLException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        listFavorites.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, PlaneswalkerActivity.class);
            intent.putExtra(PlaneswalkerActivity.EXTRA_DRINKID, (int)id);
            startActivity(intent);
        });
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Cursor newCursor = db.query("MTGwalker",
                new String[] { "_id", "NAME"},
                "FAVORITE = 1",
                null, null, null, null);
        ListView listFavorites = findViewById(R.id.list_favorites);
        CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
        //adapter.changeCursor(newCursor);
        //favoritesCursor = newCursor;
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}