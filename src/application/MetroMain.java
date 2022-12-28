package application;
	
import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;
import controller.MetroStationViewController;
import controller.MetroTicketViewController;

import javafx.application.Application;
import javafx.stage.Stage;

import model.MetroEventsEnum;
import model.MetroFacade;

import view.*;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		MetroFacade metroFacade = new MetroFacade();

		AdminView adminView = new AdminView();
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();

		// Controllers
		AdminMainPane adminMainPane = adminView.getAdminMainPane();

		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(metroFacade, metroTicketView);
		metroTicketView.setMetroTicketViewController(metroTicketViewController);

		MetroStationViewController metroStationViewController = new MetroStationViewController(metroFacade,metroStationView);
		metroStationView.setMetroStationViewController(metroStationViewController);

		ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController(metroFacade, adminMainPane.getControlCenterPane());
		adminMainPane.setControlCenterPaneController(controlCenterPaneController);

		MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController(metroFacade, adminMainPane.getMetroCardOverviewPane());
		adminMainPane.setMetroCardOverviewPaneController(metroCardOverviewPaneController);

		metroFacade.addObserver(metroTicketViewController, MetroEventsEnum.OPEN_METROSTATION);
		metroFacade.addObserver(metroStationViewController, MetroEventsEnum.OPEN_METROSTATION);
		metroFacade.addObserver(metroCardOverviewPaneController, MetroEventsEnum.OPEN_METROSTATION);

		metroFacade.addObserver(metroTicketViewController, MetroEventsEnum.CLOSE_METROSTATION);
		metroFacade.addObserver(metroStationViewController, MetroEventsEnum.CLOSE_METROSTATION);
		metroFacade.addObserver(metroCardOverviewPaneController, MetroEventsEnum.CLOSE_METROSTATION);

		metroFacade.addObserver(metroTicketViewController, MetroEventsEnum.BUY_METROCARD);
		metroFacade.addObserver(metroStationViewController, MetroEventsEnum.BUY_METROCARD);
		metroFacade.addObserver(metroCardOverviewPaneController, MetroEventsEnum.BUY_METROCARD);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
