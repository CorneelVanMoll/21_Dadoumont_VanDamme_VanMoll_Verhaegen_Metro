package view;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;

public class ControlCenterPane extends Pane {
    ControlCenterPaneController controlCenterPaneController;

    public ControlCenterPane() {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        // Root VBox
        VBox rootVBox = new VBox(10);
        rootVBox.setPadding(new Insets(10));
        rootVBox.setPrefWidth(bounds.getWidth() / 2);

        // Open/Close Metro Station Vbox
        VBox openCloseStationVBox = new VBox(10);
        openCloseStationVBox.setPadding(new Insets(5));
        openCloseStationVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
        openCloseStationVBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        rootVBox.getChildren().add(openCloseStationVBox);

            // Open Metro Station Hbox
            HBox openStationHBox = new HBox(10);
            openCloseStationVBox.getChildren().add(openStationHBox);

                // Open Metro Station Button
                Button openMetroButton = new Button("Open metro station");
                openMetroButton.setOnAction((event) -> {
                    controlCenterPaneController.openMetroStation();
                });
                openStationHBox.getChildren().add(openMetroButton);

            // Close Metro Station Button
            Button closeMetroButton = new Button("Close metro station");
            closeMetroButton.setOnAction((event) -> {
                controlCenterPaneController.closeMetroStation();
            });
            openCloseStationVBox.getChildren().add(closeMetroButton);

        // Info Vbox
        VBox infoVBox = new VBox(10);
        infoVBox.setPadding(new Insets(5));
        infoVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
        infoVBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        rootVBox.getChildren().add(infoVBox);

            // Number of Sold Tickets  Hbox
            HBox numberSoldTicketsHBox = new HBox(10);
            numberSoldTicketsHBox.setAlignment(Pos.CENTER_LEFT);
            infoVBox.getChildren().add(numberSoldTicketsHBox);

                // Number of Sold Tickets Label
                Label numberSoldTicketsLabel = new Label("Number of sold tickets:");
                numberSoldTicketsHBox.getChildren().add(numberSoldTicketsLabel);

                // Number of Sold Tickets Textfield
                TextField numberSoldTicketsTextField = new TextField("#");
                numberSoldTicketsHBox.getChildren().add(numberSoldTicketsTextField);

            // Total Amount Tickets  Hbox
            HBox totalAmountTicketsHBox = new HBox(10);
            totalAmountTicketsHBox.setAlignment(Pos.CENTER_LEFT);
            infoVBox.getChildren().add(totalAmountTicketsHBox);

                // Total Amount Tickets Label
                Label totalAmountTicketsLabel = new Label("Total € amount of sold tickets:");
                totalAmountTicketsHBox.getChildren().add(totalAmountTicketsLabel);

                // Total Amount Tickets TextField
                TextField totalAmountTicketsTextField = new TextField("#");
                totalAmountTicketsHBox.getChildren().add(totalAmountTicketsTextField);

        // Gates Hbox
        HBox gatesHBox = new HBox(10);
        gatesHBox.setPadding(new Insets(5));
        gatesHBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
        gatesHBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        rootVBox.getChildren().add(gatesHBox);

            // Gate 1 VBox
            VBox gate1VBox = new VBox(10);
            gate1VBox.setPadding(new Insets(5));
            gate1VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
            gate1VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));
            gatesHBox.getChildren().add(gate1VBox);

                // Gate 1 Label
                Label gate1Label = new Label("GATE 1 / " + "ACTIVE");
                gate1VBox.getChildren().add(gate1Label);

                // Gate 1 Activate Button
                Button gate1ActivateButton = new Button("Activate");
                gate1VBox.getChildren().add(gate1ActivateButton);

                // Gate 1 Deactivate Button
                Button gate1DeactivateButton = new Button("Deactivate");
                gate1VBox.getChildren().add(gate1DeactivateButton);

                // Gate 1 Amount Scanned Cards Label
                Label gate1AmountScannedCardsLabel = new Label("# scanned cards");
                gate1VBox.getChildren().add(gate1AmountScannedCardsLabel);

                // Gate 1 Amount Scanned Cards TextField
                TextField gate1AmountScannedCardsTextField = new TextField("#");
                gate1VBox.getChildren().add(gate1AmountScannedCardsTextField);

            // Gate 2 VBox
            VBox gate2VBox = new VBox(10);
            gate2VBox.setPadding(new Insets(5));
            gate2VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
            gate2VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));
            gatesHBox.getChildren().add(gate2VBox);

                // Gate 2 Label
                Label gate2Label = new Label("GATE 2 / " + "INACTIVE");
                gate2VBox.getChildren().add(gate2Label);

                // Gate 2 Activate Button
                Button gate2ActivateButton = new Button("Activate");
                gate2VBox.getChildren().add(gate2ActivateButton);

                // Gate 2 Deactivate Button
                Button gate2DeactivateButton = new Button("Deactivate");
                gate2VBox.getChildren().add(gate2DeactivateButton);

                // Gate 2 Amount Scanned Cards Label
                Label gate2AmountScannedCardsLabel = new Label("# scanned cards");
                gate2VBox.getChildren().add(gate2AmountScannedCardsLabel);

                // Gate 2 Amount Scanned Cards TextField
                TextField gate2AmountScannedCardsTextField = new TextField("#");
                gate2VBox.getChildren().add(gate2AmountScannedCardsTextField);

            // Gate 3 VBox
            VBox gate3VBox = new VBox(10);
            gate3VBox.setPadding(new Insets(5));
            gate3VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
            gate3VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));
            gatesHBox.getChildren().add(gate3VBox);

                // Gate 3 Label
                Label gate3Label = new Label("GATE 3 / " + "ACTIVE");
                gate3VBox.getChildren().add(gate3Label);

                // Gate 3 Activate Button
                Button gate3ActivateButton = new Button("Activate");
                gate3VBox.getChildren().add(gate3ActivateButton);

                // Gate 3 Deactivate Button
                Button gate3DeactivateButton = new Button("Deactivate");
                gate3VBox.getChildren().add(gate3DeactivateButton);

                // Gate 3 Amount Scanned Cards Label
                Label gate3AmountScannedCardsLabel = new Label("# scanned cards");
                gate3VBox.getChildren().add(gate3AmountScannedCardsLabel);

                // Gate 3 Amount Scanned Cards TextField
                TextField gate3AmountScannedCardsTextField = new TextField("#");
                gate3VBox.getChildren().add(gate3AmountScannedCardsTextField);

        // Alerts Label
        Label alertsLabel = new Label("ALERTS");
        alertsLabel.setPadding(new Insets(0, 0, 0, 10));
        alertsLabel.setFont(new Font(20));
        rootVBox.getChildren().add(alertsLabel);

        // Alerts Scroll Pane
        ScrollPane alertsScrollPane = new ScrollPane();
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        for (int i = 0; i < 30; i++) {
            textArea.setText(textArea.getText() + "New Alert\n");
        }
        alertsScrollPane.setContent(textArea);
        alertsScrollPane.setFitToWidth(true);
        alertsScrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
        alertsScrollPane.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        rootVBox.getChildren().add(alertsScrollPane);

        this.getChildren().add(rootVBox);
    }

    public void setControlCenterPaneController(ControlCenterPaneController controller) {
        this.controlCenterPaneController = controller;
    }
}
