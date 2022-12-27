package controller;

import model.MetroFacade;
import model.Observer;
import view.MetroCardOverviewPane;
import view.MetroStationView;
import view.MetroTicketView;

public class MetroCardOverviewPaneController implements Observer {
    MetroFacade metroFacade;
    MetroCardOverviewPane metroCardOverviewPane;

    public MetroCardOverviewPaneController(MetroFacade metroFacade, MetroCardOverviewPane metroCardOverviewPane) {
        this.metroFacade = metroFacade;
        this.metroCardOverviewPane = metroCardOverviewPane;
        update();
    }

    @Override
    public void update() {
        metroCardOverviewPane.updateMetrocardList(metroFacade.getMetroCardList());
    }
}
