package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Elgalad on 10/28/16.
 */
@DatabaseTable(tableName = "Place")
public class Place {

    @DatabaseField(id = true, columnName = "ID")
    int id;
    @DatabaseField(canBeNull = false)
    String place;


    Place() {
        // needed by ormlite
    }

}
