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
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Gate;

import java.util.ArrayList;
import java.util.HashMap;

public class MetroStationView {
	MetroStationViewController metroStationViewController;

	private Stage stage = new Stage();		
	private Group root;
	private HBox mainBox;

	private HashMap<Gate,TextField> outputs;


	public MetroStationView(){			
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		root = new Group();
		mainBox = new HBox();
		mainBox.setSpacing(10);
		root.getChildren().add(mainBox);

		Scene scene = new Scene(root, 650, 300);


		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}

	public void setMetroStationViewController(MetroStationViewController metroStationViewController) {
		this.metroStationViewController = metroStationViewController;
		outputs = new HashMap<>();

		for(Gate gate: metroStationViewController.getGates()) {
			TextField output = new TextField();
			output.setEditable(false);
			outputs.put(gate,output);
		}

		for(Gate gate: metroStationViewController.getGates()) {



			HBox hbox = new HBox();


			hbox.setAlignment(Pos.BASELINE_CENTER);
			hbox.setPadding(new Insets(15, 12, 15, 12));
			hbox.setSpacing(10);
			hbox.setStyle("-fx-background-color: #336699;");




			Label label = new Label(gate.getName());

			final ComboBox comboBox = new ComboBox(metroStationViewController.getIDs());


			Button scanBtn = new Button("Scan metrocard");
			scanBtn.setPrefSize(100, 20);
			scanBtn.setOnAction((event) -> {
				this.metroStationViewController.scanMetroCard(gate, comboBox.getValue().toString());

			});


			Button walkBtn = new Button("Walk through gate");
			walkBtn.setPrefSize(100, 20);
			walkBtn.setOnAction((event) -> {

				this.metroStationViewController.walkThroughGate(gate);

			});



			hbox.getChildren().addAll(label,comboBox,scanBtn,walkBtn, outputs.get(gate));

			mainBox.getChildren().add(hbox);
		}

	}

	public HashMap<Gate, TextField> getOutputs() {
		return this.outputs;
	}
}
