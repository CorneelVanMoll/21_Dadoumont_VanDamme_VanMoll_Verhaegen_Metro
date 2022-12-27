package model;

import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.ArrayList;

public class MetroFacade implements Subject {


    ArrayList<Observer> observers;

    private final MetrocardDatabase metroDB;
    private final LoadSaveStrategyFactory loadSaveStrategyFactory;

    public MetroFacade() {
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        this.metroDB = new MetrocardDatabase(this.loadSaveStrategyFactory.createLoadSaveStrategy(LoadSaveStrategyEnum.TEXT));
        this.metroDB.load();
        this.observers = new ArrayList<>();
    }



    public ArrayList<Metrocard> getMetroCardList() {
        return this.metroDB.getMetrocardList();
    }


    public ArrayList<Integer> getMetroCardIDList() {
        return this.metroDB.getMetrocardIDList();
    }


    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }


    public void openMetroStation() {
        System.out.println(getMetroCardList());
    }

}
