package com.example.samtrent.ezworkout;

public class Workout_List {

    private int id;
    private int fk_place;
    private String MuscleGroup;

    // This setter takes in a Place object to get its ID and set it to the foreign key
    public Workout_List(int newId, String newMGroup, Place newPlace) {
        setId(newId);
        setMuscleGroup(newMGroup);
        setFk_place(newPlace);
    }

    // This setter takes in an int as a direct foreign key for place
    public Workout_List(int newId, String newMGroup, int newPlace) {
        setId(newId);
        setMuscleGroup(newMGroup);
        setFk_place(newPlace);
    }

    public String getMuscleGroup() {

        return MuscleGroup;
    }

    public void setMuscleGroup(String m) {
        MuscleGroup = m;
    }

    public int getFk_place() {

        return fk_place;
    }

    public void setFk_place(int fk) {
        fk_place = fk;
    }

    // Setter for Fk_place that takes in a place and gets its ID
    public void setFk_place(Place place) {
        fk_place = place.getId();
    }

    public int getId() {

        return id;
    }

    public void setId(int i) {
        id = i;
    }

}

