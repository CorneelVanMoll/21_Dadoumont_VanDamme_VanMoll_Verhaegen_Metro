package controller;

import model.Gate;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.Observer;
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
            case INVALID_GATE_ACTION:
                //add alert
                this.alerts.add("someone tried to scan or walkthrough an inactive gate");
                break;
            case EXPIRED_CARD:
                this.alerts.add("That card has expired");
                break;
            case UPDATE_METROCARD:
                this.controlCenterPane.update(this.metroFacade.getTotalCards(), this.metroFacade.getTotalPrice());
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
