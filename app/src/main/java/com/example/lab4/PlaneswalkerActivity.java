package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        SQLiteOpenHelper MTGDatabaseHelper = new MtgDatabaseHelper(this);
        try{
            SQLiteDatabase db = MTGDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("MTGwalker",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ? ",
                    new String[] {Integer.toString(drinkNo)},
                    null, null, null);
            if (cursor.moveToFirst()){
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                TextView name = findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView)findViewById(R.id.descritpions);
                description.setText(descriptionText);

                CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            }
            cursor.close();
            db.close();
        }catch (SQLException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    public void onFavoriteClicked(View view){
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);

        new UpdateDrinkTask().execute(drinkId);
    }

    private class UpdateDrinkTask extends AsyncTask<Integer, Void, Boolean>{
        private ContentValues drinkValues;

        protected void onPreExecute(){
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
            drinkValues = new ContentValues();
            drinkValues.put("FAVORITE", favorite.isChecked());
        }

        protected Boolean doInBackground(Integer... drinks){
            int drinkId = drinks[0];
            SQLiteOpenHelper mtgwalkerDatabaseHelper = new MtgDatabaseHelper(PlaneswalkerActivity.this);
            try {
                SQLiteDatabase db = mtgwalkerDatabaseHelper.getWritableDatabase();
                db.update("MTGwalker", drinkValues, "_id = ?", new String[] {Integer.toString(drinkId)});
                db.close();
                return true;
            }catch (SQLException e){
                return false;
            }
        }

        protected void onPostExecute(Boolean success){
            if (!success){
                Toast toast = Toast.makeText(PlaneswalkerActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}