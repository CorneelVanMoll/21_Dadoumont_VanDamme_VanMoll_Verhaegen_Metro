package model;

import java.time.Month;
import java.time.Year;

public class Metrocard {
    private final int id;
    private Month maand;
    private Year jaar;
    private int beschikbareRitten;
    private int verbruikteRitten;

    public int getId() {
        return id;
    }

    public Month getMaand() {
        return maand;
    }

    public void setMaand(Month maand) {
        this.maand = maand;
    }

    public Year getJaar() {
        return jaar;
    }

    public void setJaar(Year jaar) {
        this.jaar = jaar;
    }

    public int getBeschikbareRitten() {
        return beschikbareRitten;
    }

    public void setBeschikbareRitten(int beschikbareRitten) {
        this.beschikbareRitten = beschikbareRitten;
    }

    public int getVerbruikteRitten() {
        return verbruikteRitten;
    }

    public void setVerbruikteRitten(int verbruikteRitten) {
        this.verbruikteRitten = verbruikteRitten;
    }

    public Metrocard(int id, Month maand, Year jaar, int beschikbareRitten, int verbruikteRitten) {
        this.id = id;
        this.maand = maand;
        this.jaar = jaar;
        this.beschikbareRitten = beschikbareRitten;
        this.verbruikteRitten = verbruikteRitten;
    }
}
