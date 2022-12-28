package view;

import controller.MetroStationViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Gate;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class MetroStationView {
	MetroStationViewController metroStationViewController;

	private Stage stage = new Stage();

	private List<Integer> metroCardIDList;
	private List<ComboBox<Integer>> cbxCardIDsList;

	private HBox mainBox;
	private HashMap<Gate,TextField> outputs;
	
	public MetroStationView() {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(0);
		stage.setY(bounds.getMinY() + (bounds.getHeight() / 2));
		GridPane root = new GridPane();

		cbxCardIDsList = new ArrayList<>();
    
		mainBox = new HBox();
		mainBox.setSpacing(10);

		root.add(mainBox,0,0,1,1);
    
		Scene scene = new Scene(root, bounds.getWidth() / 2, (bounds.getHeight() / 2));
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateMetroCardIdList(List<Integer> IDs) {
		this.metroCardIDList = IDs;
		for (ComboBox<Integer> cbx : cbxCardIDsList) {
			cbx.getItems().setAll(metroCardIDList);
		}
	}

	public void setMetroStationViewController(MetroStationViewController metroStationViewController) {
		this.metroStationViewController = metroStationViewController;
		outputs = new HashMap<>();

		for(Gate gate: metroStationViewController.getGates()) {
			TextField output = new TextField();
			output.setEditable(false);
			outputs.put(gate,output);
		}

		for (Gate gate: metroStationViewController.getGates()) {
			HBox hbox = new HBox();

			hbox.setAlignment(Pos.BASELINE_CENTER);
			hbox.setPadding(new Insets(15, 12, 15, 12));
			hbox.setSpacing(10);
			hbox.setStyle("-fx-background-color: #336699;");

			Label label = new Label(gate.getName());

			final ComboBox<Integer> cbxCardIDs = new ComboBox<>();

			cbxCardIDsList.add(cbxCardIDs);

			Button scanBtn = new Button("Scan metrocard");
			scanBtn.setPrefSize(100, 20);
			scanBtn.setOnAction((event) -> {
				if (cbxCardIDs.getValue() != null) {
					this.metroStationViewController.scanMetroCard(gate, cbxCardIDs.getValue().toString());
				}
			});

			Button walkBtn = new Button("Walk through gate");
			walkBtn.setPrefSize(100, 20);
			walkBtn.setOnAction((event) -> {
				this.metroStationViewController.walkThroughGate(gate);

			});

			hbox.getChildren().addAll(label,cbxCardIDs,scanBtn,walkBtn, outputs.get(gate));

			mainBox.getChildren().add(hbox);
		}

	}

	public HashMap<Gate, TextField> getOutputs() {
		return this.outputs;
	}
}
