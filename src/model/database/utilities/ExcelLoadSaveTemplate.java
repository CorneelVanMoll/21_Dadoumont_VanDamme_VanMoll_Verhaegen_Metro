package model.database.utilities;

import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;

public abstract class ExcelLoadSaveTemplate <K,V> {

    public final void save(List<List<String>> data, String path) {
        try {
            WritableWorkbook ww = Workbook.createWorkbook(new File(path));
            WritableSheet sheet = ww.createSheet("metrocards",0);
            for (int r = 0; r < data.size(); r++) {
                for (int c = 0; c < data.get(r).size(); c++) {
                    sheet.addCell(new Label(c, r, data.get(r).get(c)));
                }
            }
            ww.write();
            ww.close();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final List<List<String>> load(String path) {
        List<List<String>> result = new ArrayList<>();

        try {
            Workbook w = Workbook.getWorkbook(new File(path));
            Sheet sheet = w.getSheet(0);

            for (int i = 0; i < sheet.getRows(); i++) {
                Cell[] row = sheet.getRow(i);
                result.add(new ArrayList<>());
                for (Cell cell : row) {
                    result.get(i).add(cell.getContents());
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected abstract V makeObject(List<String> tokens);

    protected abstract K getKey(List<String> tokens);
}
