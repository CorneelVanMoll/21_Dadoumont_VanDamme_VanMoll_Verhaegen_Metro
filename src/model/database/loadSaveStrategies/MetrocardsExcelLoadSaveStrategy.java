package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.ExcelLoadSaveTemplate;
import model.database.utilities.TextLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
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
        try {
            return super.load(new File("metrocards.xls"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Map<Integer, Metrocard> data) {

    }
}
