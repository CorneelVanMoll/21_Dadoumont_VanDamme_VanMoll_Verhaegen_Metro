package controller;

import model.MetroFacade;
import model.Observer;
import view.MetroTicketView;

import java.time.LocalDateTime;
import java.time.Year;

public class MetroTicketViewController implements Observer {
    MetroFacade metroFacade;
    MetroTicketView metroTicketView;

    public MetroTicketViewController(MetroFacade metroFacade, MetroTicketView metroTicketView) {
        this.metroFacade = metroFacade;
        this.metroTicketView = metroTicketView;
    }

    @Override
    public void update() {
        metroTicketView.updateMetroCardIdList(metroFacade.getMetroCardIDList());
    }

    public void newMetroCard() {
        metroFacade.newMetroCard(LocalDateTime.now().getMonth(), Year.of(LocalDateTime.now().getYear()));
    }
}
