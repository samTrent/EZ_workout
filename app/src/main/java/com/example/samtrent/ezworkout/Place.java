package com.example.samtrent.ezworkout;


public class Place {

    private int id;
    private String place;

    // constructors
    public Place() {
    }

    public Place(String newPlace) {
        setPlace(newPlace);
    }

    public Place(int newId, String newPlace) {
        setId(newId);
        setPlace(newPlace);
    }

    public String getPlace() {

        return place;
    }

    public void setPlace(String p) {
        place = p;
    }

    public int getId() {

        return id;
    }

    public void setId(int i) {
        id = i;
    }

}
