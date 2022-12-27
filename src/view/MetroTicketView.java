package view;

import controller.MetroTicketViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.MetroFacade;

import java.util.ArrayList;

public class MetroTicketView {
	private Stage stage = new Stage();

	private ArrayList<Integer> IDs;
	private MetroTicketViewController metroTicketViewController;
		
	public MetroTicketView(){			
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);

		Button buyMetroCardButton = new Button("Buy Metrocard");
		buyMetroCardButton.setOnAction(event -> metroTicketViewController.buyMetroCard());

		Group root = new Group(buyMetroCardButton);
		Scene scene = new Scene(root, 650, 350);


		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateMetroCardIdList(ArrayList<Integer> IDs) {
		this.IDs = IDs;
	}

	public void setMetroTicketViewController(MetroTicketViewController metroTicketViewController) {
		this.metroTicketViewController = metroTicketViewController;
	}
}
