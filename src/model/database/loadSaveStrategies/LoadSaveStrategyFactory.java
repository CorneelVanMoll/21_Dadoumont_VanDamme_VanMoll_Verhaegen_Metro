package model.database.loadSaveStrategies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class LoadSaveStrategyFactory<K, V> {
    public LoadSaveStrategy<K, V> createLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategy) {

        LoadSaveStrategy<K, V> out = null;
        try {
            Class<?> loadSaveStrategyClass = Class.forName(loadSaveStrategy.getClassName());
            Constructor<?> loadSaveStrategyConstructor = loadSaveStrategyClass.getConstructor(String.class);
            out = (LoadSaveStrategy<K, V>)loadSaveStrategyConstructor.newInstance(loadSaveStrategy.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public String getSelectedLoadSaveStrategy() {
        BufferedReader reader;
        String strategyString = null;

        try {
            reader = new BufferedReader(new FileReader("settings.txt"));
            strategyString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strategyString;
    }

    public static LoadSaveStrategyEnum loadLoadSaveStrategy() {
        LoadSaveStrategyEnum loadSaveStrategy = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("settings.txt"));
            loadSaveStrategy = LoadSaveStrategyEnum.valueOf(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadSaveStrategy;
    }
}
