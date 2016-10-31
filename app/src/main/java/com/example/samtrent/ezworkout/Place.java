package com.example.samtrent.ezworkout;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Elgalad on 10/28/16.
 */

public class Place {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(index = true)
    String string;
    @DatabaseField
    String place;


    Place() {
        // needed by ormlite
    }

}
