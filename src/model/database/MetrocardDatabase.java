package model.database;

import model.Metrocard;
import model.database.loadSaveStrategies.LoadSaveStrategy;

import java.util.ArrayList;
import java.util.TreeMap;

public class MetrocardDatabase {
    private TreeMap<Integer, Metrocard> metrocards;

    private LoadSaveStrategy loadSaveStrategy;

    public MetrocardDatabase(LoadSaveStrategy loadSaveStrategy) {
        this.loadSaveStrategy = loadSaveStrategy;
    }

    public void load() {
        metrocards = new TreeMap<>(loadSaveStrategy.load());
    }

    public void save() {
        loadSaveStrategy.save(metrocards);
    }

    public ArrayList<Metrocard> getMetrocardList() {
        return new ArrayList<>(metrocards.values());
    }

    public ArrayList<Integer> getMetrocardIDList() {
        return new ArrayList<>(metrocards.keySet());
    }

    public void setLoadSaveStrategy(LoadSaveStrategy loadSaveStrategy) {
        this.loadSaveStrategy = loadSaveStrategy;
    }
}
