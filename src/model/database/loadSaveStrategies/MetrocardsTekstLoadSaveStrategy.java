package model.database.loadSaveStrategies;

import model.Metrocard;
import model.database.utilities.TekstLoadSaveTemplate;

import java.time.Month;
import java.time.Year;

import static java.lang.Integer.parseInt;

public class MetrocardsTekstLoadSaveStrategy extends TekstLoadSaveTemplate {
    @Override
    protected Metrocard makeObject(String[] tokens) {
        Metrocard metrocard = new Metrocard(parseInt(tokens[0]), Month.of(parseInt(tokens[1])), Year.parse(tokens[2]), parseInt(tokens[3]), parseInt(tokens[4]));
        return metrocard;
    }

    protected int getKey(String[] tokens) {
        return parseInt(tokens[0]);
    }
}
