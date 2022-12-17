package view;



import controller.ControlCenterPaneController;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.MetroCardOverviewPane;

public class AdminMainPane extends BorderPane {

    private ControlCenterPane controlCenterPane;

    public AdminMainPane(){
	    TabPane tabPane = new TabPane(); 	    
        MetroCardOverviewPane metroCardOverviewPane = new MetroCardOverviewPane();

        controlCenterPane = new ControlCenterPane();

	//maak een controlCenterPane aan
	//maak een setupPane aan

        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center",controlCenterPane);

        Tab setupTab = new Tab("Setup");
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
        tabPane.getTabs().add(setupTab);
        this.setCenter(tabPane);
	}


    public ControlCenterPane getControlCenterPane() {
        return this.controlCenterPane;
    }

    public void setControlCenterPaneController(ControlCenterPaneController controller) {
        this.controlCenterPane.setControlCenterPaneController(controller);
    }


}
