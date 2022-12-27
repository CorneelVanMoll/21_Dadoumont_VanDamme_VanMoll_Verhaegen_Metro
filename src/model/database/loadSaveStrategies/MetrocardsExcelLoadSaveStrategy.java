package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.ExcelLoadSaveTemplate;
import model.database.utilities.TextLoadSaveTemplate;

import java.util.Map;

public class MetrocardsExcelLoadSaveStrategy extends ExcelLoadSaveTemplate<Integer, Metrocard> implements LoadSaveStrategy<Integer, Metrocard> {
    @Override
    protected Metrocard maakObject(String[] tokens) {
        return null;
    }

    @Override
    protected Integer getKey(String[] tokens) {
        return null;
    }

    @Override
    public Map<Integer, Metrocard> load() {
        return null;
    }

    @Override
    public void save(Map<Integer, Metrocard> data) {

    }
}
