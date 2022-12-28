package view;

import controller.MetroCardOverviewPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Metrocard;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

public class MetroCardOverviewPane extends GridPane {
    private ObservableList<Metrocard> metroCards;
    private MetroCardOverviewPaneController metroCardOverviewPaneController;

    private TableView<Metrocard> table;


    public MetroCardOverviewPane() {
        System.out.println("init");
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

        this.table.setItems(metroCards);

        table.getColumns().addAll(id, month, availableTrips, usedTrips);

        this.getChildren().add(this.table);

    }

    public void updateMetrocardList(ArrayList<Metrocard> metrocards) {
        metroCards = FXCollections.observableArrayList(metrocards);
        this.table.setItems(metroCards);
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController metroCardOverviewPaneController) {
        this.metroCardOverviewPaneController = metroCardOverviewPaneController;
    }
}
