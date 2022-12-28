package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Gate;
import model.MetroFacade;
import model.Observer;
import model.states.ClosedState;
import view.MetroStationView;

import java.util.List;

public class MetroStationViewController implements Observer {
    MetroFacade metroFacade;
    MetroStationView metroStationView;

    private ObservableList<Integer> options;

    private int numberOfScannedMetroCards;

    public MetroStationViewController(MetroFacade metroFacade, MetroStationView metroStationView) {
        this.metroFacade = metroFacade;
        this.metroStationView = metroStationView;
        this.numberOfScannedMetroCards = 0;

        options = FXCollections.observableArrayList(metroFacade.getMetroCardIDList());
    }

    @Override
    public void update() {
        metroStationView.updateMetroCardIdList(metroFacade.getMetroCardIDList());
    }

    public List<Gate> getGates() {
        return metroFacade.getGates();
    }

    public ObservableList<Integer> getIDs() {
        return options;
    }

    public void scanMetroCard(Gate gate, String id) {
        if (id != null && !id.isEmpty()) {
            int idInt = Integer.parseInt(id);
            List<Integer> ids= metroFacade.getMetroCardIDList();

            if (ids.contains(idInt)) {
                gate.scan();
                metroStationView.getOutputs().get(gate).setText("card " + id + " is scanned");
            } else {
                gate.setClosed();
                metroStationView.getOutputs().get(gate).setText("card " + id + " is not valid");
            }
        } else {
            gate.createAlert();
            metroStationView.getOutputs().get(gate).setText("alert is generated");
        }
    }

    public void walkThroughGate(Gate gate) {
        if (gate.getContext().getState() instanceof ClosedState) {
            metroStationView.getOutputs().get(gate).setText("Gate is closed");
        } else {
            gate.walkThroughGate();
            metroStationView.getOutputs().get(gate).setText("walked through");
        }
    }
}
