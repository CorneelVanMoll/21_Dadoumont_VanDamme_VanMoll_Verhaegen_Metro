package application;
	
import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;
import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MetroFacade;
import model.Metrocard;
import model.database.MetrocardDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;
import view.*;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {



		MetroFacade metroFacade = new MetroFacade();


		AdminView adminView = new AdminView();
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();

		MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane();
		ControlCenterPane controlCenterPane = new ControlCenterPane();

		// Controllers
		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(metroFacade, metroTicketView);
		metroTicketView.setMetroTicketViewController(metroTicketViewController);

		MetroStationViewController metroStationViewController = new MetroStationViewController(metroFacade,metroStationView);
		metroStationView.setMetroStationViewController(metroStationViewController);

		MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController(metroFacade,metroCardOverviewPane);
		metroCardOverviewPane.setMetroCardOverviewPaneController(metroCardOverviewPaneController);

		ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController(metroFacade, controlCenterPane);
		controlCenterPane.setControlCenterPaneController(controlCenterPaneController);

		metroFacade.addObserver(metroTicketViewController);
		metroFacade.addObserver(metroStationViewController);
		metroFacade.addObserver(metroCardOverviewPaneController);
		metroFacade.addObserver(controlCenterPaneController);

	}
	
	public static void main(String[] args) {



		launch(args);
	}
}
