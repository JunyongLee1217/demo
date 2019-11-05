package com.icarus.sapling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "plants.db";
    public static final String TABLE_NAME = "plants_table";
    public static final String COL_1 = "PLANT_NAME"; // self explanatory
    public static final String COL_2 = "PLANT_TYPE";
    public static final String COL_3 = "SUN_REQ";
    public static final String COL_4 = "WATER_Q"; // water quantity per week
    public static final String COL_5 = "WATER_F"; // floats per week
    public static final String COL_6 = "SOIL"; // soil quality
    public static final String COL_7 = "SPACE_NEEDS"; // radius in feet
    public static final String COL_8 = "MATURATION"; // average weeks
    public static final String COL_9 = "YIELD"; // in pounds
    public static final String COL_10 = "VULNERABILITIES";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlcreate = "CREATE TABLE";
        sqlcreate += " " + TABLE_NAME + " (";
        sqlcreate += " " + COL_1 + " CHAR(24),";
        sqlcreate += " " + COL_2 + " CHAR(24),";
        sqlcreate += " " + COL_3 + " CHAR(10),";
        sqlcreate += " " + COL_4 + " INT(5),";
        sqlcreate += " " + COL_5 + " FLOAT(7, 4),";
        sqlcreate += " " + COL_6 + " CHAR(8),";
        sqlcreate += " " + COL_7 + " FLOAT(5, 2),";
        sqlcreate += " " + COL_8 + " INT(5),";
        sqlcreate += " " + COL_9 + " FLOAT(5, 2),";
        sqlcreate += " " + COL_10 + " CHAR(96)";
        sqlcreate += " " + ");";
        db.execSQL(sqlcreate);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}