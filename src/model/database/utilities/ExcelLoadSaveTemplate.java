package model.database.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jxl.read.biff.BiffException;
import jxl.write.*;

public class ExcelLoadSaveTemplate {

    private static final String ExcelFile = "out.xls";


    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("aaaaa;xxx");
        a.add("bbb");
        save(a);
    }

    public static void save(ArrayList<String> x) {
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


    }


    public static void load() {
        /*
        ExcelPlugin excelPlugin = new ExcelPlugin();

        try {
            ArrayList<ArrayList<String>> out = excelPlugin.read(new File(ExcelFile));
            data = new HashMap<>();
            for(ArrayList<String> i : out) {
                int count = 0;
                int id=-1;
                String[] values = new String[3];

                for(String word: i) {
                    if(count == 0) {
                        id = Integer.valueOf(word);
                    }else{
                        values[count-1]=word;
                    }

                    count++;
                }

                data.put(id,values);
            }


        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
    }
}
