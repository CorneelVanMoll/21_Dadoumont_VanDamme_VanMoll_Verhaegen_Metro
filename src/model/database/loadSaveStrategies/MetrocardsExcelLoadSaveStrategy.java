package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.ExcelLoadSaveTemplate;

public class MetrocardsExcelLoadSaveStrategy extends ExcelLoadSaveTemplate<Integer, Metrocard> {
    @Override
    protected Metrocard maakObject(String[] tokens) {
        return null;
    }

    @Override
    protected Integer getKey(String[] tokens) {
        return null;
    }
}
