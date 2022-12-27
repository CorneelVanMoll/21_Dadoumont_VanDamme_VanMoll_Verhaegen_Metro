package model.database.loadSaveStrategies;

import model.Metrocard;

import java.util.TreeMap;

public interface LoadSaveStrategy {
    TreeMap<Integer, Metrocard> load();
    void save(TreeMap<Integer, Metrocard> data);
}
