package model.database.utilities;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TekstLoadSaveTemplate {


    private static final String fileName = "metrocards.txt";
    private static final String savetest = "savetest.txt";

    private static HashMap<Integer,String[]> data = new HashMap<>();


    public static void save() {

        String out = "";

        for (Map.Entry<Integer, String[]> set : data.entrySet()) {
            out += set.getKey();
            for(String val: set.getValue()) {
                out += ";"+val;
            }
            out += '\n';
        }
        try {
            FileWriter myWriter = new FileWriter(savetest);
            myWriter.write(out);
            myWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void load() {
        data = new HashMap<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] line = myReader.nextLine().split(";");
                data.put(Integer.valueOf(line[0]), Arrays.copyOfRange(line,1,line.length));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
