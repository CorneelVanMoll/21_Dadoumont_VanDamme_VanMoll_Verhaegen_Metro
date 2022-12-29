package controller;

import model.Gate;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.Observer;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import sun.font.CreatedFontTracker;
import view.ControlCenterPane;

import java.util.ArrayList;
import java.util.List;

public class ControlCenterPaneController implements Observer {
    MetroFacade metroFacade;
    ControlCenterPane controlCenterPane;

    private ArrayList<String> alerts;

    public ControlCenterPaneController(MetroFacade metroFacade, ControlCenterPane controlCenterPane) {
        this.metroFacade = metroFacade;
        this.controlCenterPane = controlCenterPane;
        this.alerts = new ArrayList<>();

    }

    public void openMetroStation() {
        this.metroFacade.openMetroStation();
    }

    public void closeMetroStation() {
        this.metroFacade.closeMetroStation();
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event){
            case GATE_INACTIVE_SCAN_OR_WALKTHROUGH:
                //add alert
                this.alerts.add("someone tried to scan or walkthrough an inactive gate");
                break;
        }

        this.controlCenterPane.refresh();
    }

    public List<Gate> getGates() {
        return metroFacade.getGates();
    }

    public List<String> getAlerts() {
        return this.alerts;
    }
}
