package view;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ControlCenterPane extends GridPane {

    ControlCenterPaneController controlCenterPaneController;

    public ControlCenterPane() {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        Button button = new Button("Open metro station");

        button.setOnAction((event) -> {
            controlCenterPaneController.openMetroStation();
        });

        this.add(button, 0, 0, 1, 1);


    }


    public void setControlCenterPaneController(ControlCenterPaneController controller) {
        this.controlCenterPaneController = controller;
    }

}
