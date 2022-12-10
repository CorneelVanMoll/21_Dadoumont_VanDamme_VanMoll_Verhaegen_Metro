package model;

import model.database.MetrocardDatabase;

import java.util.ArrayList;

public class MetroFacade implements Subject {


    ArrayList<Observer> observers;

    private ArrayList<Metrocard> metrocards;
    private ArrayList<Integer> metrocardIDs;

    private MetrocardDatabase metroDB;

    public MetroFacade(MetrocardDatabase metrocardDatabase) {
        this.metroDB = metrocardDatabase;
        this.observers = new ArrayList<>();

        //TODO uncomment when MetrocardDatabase is finished
        /*
        metrocards = metroDB.getMetroCardList();
        metrocardIDs = metroDB.getMetroCardIDList();
         */
    }



    public ArrayList<Metrocard> getMetroCardList() {
        return this.metrocards;
    }


    public ArrayList<Integer> getMetroCardIDList() {
        return this.metrocardIDs;
    }


    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

}
