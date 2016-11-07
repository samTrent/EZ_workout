package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Place")
public class Place {

    public static final String FIELD_NAME_ID     = "id";
    public static final String FIELD_NAME_PLACE   = "place";

    @DatabaseField(id = true, columnName = FIELD_NAME_ID)
    int id;
    @DatabaseField(canBeNull = false, columnName = FIELD_NAME_PLACE)
    String place;


    Place() {
        // needed by ormlite
    }

    Place(int newId, String newName) {
        id = newId;
        place = newName;
    }

    public String getPlace() {
        return place;
    }

    public int getId() {
        return id;
    }

}
