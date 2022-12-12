package model.database.utilities;


import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import javax.management.monitor.StringMonitor;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public abstract class TekstLoadSaveTemplate <K,V>{


    private static final String fileName = "metrocards.txt";
    private static final String savetest = "savetest.txt";





    public final void save(Map<K,V> map, File file) {
        /*
        String out = "";

        for(String line:x) {
            out += line + '\n';
        }




        try {
            FileWriter myWriter = new FileWriter(savetest);
            myWriter.write(out);
            myWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

         */
    }


    public final Map<K,V> load(File file) throws IOException {
        Map<K,V> returnMap = new HashMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(";");
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    protected abstract V maakObject(String[] tokens);

    protected abstract K getKey(String[] tokens);

}
