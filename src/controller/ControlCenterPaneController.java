package controller;

import model.MetroFacade;
import model.Observer;
import view.ControlCenterPane;

public class ControlCenterPaneController implements Observer {
    MetroFacade metroFacade;
    ControlCenterPane controlCenterPane;

    public ControlCenterPaneController(MetroFacade metroFacade, ControlCenterPane controlCenterPane) {
        this.metroFacade = metroFacade;
        this.controlCenterPane = controlCenterPane;
    }

    public void openMetroStation() {
        this.metroFacade.openMetroStation();
    }

    @Override
    public void update() {

    }
}
