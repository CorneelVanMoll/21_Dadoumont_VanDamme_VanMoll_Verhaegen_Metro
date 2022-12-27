package model;

import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.util.*;

public class MetroFacade implements Subject {
    Map<MetroEventsEnum, List<Observer>> observerMap;

    private MetrocardDatabase metroDB;
    private LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;

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
        if (observerMap.containsKey(MetroEventsEnum.OPEN_METROSTATION)) {
            for (Observer observer : observerMap.get(MetroEventsEnum.OPEN_METROSTATION)) {
                observer.update();
            }
        }
    }
}
