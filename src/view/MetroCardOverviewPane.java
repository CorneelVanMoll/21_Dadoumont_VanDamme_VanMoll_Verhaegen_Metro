package view;

import controller.MetroCardOverviewPaneController;
import javafx.scene.layout.GridPane;
import model.Metrocard;

import java.util.ArrayList;

public class MetroCardOverviewPane extends GridPane {
    private ArrayList<Metrocard> metroCards;
    private MetroCardOverviewPaneController metroCardOverviewPaneController;

    public void updateMetrocardList(ArrayList<Metrocard> metrocards) {
        this.metroCards = metrocards;
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController metroCardOverviewPaneController) {
        this.metroCardOverviewPaneController = metroCardOverviewPaneController;
    }
}
