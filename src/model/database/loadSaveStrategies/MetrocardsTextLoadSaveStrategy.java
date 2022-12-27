package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.TextLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.time.Year;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MetrocardsTextLoadSaveStrategy extends TextLoadSaveTemplate<Integer, Metrocard> implements LoadSaveStrategy<Integer, Metrocard> {
    @Override
    protected Integer getKey(String[] tokens) {
        return parseInt(tokens[0]);
    }
    @Override
    protected Metrocard makeObject(String[] tokens) {
        String[] dateTokens = tokens[1].split("#");
        return new Metrocard(parseInt(tokens[0]), Month.of(parseInt(dateTokens[0])), Year.parse(dateTokens[1]), parseInt(tokens[2]), parseInt(tokens[3]));
    }

    @Override
    public Map<Integer, Metrocard> load() {
        Map<Integer, Metrocard> result = new TreeMap<>();

        List<String> lines = super.load("metrocards.txt");
        for (String line : lines) {
            String[] tokens = line.split(";");
            Integer key = getKey(tokens);
            Metrocard element = makeObject(tokens);
            result.put(key, element);
        }

        return result;
    }

    @Override
    public void save(Map<Integer, Metrocard> data) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Metrocard> entry: data.entrySet()) {
            Metrocard m = entry.getValue();
            result.add(String.format("%d;%d#%d;%d;%d", entry.getKey(), m.getMonth().getValue(), m.getYear().getValue(), m.getAvailableTrips(), m.getUsedTrips()));
        }
        super.save(result, "metrocards.txt");
    }
}
