package model;

import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.ArrayList;

public class MetroFacade implements Subject {
    ArrayList<Observer> observers;

    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;

    public MetroFacade() {
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory<>();
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

    public void openMetroStation(LoadSaveStrategyEnum loadSaveStrategy) {
        System.out.println("Open metro station");
        this.metroDB = new MetrocardDatabase(this.loadSaveStrategyFactory.createLoadSaveStrategy(loadSaveStrategy));
        this.metroDB.load();
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
