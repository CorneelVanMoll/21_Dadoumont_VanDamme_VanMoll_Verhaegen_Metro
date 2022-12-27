package model.database.loadSaveStrategies;

import java.lang.reflect.Constructor;

public class LoadSaveStrategyFactory<K, V> {
    public LoadSaveStrategy<K, V> createLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategy) {


        String type = "";
        switch (loadSaveStrategy) {
            case TEXT:
                type = "TEXT";
                break;
            case EXCEL:
                type = "EXCEL";
                break;
        }


        LoadSaveType strat = LoadSaveType.valueOf(type);

        String klasseNaam = strat.getKlasseNaam();


        LoadSaveStrategy out = null;

        try {
            Class<?> clazz = Class.forName(klasseNaam);
            Constructor<?> constructor = clazz.getConstructor();
            out = (LoadSaveStrategy)constructor.newInstance();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return out;
    }
}
