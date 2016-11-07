package com.example.samtrent.ezworkout;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


/**
 * Created by Elgalad on 10/28/16.
 */

public class databaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "workout.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Place, Integer> placeDao = null;
    private RuntimeExceptionDao<Place, Integer> runtimeDao = null;

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {

        try {
            Log.i(databaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Place.class);
        } catch (SQLException e) {
            Log.e(databaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }


        // here we try inserting data in the on-create as a test
        RuntimeExceptionDao<Place, Integer> dao = getPlaceDao();
        // create some entries in the onCreate
        Place homeOption = new Place();
        dao.create(homeOption);

//        //Testing to be sure that dao is getting its information correctly...
//        if (dao == null) throw new AssertionError("dao is still equal to NULL");

        homeOption = new Place();
        dao.create(homeOption);

//        //Testing to be sure that dao is getting its information correctly...
//        if (dao == null) throw new AssertionError("dao is still equal to NULL");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            Log.i(databaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Place.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(databaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }


    public Dao<Place, Integer> getDao() throws SQLException {

        return placeDao;
    }


    public RuntimeExceptionDao<Place, Integer> getPlaceDao() {
        if (runtimeDao == null) {
            runtimeDao = getRuntimeExceptionDao(Place.class);
        }

        return runtimeDao;
    }


    @Override
    public void close() {
        super.close();
        placeDao = null;
        runtimeDao = null;
    }
}
