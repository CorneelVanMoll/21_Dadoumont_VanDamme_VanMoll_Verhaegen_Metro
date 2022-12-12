package model.database.loadSaveStrategies;

public class LoadSaveStrategyFactory<K, V> {
    public LoadSaveStrategy<K, V> createLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategy) {
        switch (loadSaveStrategy) {
            case TEXT:
                return new MetrocardsTextLoadSaveStrategy<K,V>();
            case EXCEL:
                break;
        }
        return null;
    }
}
