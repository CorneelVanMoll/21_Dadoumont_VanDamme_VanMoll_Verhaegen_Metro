package model.database.loadSaveStrategies;

public enum LoadSaveType {
    TEXT ("text", "model.database.loadSaveStrategies.MetrocardsTextLoadSaveStrategy"),
    EXCEL ("excel", "model.database.loadSaveStrategies.MetrocardsExcelLoadSaveStrategy");

    private final String omschrijving;
    private final String klasseNaam;

    LoadSaveType(String omschrijving, String klasseNaam) {
        this.omschrijving = omschrijving;
        this.klasseNaam = klasseNaam;
    }

    public String getOmschrijving() { return omschrijving; }
    public String getKlasseNaam() { return klasseNaam; }
}
