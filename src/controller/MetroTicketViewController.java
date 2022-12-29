package controller;

import model.MetroEventsEnum;
import model.MetroFacade;
import model.Metrocard;
import model.Observer;
import view.MetroTicketView;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.NoSuchElementException;

public class MetroTicketViewController implements Observer {
    MetroFacade metroFacade;
    MetroTicketView metroTicketView;

    private final DecimalFormat euros = new DecimalFormat("€0.00");

    public MetroTicketViewController(MetroFacade metroFacade, MetroTicketView metroTicketView) {
        this.metroFacade = metroFacade;
        this.metroTicketView = metroTicketView;
    }

    @Override
    public void update(MetroEventsEnum event) {
        metroTicketView.updateMetroCardIdList(metroFacade.getMetroCardIDList());
    }

    public void newMetroCard() {
        metroFacade.newMetroCard(LocalDateTime.now().getMonth(), Year.of(LocalDateTime.now().getYear()));
    }

    public void updateTotalPrice(boolean is24Min, boolean is64Plus, boolean isStudent, int metroCardId, int amount) {
        Metrocard metrocard;
        try {
            metrocard = metroFacade.getMetroCardList().stream().filter(metrocard1 -> metrocard1.getId() == metroCardId).findFirst().get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return;
        }
        double totalPrice = metroFacade.getPrice(is24Min, is64Plus, isStudent, metrocard) * amount;
        metroTicketView.setTotalPrice(euros.format(totalPrice));
    }

    public void addRides(Integer metroCardId, int amount) {

        metroFacade.addRides(metroCardId, amount);
    }
}
