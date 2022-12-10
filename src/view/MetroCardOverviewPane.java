package view;

import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;
import model.Metrocard;

import java.util.ArrayList;

public class MetroCardOverviewPane {

    private ArrayList<Metrocard> metroCards;
    private MetroCardOverviewPaneController metroCardOverviewPaneController;

    public void updateMetrocardList(ArrayList<Metrocard> metrocards) {
        this.metroCards = metrocards;
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController metroCardOverviewPaneController) {
        this.metroCardOverviewPaneController = metroCardOverviewPaneController;
    }


}
