package model;

import model.TicketPriceDecorator.TicketPrice;
import model.TicketPriceDecorator.TicketPriceFactory;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;


import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import java.util.*;

public class MetroFacade implements Subject {
    Map<MetroEventsEnum, List<Observer>> observerMap;

    private MetrocardDatabase metroDB;
    private final LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;

    private ArrayList<String> metroTicketDiscountList;

    private ArrayList<Gate> gates;

    public MetroFacade() {
        this.observerMap = new HashMap<>();
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory<>();
        this.gates = new ArrayList<>();
        this.gates.add(new Gate("Gate1"));
        this.gates.add(new Gate("Gate2"));
        this.gates.add(new Gate("Gate3"));

    }

    public List<Metrocard> getMetroCardList() {
        if (this.metroDB != null) {
            return this.metroDB.getMetrocardList();
        }
        return new ArrayList<>();
    }


    public List<Integer> getMetroCardIDList() {
        if (this.metroDB != null) {
            return this.metroDB.getMetrocardIDList();
        }
        return new ArrayList<>();
    }

    public void addObserver(Observer observer, MetroEventsEnum metroEvent) {
        if (observerMap.containsKey(metroEvent)) {
            observerMap.get(metroEvent).add(observer);
        } else {
            observerMap.put(metroEvent, new ArrayList<>(Collections.singleton(observer)));
        }
    }

    public void openMetroStation(LoadSaveStrategyEnum loadSaveStrategy) {
        this.metroDB = new MetrocardDatabase(this.loadSaveStrategyFactory.createLoadSaveStrategy(loadSaveStrategy));
        this.metroTicketDiscountList = TicketPriceFactory.loadDiscounts();
        this.metroDB.load();
        fireEvent(MetroEventsEnum.OPEN_METROSTATION);
    }

    public void closeMetroStation() {
        this.metroDB.save();
        this.metroDB = null;
        fireEvent(MetroEventsEnum.CLOSE_METROSTATION);
    }

    public void newMetroCard(Month month, Year year) {
        if (this.metroDB != null) {
            this.metroDB.addMetrocard(month, year);
            fireEvent(MetroEventsEnum.BUY_METROCARD);
        }
    }

    private void fireEvent(MetroEventsEnum loadSaveStrategy) {
        if (observerMap.containsKey(loadSaveStrategy)) {
            for (Observer observer : observerMap.get(loadSaveStrategy)) {
                observer.update(loadSaveStrategy);
            }
        }
    }

    public double getPrice(boolean is24Min, boolean is64Plus, boolean isStudent, Metrocard metrocard) {
        TicketPrice ticketPrice = TicketPriceFactory.createTicketPrice(is24Min, is64Plus, isStudent, metrocard);
        return ticketPrice.getPrice();
    }

    public ArrayList<Gate> getGates() {
        return this.gates;
    }

    public void inactiveGateAction() {
        fireEvent(MetroEventsEnum.GATE_INACTIVE_SCAN_OR_WALKTHROUGH);
    }

    public void ScanCard() {
        fireEvent(MetroEventsEnum.SCAN);
    }
}
