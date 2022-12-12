package model.database.utilities;


import model.database.loadSaveStrategies.LoadSaveStrategy;

import java.io.*;
import java.util.*;

public abstract class TextLoadSaveTemplate<K,V> {



    public final void save(Map<K,V> map, File file) {

        String out = "";


        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
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


    public final Map<K,V> load(File file) throws IOException {
        Map<K,V> returnMap = new HashMap<K,V>();
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
