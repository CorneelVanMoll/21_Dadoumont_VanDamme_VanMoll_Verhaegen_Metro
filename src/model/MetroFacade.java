package model;

import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;


import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import java.util.*;

public class MetroFacade implements Subject {
    Map<MetroEventsEnum, List<Observer>> observerMap;

    private MetrocardDatabase metroDB;
    private final LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;

    public MetroFacade() {
        this.observerMap = new HashMap<>();
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory<>();
    }

    public ArrayList<Metrocard> getMetroCardList() {
        return this.metroDB.getMetrocardList();
    }


    public ArrayList<Integer> getMetroCardIDList() {
        return this.metroDB.getMetrocardIDList();
    }

    public void addObserver(Observer observer, MetroEventsEnum metroEvent) {
        if (observerMap.containsKey(metroEvent)) {
            observerMap.get(metroEvent).add(observer);
        } else {
            observerMap.put(metroEvent, new ArrayList<>(Collections.singleton(observer)));
        }
    }

    public void openMetroStation(LoadSaveStrategyEnum loadSaveStrategy) {
        System.out.println("Open metro station");
        this.metroDB = new MetrocardDatabase(this.loadSaveStrategyFactory.createLoadSaveStrategy(loadSaveStrategy));
        this.metroDB.load();
        fireEvent(MetroEventsEnum.OPEN_METROSTATION);
    }

    public void newMetroCard(Month month, Year year) {
        if (this.metroDB != null) {
            this.metroDB.addMetrocard(month, year);
            this.metroDB.save();
            fireEvent(MetroEventsEnum.BUY_METROCARD);
        }
    }

    private void fireEvent(MetroEventsEnum loadSaveStrategy) {
        if (observerMap.containsKey(loadSaveStrategy)) {
            for (Observer observer : observerMap.get(loadSaveStrategy)) {
                observer.update();
            }
        }
    }
}
