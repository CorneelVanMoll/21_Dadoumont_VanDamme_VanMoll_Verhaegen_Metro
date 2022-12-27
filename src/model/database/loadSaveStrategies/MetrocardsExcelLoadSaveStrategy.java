package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.ExcelLoadSaveTemplate;

import java.time.Month;
import java.time.Year;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MetrocardsExcelLoadSaveStrategy extends ExcelLoadSaveTemplate<Integer, Metrocard> implements LoadSaveStrategy<Integer, Metrocard> {
    @Override
    protected Integer getKey(List<String> tokens) {
        return parseInt(tokens.get(0));
    }

    @Override
    protected Metrocard makeObject(List<String> tokens) {
        String[] dateTokens = tokens.get(1).split("#");
        return new Metrocard(parseInt(tokens.get(0)), Month.of(parseInt(dateTokens[0])), Year.parse(dateTokens[1]), parseInt(tokens.get(2)), parseInt(tokens.get(3)));
    }

    @Override
    public Map<Integer, Metrocard> load() {
        List<List<String>> data = super.load("metrocards.xls");
        TreeMap<Integer, Metrocard> result = new TreeMap<>();
        for (List<String> tokens : data) {
            result.put(getKey(tokens), makeObject(tokens));
        }
        return result;
    }

    @Override
    public void save(Map<Integer, Metrocard> data) {
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, Metrocard> entry : data.entrySet()) {
            List<String> row = new ArrayList<>();
            Metrocard m = entry.getValue();

            row.add(String.valueOf(m.getId()));
            row.add(String.format("%d#%d", m.getMonth().getValue(), m.getYear().getValue()));
            row.add(String.valueOf(m.getAvailableTrips()));
            row.add(String.valueOf(m.getUsedTrips()));

            result.add(row);
        }
        super.save(result,"metrocards.xls");
    }
}
