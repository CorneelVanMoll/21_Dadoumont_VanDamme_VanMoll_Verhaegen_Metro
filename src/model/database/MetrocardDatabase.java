package model.database;

import model.Metrocard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.TreeMap;

public class MetrocardDatabase {
    private TreeMap<Integer, Metrocard> metrocards;

    private LoadSaveStrategy<Integer, Metrocard> loadSaveStrategy;

    public MetrocardDatabase(LoadSaveStrategy<Integer, Metrocard> loadSaveStrategy) {
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

    public void setLoadSaveStrategy(LoadSaveStrategy<Integer, Metrocard> loadSaveStrategy) {
        this.loadSaveStrategy = loadSaveStrategy;
    }

    public void addMetrocard(Month month, Year year) {
        int id = getLastID() + 1;
        metrocards.put(id, new Metrocard(id, month, year, 2, 0));
    }

    private int getLastID() {
        if (getMetrocardIDList().size() == 0) return 0;
        return getMetrocardIDList().get(getMetrocardIDList().size() - 1);
    }
}
