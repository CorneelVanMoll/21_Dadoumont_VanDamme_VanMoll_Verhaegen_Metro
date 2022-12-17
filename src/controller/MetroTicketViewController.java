package controller;

import model.MetroFacade;
import model.Observer;
import view.MetroTicketView;

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
}
