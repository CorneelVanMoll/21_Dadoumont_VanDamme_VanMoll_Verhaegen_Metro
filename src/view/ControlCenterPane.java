package view;

import controller.ControlCenterPaneController;
import javafx.scene.layout.GridPane;

public class ControlCenterPane extends GridPane {
    ControlCenterPaneController controlCenterPaneController;

    public void setControlCenterPaneController(ControlCenterPaneController controller) {
        this.controlCenterPaneController = controller;
    }
}
