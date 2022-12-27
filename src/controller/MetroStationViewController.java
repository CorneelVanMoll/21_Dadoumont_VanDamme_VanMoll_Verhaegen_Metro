package controller;

import model.MetroFacade;
import model.Observer;
import view.MetroCardOverviewPane;
import view.MetroStationView;

public class MetroStationViewController implements Observer {
    MetroFacade metroFacade;
    MetroStationView metroStationView;

    public MetroStationViewController(MetroFacade metroFacade, MetroStationView metroStationView) {
        this.metroFacade = metroFacade;
        this.metroStationView = metroStationView;
    }

    @Override
    public void update() {
        metroStationView.updateMetroCardIdList(metroFacade.getMetroCardIDList());
    }
}
