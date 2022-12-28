package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Gate;
import model.MetroEventsEnum;
import model.MetroFacade;
import model.Observer;
import model.states.ClosedState;
import view.MetroCardOverviewPane;
import view.MetroStationView;

import java.util.ArrayList;
import java.util.List;

public class MetroStationViewController implements Observer {
    MetroFacade metroFacade;
    MetroStationView metroStationView;

    private ObservableList<Integer> options;

    private int NumberOfScannedMetroCards;

    public MetroStationViewController(MetroFacade metroFacade, MetroStationView metroStationView) {
        this.metroFacade = metroFacade;
        this.metroStationView = metroStationView;
        this.NumberOfScannedMetroCards = 0;


        options = FXCollections.observableArrayList(metroFacade.getMetroCardIDList());
    }

    @Override
    public void update(MetroEventsEnum event) {
        metroStationView.updateMetroCardIdList(metroFacade.getMetroCardIDList());
    }

    public ArrayList<Gate> getGates() {
        return metroFacade.getGates();
    }

    public ObservableList<Integer> getIDs() {
        return options;
    }


    public void scanMetroCard(Gate gate, String id) {

        if(id != null && !id.isEmpty()) {
            int idInt = Integer.parseInt(id);
            List<Integer> ids= metroFacade.getMetroCardIDList();

            if(ids.contains(idInt)) {

                try{
                    gate.setScannedCards(gate.getScannedCards() + 1);
                    gate.scan();
                    metroFacade.ScanCard();
                }catch (IllegalArgumentException e) {
                    gate.setScannedCards(gate.getScannedCards() - 1);
                    metroFacade.inactiveGateAction();

                }



                metroStationView.getOutputs().get(gate).setText("card " +id + " is scanned");
            }else{
                gate.setClosed();
                metroStationView.getOutputs().get(gate).setText("card " +id + " is not valid");
            }
        }else{
            gate.createAlert();
            metroStationView.getOutputs().get(gate).setText("alert is generated");
        }


    }

    public void walkThroughGate(Gate gate) {

        if(gate.getContext().getState() instanceof ClosedState) {
            metroStationView.getOutputs().get(gate).setText("Gate is closed");
        }else {
            try{
                gate.walkThroughGate();
            }catch (IllegalArgumentException e) {
                metroFacade.inactiveGateAction();
            }

            metroStationView.getOutputs().get(gate).setText("walked through");
        }

    }
}
