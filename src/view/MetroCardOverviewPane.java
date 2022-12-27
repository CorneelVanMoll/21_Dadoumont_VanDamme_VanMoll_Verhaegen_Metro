package view;

import controller.MetroCardOverviewPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Metrocard> metroCards = FXCollections.observableArrayList(new ArrayList<>());
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

        table.setItems(metroCards);

        table.getColumns().addAll(id, month, availableTrips, usedTrips);

        this.getChildren().add(this.table);
    }

    public void updateMetrocardList(ArrayList<Metrocard> metrocards) {

        System.out.println(metrocards);
        for (Metrocard m : metrocards) {
            this.getChildren().add(new Text(m.toString()));
        }

        //ObservableList
        //this.metroCards = FXCollections.observableArrayList(metrocards);
        //System.out.println(metrocards);
        //System.out.println(metrocards);
        //table.setItems(metroCards);
        //metroCards.add(new Metrocard(3, Month.APRIL, Year.now(), 3,5));
        //table.getItems().add(new Metrocard(4, Month.APRIL, Year.now(), 3,5));
        //System.out.println(table.getItems());
        //table.getItems().addAll(metrocards);

        //table.getItems().add(new Metrocard(1, Month.APRIL, Year.now(), 3,5));
        //System.out.println(metrocards);
        //table.refresh();
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController metroCardOverviewPaneController) {
        this.metroCardOverviewPaneController = metroCardOverviewPaneController;
    }
}
