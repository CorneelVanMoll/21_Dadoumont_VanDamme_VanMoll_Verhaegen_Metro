package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.TextLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.time.Year;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MetrocardsTextLoadSaveStrategy extends TextLoadSaveTemplate<Integer, Metrocard> {
    public MetrocardsTextLoadSaveStrategy(String path) {
        super(path);
    }

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
    protected String formatObject(Map.Entry<Integer, Metrocard> entry) {
        Metrocard m = entry.getValue();
        return String.format("%d;%d#%d;%d;%d", entry.getKey(), m.getMonth().getValue(), m.getYear().getValue(), m.getAvailableTrips(), m.getUsedTrips());
    }
}
