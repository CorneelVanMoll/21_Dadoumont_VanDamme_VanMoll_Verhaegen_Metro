package model;

import java.util.Map;
import java.util.TreeMap;

public class Metrocard {
    private int id = 0;
    Map<Integer, Metrocard> Metrocards;

    public Metrocard() {
        Metrocards = new TreeMap<>();
    }

    public void addMetrocard(Metrocard metrocard) {
        if (metrocard == null) throw new IllegalArgumentException();
        Metrocards.put(generateId(), metrocard);
    }

    public Map<Integer, Metrocard> getMetrocards(){
        return Metrocards;
    }

    private int generateId(){
        return ++id;
    }
}
