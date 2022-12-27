package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.TextLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.time.Year;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class MetrocardsTextLoadSaveStrategy<K, V> extends TextLoadSaveTemplate<Integer, Metrocard> implements LoadSaveStrategy {
    @Override
    protected Metrocard makeObject(String[] tokens) {
        String[] dateTokens = tokens[1].split("#");
        Metrocard metrocard = new Metrocard(parseInt(tokens[0]), Month.of(parseInt(dateTokens[0])), Year.parse(dateTokens[1]), parseInt(tokens[2]), parseInt(tokens[3]));
        return metrocard;
    }

    protected Integer getKey(String[] tokens) {
        return parseInt(tokens[0]);
    }

    @Override
    public Map<Integer, Metrocard> load() {
        try {
            return super.load(new File("test"));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void save(Map data) {
        super.save(data, new File("test"));
    }
}
