package controller;

import model.MetroFacade;
import model.Observer;
import view.ControlCenterPane;
import view.MetroCardOverviewPane;
import view.MetroTicketView;

public class MetroTicketViewController implements Observer {


    MetroFacade metroFacade;
    MetroTicketView MetroTicketView;


    public MetroTicketViewController(MetroFacade metroFacade, MetroTicketView MetroTicketView) {
        this.metroFacade = metroFacade;
        this.MetroTicketView = MetroTicketView;
    }



}
