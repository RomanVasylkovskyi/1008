package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class BuildArray {

    private ArrayList<RentPlace> rentPlaces;


    public BuildArray() {
        rentPlaces = new ArrayList<>();
    }

    public ArrayList<RentPlace> getlist() {
        return rentPlaces;
    }

    public void add(RentPlace rentPlace) {
        rentPlaces.add(rentPlace);
    }

    /*Видалення за типом будівлі*/
    public void remove(int NumberOfBuild) {
        if (NumberOfBuild < rentPlaces.size() && NumberOfBuild >= 0) {
           rentPlaces.remove(NumberOfBuild);
        }
    }
    public void deleteByType(String TypeB) {
        for (int i = 0; i < rentPlaces.size(); i++) {
            if (rentPlaces.get(i).getTypeB().equals(TypeB)) {
                rentPlaces.remove(i);
            }
        }
    }


}
