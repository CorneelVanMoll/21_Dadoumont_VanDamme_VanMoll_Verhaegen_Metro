package view;

import controller.MetroStationViewController;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class MetroStationView {
	MetroStationViewController metroStationViewController;

	private Stage stage = new Stage();

	private List<Integer> metroCardIDList;
	private List<ComboBox<Integer>> cbxCardIDsList;
	
	public MetroStationView(){			
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		GridPane root = new GridPane();

		cbxCardIDsList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			ComboBox<Integer> cbxCardIDs = new ComboBox<>();
			cbxCardIDsList.add(cbxCardIDs);
			root.add(cbxCardIDs,i,0,1,1);
		}

		Scene scene = new Scene(root, 650, 300);			
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
