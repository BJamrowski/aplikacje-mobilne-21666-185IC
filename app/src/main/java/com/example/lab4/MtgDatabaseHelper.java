package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MtgDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mtg";
    private static final int DB_VERSION = 2;

    public MtgDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertMTGwalker(SQLiteDatabase db, String name, String description, int resourceID){
        ContentValues walkerValues = new ContentValues();
        walkerValues.put("NAME", name);
        walkerValues.put("DESCRIPTION", description);
        walkerValues.put("IMAGE_RESOURCE_ID", resourceID);
        db.insert("MTGwalker", null, walkerValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion <1 ){
            db.execSQL("CREATE TABLE MTGwalker (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "DESCRIPTION TEXT," +
                    "IMAGE_RESOURCE_ID INTEGER);");

            insertMTGwalker(db, "Liliana Vess",
                    "Human planeswalker from Dominaria and is both a master necromancer" +
                            " and a healer.",
                    R.drawable.liliana);
            insertMTGwalker(db, "Nicol Bolas",
                    "The now nameless planeswalker once named Nicol Bolas (born as just Nicol), is the youngest" +
                            " and most infamous of the seven Elder Dragons to have survived the Elder Dragon War.",
                    R.drawable.bolas);
            insertMTGwalker(db, "Gideon Jura",
                    "He was a hieromancer and planeswalker beholden to the " +
                            "multiplanar coalition known as the Gatewatch. Affectionately called Gids by " +
                            "Chandra Nalaar and called Beefslab by Liliana Vess. ",
                    R.drawable.gideon);
        }
        if (oldVersion < 2){
            db.execSQL("ALTER TABLE MTGwalker ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
