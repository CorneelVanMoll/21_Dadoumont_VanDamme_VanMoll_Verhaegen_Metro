package controller;

import model.MetroFacade;
import model.Observer;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import view.ControlCenterPane;

public class ControlCenterPaneController implements Observer {
    MetroFacade metroFacade;
    ControlCenterPane controlCenterPane;

    public ControlCenterPaneController(MetroFacade metroFacade, ControlCenterPane controlCenterPane) {
        this.metroFacade = metroFacade;
        this.controlCenterPane = controlCenterPane;
    }

    public void openMetroStation(LoadSaveStrategyEnum loadSaveStrategy) {
        this.metroFacade.openMetroStation(loadSaveStrategy);
    }

    public void closeMetroStation() {
        this.metroFacade.closeMetroStation();
    }

    @Override
    public void update() {

    }
}
