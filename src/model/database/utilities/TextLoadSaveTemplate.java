package model.database.utilities;


import java.io.*;
import java.util.*;

public abstract class TextLoadSaveTemplate<K,V> {
    public final void save(List<String> in, String path) {
        String out = "";

        for (String line : in) {
            out += line + "\n";
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(out);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final List<String> load(String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected abstract V makeObject(String[] tokens);

    protected abstract K getKey(String[] tokens);
}
