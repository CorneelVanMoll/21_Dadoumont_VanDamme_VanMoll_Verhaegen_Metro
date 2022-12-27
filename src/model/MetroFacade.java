package model;

import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

public class MetroFacade implements Subject {
    ArrayList<Observer> observers;

    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;

    public MetroFacade() {
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory<>();
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
        System.out.println("Open metro station");
        for (Observer observer : observers) {
            observer.update();
        }
        this.loadSaveStrategyFactory.createLoadSaveStrategy(LoadSaveStrategyEnum.TEXT);
    }

    public void buyMetroCard(Month month, Year year){ this.metroDB.addMetrocard(month, year);
    }
}
