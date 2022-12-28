package view;

import controller.MetroTicketViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;

import java.util.ArrayList;
import java.util.List;

public class MetroTicketView {
	private Stage stage = new Stage();

	private List<Integer> IDs;
	private MetroTicketViewController metroTicketViewController;

	private ComboBox<Integer> cbxCardIDs;
		
	public MetroTicketView(){			
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);

		Button newMetroCardButton = new Button("New metro card");
		newMetroCardButton.setOnAction(event -> metroTicketViewController.newMetroCard());

		GridPane root = new GridPane();

		cbxCardIDs = new ComboBox<>();
		root.add(cbxCardIDs,0,0,1,1);
		root.add(newMetroCardButton,0,1,1,1);

		Scene scene = new Scene(root, 650, 350);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateMetroCardIdList(List<Integer> IDs) {
		this.IDs = IDs;
		cbxCardIDs.getItems().setAll(IDs);
	}

	public void setMetroTicketViewController(MetroTicketViewController metroTicketViewController) {
		this.metroTicketViewController = metroTicketViewController;
	}
}
