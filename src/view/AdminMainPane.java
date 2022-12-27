package view;



import controller.ControlCenterPaneController;

import controller.MetroCardOverviewPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class AdminMainPane extends BorderPane {

    private ControlCenterPane controlCenterPane;
    private MetroCardOverviewPane metroCardOverviewPane;

    public AdminMainPane(){
	    TabPane tabPane = new TabPane(); 	    
         metroCardOverviewPane = new MetroCardOverviewPane();

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
    public MetroCardOverviewPane getMetroCardOverviewPane() {
        return this.metroCardOverviewPane;
    }

    public void setControlCenterPaneController(ControlCenterPaneController controller) {
        this.controlCenterPane.setControlCenterPaneController(controller);
    }

    public void setMetroCardOverviewPaneController(MetroCardOverviewPaneController controller) {
        this.metroCardOverviewPane.setMetroCardOverviewPaneController(controller);
    }

}
