package model.database.utilities;


import model.database.loadSaveStrategies.LoadSaveStrategy;

import java.io.*;
import java.util.*;

public abstract class TextLoadSaveTemplate<K,V> {



    public final void save(TreeMap<K,V> map, File file) {
        String out = "";

        for (Map.Entry<K, V> kvEntry : map.entrySet()) {
            Map.Entry pair = kvEntry;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(out);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final TreeMap<K,V> load(File file) throws IOException {
        TreeMap<K,V> returnMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(";");
                V element = makeObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    protected abstract V makeObject(String[] tokens);

    protected abstract K getKey(String[] tokens);

}
