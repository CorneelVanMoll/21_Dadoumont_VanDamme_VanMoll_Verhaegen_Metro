package model;

import model.TicketPriceDecorator.TicketPrice;
import model.TicketPriceDecorator.TicketPriceDiscountEnum;
import model.TicketPriceDecorator.TicketPriceFactory;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;


import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import java.util.*;
import java.util.stream.Collectors;

public class MetroFacade implements Subject {
    Map<MetroEventsEnum, List<Observer>> observerMap;
    private MetrocardDatabase metroDB;
    private final LoadSaveStrategyFactory<Integer, Metrocard> loadSaveStrategyFactory;
    private LoadSaveStrategyEnum loadSaveStrategy;
    private List<String> metroTicketDiscountList;

    private ArrayList<Gate> gates;

    public MetroFacade() {
        this.observerMap = new HashMap<>();
        this.loadSaveStrategyFactory = new LoadSaveStrategyFactory<>();
        this.gates = new ArrayList<>();
        this.gates.add(new Gate("Gate1"));
        this.gates.add(new Gate("Gate2"));
        this.gates.add(new Gate("Gate3"));
        this.metroTicketDiscountList = TicketPriceFactory.loadDiscounts();
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

    public void openMetroStation() {
        this.metroTicketDiscountList = TicketPriceFactory.loadDiscounts();
        this.loadSaveStrategy = LoadSaveStrategyFactory.loadLoadSaveStrategy();
        this.metroDB = new MetrocardDatabase(this.loadSaveStrategyFactory.createLoadSaveStrategy(this.loadSaveStrategy));
        this.metroDB.load();
        fireEvent(MetroEventsEnum.OPEN_METROSTATION);
    }

    public void closeMetroStation() {
        if (this.metroDB != null) {
            this.metroDB.save();
            this.metroDB = null;
            fireEvent(MetroEventsEnum.CLOSE_METROSTATION);
        }
    }

    public void newMetroCard(Month month, Year year) {
        if (this.metroDB != null) {
            this.metroDB.addMetrocard(month, year);
            fireEvent(MetroEventsEnum.BUY_METROCARD);
        }
    }

    private void fireEvent(MetroEventsEnum event) {
        if (observerMap.containsKey(event)) {
            for (Observer observer : observerMap.get(event)) {
                observer.update(event);
            }
        }
    }

    public double getPrice(boolean is24Min, boolean is64Plus, boolean isStudent, Metrocard metrocard) {
        TicketPrice ticketPrice = TicketPriceFactory.createTicketPrice(is24Min, is64Plus, isStudent, metrocard);
        return ticketPrice.getPrice();
    }


    public List<Gate> getGates() {
        return this.gates;
    }

    public void invalidGateAction() {
        fireEvent(MetroEventsEnum.INVALID_GATE_ACTION);
    }

    public boolean scanCard(int id) {
        if (this.metroDB.scanCard(id)) {
            fireEvent(MetroEventsEnum.SCAN);
            return true;
        }
        return false;
    }

    public boolean checkCardExpired(int id) {
        return this.metroDB.checkCardExpired(id);
    }

    public List<String> getSelectedDiscounts() {
        return metroTicketDiscountList;
    }

    public List<String> getAllDiscounts() {
        List<TicketPriceDiscountEnum> list = Arrays.asList(TicketPriceDiscountEnum.values());
        return list.stream().map(TicketPriceDiscountEnum::toString).collect(Collectors.toList());
    }

    public void saveSettings(List<String> discountSelected, List<String> strategySelected) {
        loadSaveStrategyFactory.saveSettings(discountSelected, strategySelected);
    }

    public String getSelectedLoadStrategy() {
        return loadSaveStrategyFactory.getSelectedLoadSaveStrategy();
    }

    public List<String> getAllLoadStrategies() {
        List<LoadSaveStrategyEnum> list = Arrays.asList(LoadSaveStrategyEnum.values());
        return list.stream().map(LoadSaveStrategyEnum::toString).collect(Collectors.toList());
    }

    public void addRides(Integer metroCardId, int amount) {
        metroDB.addRides(metroCardId, amount);
        fireEvent(MetroEventsEnum.UPDATE_METROCARD);
    }
}
