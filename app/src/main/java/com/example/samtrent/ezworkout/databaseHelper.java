package com.example.samtrent.ezworkout;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class databaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = databaseHelper.class.getName();

    private static final String DATABASE_NAME = "OurDatabase";
    private static final int DATABASE_VERSION = 21;

    // Workouts table and columns name
    private static final String TABLE_WORKOUTS = "Workouts";
    private static final String KEY_W_ID = "W_ID";
    private static final String KEY_W_NAME = "W_Name";
    private static final String KEY_W_PROCEDURE = "W_Procedure";
    private static final String KEY_W_IS_FAVORITE = "W_isFavorite";
    private static final String KEY_W_MUSCLE_GROUP = "W_Muscle_Group";
    private static final String KEY_W_GIF_NAME = "W_Gif_Name";
    // Workouts table create
    private static final String CREATE_WORKOUTS_TABLE =
            "CREATE TABLE " + TABLE_WORKOUTS +
                    "(" + KEY_W_ID + " INTEGER PRIMARY KEY, " +
                    KEY_W_NAME + " TEXT, " +
                    KEY_W_PROCEDURE + " TEXT, " +
                    KEY_W_MUSCLE_GROUP + " INTEGER, " +
                    KEY_W_IS_FAVORITE + " INTEGER, " +
                    KEY_W_GIF_NAME + " TEXT" + ")";

    // Workouts_lists table and column names
    private static final String TABLE_WORKOUT_LIST = "Workout_Lists";
    private static final String KEY_WL_ID = "WL_ID";
    private static final String KEY_WL_MUSCLE_GROUP = "WL_Muscle_Group";
    private static final String KEY_WL_PLACE = "WL_Place";
    private static final String KEY_WL_ICON = "WL_Icon";
    // Workouts_list table create
    private static final String CREATE_WORKOUTS_LIST_TABLE =
            "CREATE TABLE " + TABLE_WORKOUT_LIST +
                    "(" + KEY_WL_ID + " INTEGER PRIMARY KEY," +
                    KEY_WL_MUSCLE_GROUP + " TEXT, " +
                    KEY_WL_PLACE + " INTEGER, " +
                    KEY_WL_ICON + " TEXT" + ")";

    // Places table and column names
    private static final String TABLE_PLACE = "Places";
    private static final String KEY_P_ID = "P_ID";
    private static final String KEY_P_PLACE = "P_Place";
    // Places table create
    private static final String CREATE_PLACE_TABLE =
            "CREATE TABLE " + TABLE_PLACE +
                    "(" + KEY_P_ID + " INTEGER PRIMARY KEY," +
                    KEY_P_PLACE + " TEXT" + ")";

    // Favorite Workouts table and column names
    private static final String TABLE_FAVORITE_WORKOUTS = "Favorite_Workouts";
    private static final String KEY_FW_ID = "FW_ID";
    private static final String KEY_FW_WORKOUT = "FW_Workout";
    // Favorite Workouts table create
    private static final String CREATE_FAV_WORKOUTS_TABLE =
            "CREATE TABLE " + TABLE_FAVORITE_WORKOUTS +
                    "(" + KEY_FW_ID + " INTEGER PRIMARY KEY," +
                    KEY_FW_WORKOUT + " INTEGER" + ")";


    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_FAV_WORKOUTS_TABLE);
        db.execSQL(CREATE_WORKOUTS_TABLE);
        db.execSQL(CREATE_WORKOUTS_LIST_TABLE);
        db.execSQL(CREATE_PLACE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE_WORKOUTS);

        Log.e("DB", "The Upgrade method was called");

        // create new tables
        onCreate(db);
    }

    /**************************************************************************
     *
     * Workout methods
     *
     *************************************************************************/
    /*
    * insert into workout
    */
    public long insert_Workout(Workout workout, long workout_list_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_W_ID, workout.getId());
        values.put(KEY_W_NAME, workout.getName());
        values.put(KEY_W_PROCEDURE, workout.getProcedure());
        values.put(KEY_W_IS_FAVORITE, workout.getIsFavorite());
        values.put(KEY_W_MUSCLE_GROUP, workout_list_id);
        values.put(KEY_W_GIF_NAME, workout.getGifName());

        // insert row
        long workout_id = db.insert(TABLE_WORKOUTS, null, values);
        return workout_id;
    }

    /*
    * query single Workout
    */
    public Workout query_Workout(long workout_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_WORKOUTS + " WHERE "
                + KEY_W_ID + " = " + workout_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Workout w = new Workout();
        w.setId(c.getInt(c.getColumnIndex(KEY_W_ID)));
        w.setName((c.getString(c.getColumnIndex(KEY_W_NAME))));
        w.setProcedure((c.getString(c.getColumnIndex(KEY_W_PROCEDURE))));
        w.setFk_muscleGroup((c.getInt(c.getColumnIndex(KEY_W_MUSCLE_GROUP))));
        w.setIsFavorite(c.getInt(c.getColumnIndex(KEY_W_IS_FAVORITE)));
        w.setGifName(c.getString(c.getColumnIndex(KEY_W_GIF_NAME)));

        return w;
    }

    /**
     * query all workouts
     * */
    public List<Workout> query_All_Workouts(long muscle_group_id) {
        List<Workout> workouts = new ArrayList<Workout>();
        String selectQuery = "SELECT * FROM " + TABLE_WORKOUTS + " WHERE " + KEY_W_MUSCLE_GROUP + " = " + muscle_group_id;

                //" w INNER JOIN " +
                //TABLE_WORKOUT_LIST + " wl ON wl." + KEY_WL_ID + " = w." + KEY_W_MUSCLE_GROUP +
                //" WHERE wl." + KEY_WL_ID + " = " + muscle_group_id;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Workout w = new Workout();
                w.setId((c.getInt(c.getColumnIndex(KEY_W_ID))));
                w.setName((c.getString(c.getColumnIndex(KEY_W_NAME))));
                w.setProcedure((c.getString(c.getColumnIndex(KEY_W_PROCEDURE))));
                w.setFk_muscleGroup((c.getInt(c.getColumnIndex(KEY_W_MUSCLE_GROUP))));
                w.setGifName(c.getString(c.getColumnIndex(KEY_W_GIF_NAME)));

                // adding to tags list
                workouts.add(w);
            } while (c.moveToNext());
        }
        return workouts;
    }

    public void update_Fav_Workout(int isFav, int id) {
        String update = "UPDATE " + TABLE_WORKOUTS + " SET " + KEY_W_IS_FAVORITE +
                " = " + isFav + " WHERE " + KEY_W_ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(update);
    }

    /**************************************************************************
     *
     * Workout_List methods
     *
     *************************************************************************/
    /*
    * insert into workout_list
    */
    public long insert_Workout_List(Workout_List workout_list, long place_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_WL_ID, workout_list.getId());
        values.put(KEY_WL_MUSCLE_GROUP, workout_list.getMuscleGroup());
        values.put(KEY_WL_PLACE, place_id);
        values.put(KEY_WL_ICON, workout_list.getIcon());

        // insert row
        long workout_list_id = db.insert(TABLE_WORKOUT_LIST, null, values);
        return workout_list_id;
    }

    /*
    * query single Workout_List
    */
    public Workout_List query_Workout_List(long workout_list_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_WORKOUT_LIST + " WHERE "
                + KEY_WL_ID + " = " + workout_list_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Workout_List wl = new Workout_List();
        wl.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
        wl.setMuscleGroup((c.getString(c.getColumnIndex(KEY_WL_MUSCLE_GROUP))));
        wl.setFk_place((c.getInt(c.getColumnIndex(KEY_WL_PLACE))));
        wl.setIcon(c.getString(c.getColumnIndex(KEY_WL_ICON)));

        return wl;
    }

    /**
     * query all workout_lists
     * */
    public List<Workout_List> query_All_Workout_Lists(String place) {
        List<Workout_List> workout_lists = new ArrayList<Workout_List>();
        String selectQuery = "SELECT * FROM " + TABLE_WORKOUT_LIST + " wl INNER JOIN " +
                TABLE_PLACE + " p ON p." + KEY_P_ID + " = wl." + KEY_WL_PLACE + " WHERE p." + KEY_P_PLACE + " = \"" + place + "\"";

        //Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Workout_List wl = new Workout_List();
                wl.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
                wl.setMuscleGroup((c.getString(c.getColumnIndex(KEY_WL_MUSCLE_GROUP))));
                wl.setFk_place((c.getInt(c.getColumnIndex(KEY_WL_PLACE))));
                wl.setIcon(c.getString(c.getColumnIndex(KEY_WL_ICON)));

                // adding to tags list
                workout_lists.add(wl);
            } while (c.moveToNext());
        }
        return workout_lists;
    }

    /**************************************************************************
     *
     * Place methods
     *
     *************************************************************************/
    /*
    * insert into place
    */
    public long insert_Place(Place place) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_ID, place.getId());
        values.put(KEY_P_PLACE, place.getPlace());

        // insert row
        long place_id = db.insert(TABLE_PLACE, null, values);
        return place_id;
    }

    /*
    * guery single Place
    */
    public Place query_Place(long place_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_PLACE + " WHERE "
                + KEY_P_ID + " = " + place_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Place p = new Place();
        p.setId(c.getInt(c.getColumnIndex(KEY_P_ID)));
        p.setPlace((c.getString(c.getColumnIndex(KEY_P_PLACE))));

        return p;
    }

    /**
     * query all places
     * */
    public List<Place> query_All_Places() {
        List<Place> places = new ArrayList<Place>();
        String selectQuery = "SELECT  * FROM " + TABLE_PLACE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Place p = new Place();
                p.setId(c.getInt((c.getColumnIndex(KEY_P_ID))));
                p.setPlace(c.getString(c.getColumnIndex(KEY_P_PLACE)));

                // adding to tags list
                places.add(p);
            } while (c.moveToNext());
        }
        return places;
    }

    /**************************************************************************
     *
     * Favorite_Workout methods
     *
     *************************************************************************/
    /*
    * insert into favorite_workouts
    */
    public long insert_Favorite_Workout(My_Workouts my_workouts, long workout_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FW_WORKOUT, workout_id);

        // insert row
        long fave_workout_id = db.insert(TABLE_FAVORITE_WORKOUTS, null, values);
        return fave_workout_id;
    }

    /*
    * query single Favorite_Workout
    */
    public My_Workouts query_My_Workouts(long fave_workout_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_FAVORITE_WORKOUTS + " WHERE "
                + KEY_FW_ID + " = " + fave_workout_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        My_Workouts mw = new My_Workouts();
        mw.setId(c.getInt(c.getColumnIndex(KEY_WL_ID)));
        mw.setFk_workout((c.getInt(c.getColumnIndex(KEY_FW_WORKOUT))));

        return mw;
    }

    /**
     * query all my_workouts
     * */
    public List<Workout> query_All_My_Workouts() {
        List<Workout> my_workouts = new ArrayList<Workout>();
        String selectQuery = "SELECT " + KEY_W_ID + ", " + KEY_W_MUSCLE_GROUP +
                ", " + KEY_W_NAME + ", " + KEY_W_PROCEDURE + " FROM " +
                TABLE_WORKOUTS + " INNER JOIN " + TABLE_FAVORITE_WORKOUTS + " ON " +
                KEY_W_ID + " = " + KEY_FW_WORKOUT;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Workout w = new Workout();
                w.setId(c.getInt(c.getColumnIndex(KEY_W_ID)));
                w.setFk_muscleGroup((c.getInt(c.getColumnIndex(KEY_W_MUSCLE_GROUP))));
                w.setName(c.getString(c.getColumnIndex(KEY_W_NAME)));
                w.setProcedure(c.getString(c.getColumnIndex(KEY_W_PROCEDURE)));

                // adding to tags list
                my_workouts.add(w);
            } while (c.moveToNext());
        }
        return my_workouts;
    }



    public void remove_Favorite_Workout(int w_Id) {
        String removeQuery = "DELETE FROM " + TABLE_FAVORITE_WORKOUTS + " WHERE " +
                KEY_FW_WORKOUT + " = " + w_Id;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(removeQuery);
    }



    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public void clearDB() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITE_WORKOUTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUT_LIST);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE);
        }
    }

    public int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public String getDatabaseName() { return DATABASE_NAME; }

}
