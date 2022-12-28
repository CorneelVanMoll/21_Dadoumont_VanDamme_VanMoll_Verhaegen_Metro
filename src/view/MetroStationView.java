package view;

import controller.MetroStationViewController;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class MetroStationView {
	MetroStationViewController metroStationViewController;

	private final Stage stage = new Stage();

	private List<Integer> metroCardIDList;
	private final List<ComboBox<Integer>> cbxCardIDsList;
	
	public MetroStationView(){
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(0);
		stage.setY(bounds.getMinY() + (bounds.getHeight() / 2));

		cbxCardIDsList = new ArrayList<>();

		// Root Hbox
		HBox rootHBox = new HBox(10);
		rootHBox.setPadding(new Insets(10));

		// Gate 1 VBox
		VBox gate1VBox = new VBox(10);
		gate1VBox.setPadding(new Insets(5));
		gate1VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		gate1VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		rootHBox.getChildren().add(gate1VBox);

			// Gate 1 Label
			Label gate1Label = new Label("GATE 1");
			gate1VBox.getChildren().add(gate1Label);

			// Gate 1 Metro Card ID Label
			Label gate1MetroCardIDLabel = new Label("Metrocard ID:");
			gate1VBox.getChildren().add(gate1MetroCardIDLabel);

			// Gate 1 Metro Card ID ComboBox
			ComboBox<Integer> gate1IDComboBox = new ComboBox<>();
			cbxCardIDsList.add(gate1IDComboBox);
			gate1VBox.getChildren().add(gate1IDComboBox);

			// Gate 1 Scan Metro Card Button
			Button gate1ScanButton = new Button("Scan metro card");
			gate1VBox.getChildren().add(gate1ScanButton);

			// Gate 1 Walk through Gate Button
			Button gate1WalkButton = new Button("Walk through gate");
			gate1VBox.getChildren().add(gate1WalkButton);

			// Gate 1 State TextField
			TextField gate1StateTextField = new TextField("Card # is scanned");
			gate1VBox.getChildren().add(gate1StateTextField);

		// Gate 2 VBox
		VBox gate2VBox = new VBox(10);
		gate2VBox.setPadding(new Insets(5));
		gate2VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		gate2VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		rootHBox.getChildren().add(gate2VBox);

			// Gate 2 Label
			Label gate2Label = new Label("GATE 2");
			gate2VBox.getChildren().add(gate2Label);

			// Gate 2 Metro Card ID Label
			Label gate2MetroCardIDLabel = new Label("Metrocard ID:");
			gate2VBox.getChildren().add(gate2MetroCardIDLabel);

			// Gate 2 Metro Card ID ComboBox
			ComboBox<Integer> gate2IDComboBox = new ComboBox<>();
			cbxCardIDsList.add(gate2IDComboBox);
			gate2VBox.getChildren().add(gate2IDComboBox);

			// Gate 2 Scan Metro Card Button
			Button gate2ScanButton = new Button("Scan metro card");
			gate2VBox.getChildren().add(gate2ScanButton);

			// Gate 2 Walk through Gate Button
			Button gate2WalkButton = new Button("Walk through gate");
			gate2VBox.getChildren().add(gate2WalkButton);

			// Gate 2 State TextField
			TextField gate2StateTextField = new TextField("Card # is scanned");
			gate2VBox.getChildren().add(gate2StateTextField);


		// Gate 3 VBox
		VBox gate3VBox = new VBox(10);
		gate3VBox.setPadding(new Insets(5));
		gate3VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		gate3VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		rootHBox.getChildren().add(gate3VBox);

			// Gate 3 Label
			Label gate3Label = new Label("GATE 3");
			gate3VBox.getChildren().add(gate3Label);

			// Gate 3 Metro Card ID Label
			Label gate3MetroCardIDLabel = new Label("Metrocard ID:");
			gate3VBox.getChildren().add(gate3MetroCardIDLabel);

			// Gate 3 Metro Card ID ComboBox
			ComboBox<Integer> gate3IDComboBox = new ComboBox<>();
			cbxCardIDsList.add(gate3IDComboBox);
			gate3VBox.getChildren().add(gate3IDComboBox);

			// Gate 3 Scan Metro Card Button
			Button gate3ScanButton = new Button("Scan metro card");
			gate3VBox.getChildren().add(gate3ScanButton);

			// Gate 3 Walk through Gate Button
			Button gate3WalkButton = new Button("Walk through gate");
			gate3VBox.getChildren().add(gate3WalkButton);

			// Gate 3 State TextField
			TextField gate3StateTextField = new TextField("Card # is scanned");
			gate3VBox.getChildren().add(gate3StateTextField);

		Scene scene = new Scene(rootHBox, bounds.getWidth() / 2, (bounds.getHeight() / 2));
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
	}
}
