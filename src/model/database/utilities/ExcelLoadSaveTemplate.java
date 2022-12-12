package model.database.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jxl.read.biff.BiffException;
import jxl.write.*;

public abstract class ExcelLoadSaveTemplate <K,V>{


    public static void save(ArrayList<String> x) {
        /*
        ExcelPlugin excelPlugin = new ExcelPlugin();

        ArrayList<ArrayList<String>> out = new ArrayList<>();

        for(String line: x) {
            ArrayList<String> temp = new ArrayList<String>(Arrays.asList(line.split(";")));
            out.add(temp);
        }




        try {
            excelPlugin.write(new File(ExcelFile), out);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

         */

    }


    public final Map<K,V> load(File file) throws IOException {

        Map<K,V> returnMap = new HashMap<K,V>();

        ExcelPlugin excelPlugin = new ExcelPlugin();
        try {
            ArrayList<ArrayList<String>> out = excelPlugin.read(file);

            for(ArrayList<String> i : out) {

                String[] tokens = i.toArray(new String[i.size()]);
                V element = maakObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);

            }


        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return returnMap;

    }


    protected abstract V maakObject(String[] tokens);

    protected abstract K getKey(String[] tokens);
}
