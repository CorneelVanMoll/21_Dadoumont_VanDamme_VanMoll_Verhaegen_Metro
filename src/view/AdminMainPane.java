package view;

import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class AdminMainPane extends BorderPane {
    private final ControlCenterPane controlCenterPane;
    private final MetroCardOverviewPane metroCardOverviewPane;

    public AdminMainPane(){
	    TabPane tabPane = new TabPane();

        metroCardOverviewPane = new MetroCardOverviewPane();
        controlCenterPane = new ControlCenterPane();

        Tab metroCardOverviewTab = new Tab("Metro cards overview",metroCardOverviewPane);
        Tab controlCenterTab = new Tab("Control Center",controlCenterPane);
        tabPane.getTabs().add(controlCenterTab);
        tabPane.getTabs().add(metroCardOverviewTab);
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
