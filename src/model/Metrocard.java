package model;

import java.time.Month;
import java.time.Year;

public class Metrocard {
    private final int id;
    private Month month;
    private Year year;
    private int availableTrips;
    private int usedTrips;

    public Metrocard(int id, Month month, Year year, int availableTrips, int usedTrips) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.availableTrips = availableTrips;
        this.usedTrips = usedTrips;
    }

    public int getId() {
        return id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getAvailableTrips() {
        return availableTrips;
    }

    public void setAvailableTrips(int availableTrips) {
        this.availableTrips = availableTrips;
    }

    public int getUsedTrips() {
        return usedTrips;
    }

    public void setUsedTrips(int usedTrips) {
        this.usedTrips = usedTrips;
    }
}
