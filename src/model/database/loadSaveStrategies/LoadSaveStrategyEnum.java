package model.database.loadSaveStrategies;

public enum LoadSaveStrategyEnum {
    TEXT("model.database.loadSaveStrategies.MetrocardsTextLoadSaveStrategy"),
    EXCEL("model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy");

    private String className;

    LoadSaveStrategyEnum(String className){
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
