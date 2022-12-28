package model.database.loadSaveStrategies;

import java.lang.reflect.Constructor;

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
}
