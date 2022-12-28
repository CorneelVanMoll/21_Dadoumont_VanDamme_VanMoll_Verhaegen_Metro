package model.database.utilities;

import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;

public abstract class ExcelLoadSaveTemplate<K,V> {
    private final String path;

    public ExcelLoadSaveTemplate(String path) {
        this.path = path;
    }

    protected abstract V makeObject(List<String> tokens);

    protected abstract K getKey(List<String> tokens);

    protected abstract List<String> formatObject(Map.Entry<K, V> entry);

    public final Map<K, V> load() {
        List<List<String>> data = new ArrayList<>();
        try {
            Workbook w = Workbook.getWorkbook(new File(path));
            Sheet sheet = w.getSheet(0);

            for (int i = 0; i < sheet.getRows(); i++) {
                Cell[] row = sheet.getRow(i);
                data.add(new ArrayList<>());
                for (Cell cell : row) {
                    data.get(i).add(cell.getContents());
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<K, V> result = new HashMap<>();
        for (List<String> tokens : data) {
            result.put(getKey(tokens), makeObject(tokens));
        }
        return result;
    }

    public final void save(Map<K, V> data) {
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<K, V> entry : data.entrySet()) {
            result.add(formatObject(entry));
        }

        try {
            WritableWorkbook ww = Workbook.createWorkbook(new File(path));
            WritableSheet sheet = ww.createSheet("data",0);
            for (int r = 0; r < result.size(); r++) {
                for (int c = 0; c < result.get(r).size(); c++) {
                    sheet.addCell(new Label(c, r, result.get(r).get(c)));
                }
            }
            ww.write();
            ww.close();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
