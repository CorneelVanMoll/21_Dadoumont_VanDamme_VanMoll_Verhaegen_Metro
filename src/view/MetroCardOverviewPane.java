package view;

import controller.MetroCardOverviewPaneController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Metrocard;

import java.util.ArrayList;

public class MetroCardOverviewPane extends GridPane {
    private MetroCardOverviewPaneController metroCardOverviewPaneController;

    private TableView<Metrocard> table;

    public MetroCardOverviewPane() {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("List of Metro cards:"), 0, 0, 1, 1);

        this.table = new TableView<>();

        TableColumn<Metrocard, Integer> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Metrocard, String> month = new TableColumn<>("Available until");
        month.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Metrocard, Integer> availableTrips = new TableColumn<>("Available trips");
        availableTrips.setCellValueFactory(new PropertyValueFactory<>("availableTrips"));
        TableColumn<Metrocard, Integer> usedTrips = new TableColumn<>("Used trips");
        usedTrips.setCellValueFactory(new PropertyValueFactory<>("usedTrips"));

        table.getColumns().addAll(id, month, availableTrips, usedTrips);

        this.add(this.table, 0, 1, 1, 1);

    }

    public void updateMetrocardList(ArrayList<Metrocard> metrocards) {
        this.table.getItems().setAll(metrocards);
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController metroCardOverviewPaneController) {
        this.metroCardOverviewPaneController = metroCardOverviewPaneController;
    }
}
