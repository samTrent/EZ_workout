package com.example.samtrent.ezworkout;


public class My_Workouts {

    private int id;
    private int fk_workout;

    // constructors
    public My_Workouts() {
    }

    public My_Workouts(int nw_fk_Workout) {
        setFk_workout(nw_fk_Workout);
    }

    // uses Workout object to set foreign key
    public My_Workouts(int newId, Workout nw_fk_Workout) {
        setId(newId);
        setFk_workout(nw_fk_Workout);
    }

    // manually put in foreign key
    public My_Workouts(int newId, int nw_fk_Workout) {
        setId(newId);
        setFk_workout(nw_fk_Workout);
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public int getFk_workout() {

        return fk_workout;
    }

    public void setFk_workout(int fk) {
        fk_workout = fk;
    }

    public void setFk_workout(Workout w) {
        fk_workout = w.getId();
    }


}
