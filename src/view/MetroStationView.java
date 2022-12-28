package view;

import controller.MetroStationViewController;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
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
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(0);
		stage.setY(bounds.getMinY() + (bounds.getHeight() / 2));
		GridPane root = new GridPane();

		cbxCardIDsList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			ComboBox<Integer> cbxCardIDs = new ComboBox<>();
			cbxCardIDsList.add(cbxCardIDs);
			root.add(cbxCardIDs,i,0,1,1);
		}


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
	}
}
