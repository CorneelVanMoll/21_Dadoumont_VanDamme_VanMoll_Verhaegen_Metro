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
import model.Gate;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;

public class ControlCenterPane extends Pane {
    ControlCenterPaneController controlCenterPaneController;
    private HBox gatesHBox;
    private TextArea textArea;

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

                // Open Metro Station Combo Box
                ComboBox<LoadSaveStrategyEnum> cbxLoadSaveStrategy = new ComboBox<>();
                cbxLoadSaveStrategy.getItems().setAll(LoadSaveStrategyEnum.values());
                cbxLoadSaveStrategy.setPromptText("Load");
                openStationHBox.getChildren().add(cbxLoadSaveStrategy);

                // Open Metro Station Button
                Button openMetroButton = new Button("Open metro station");
                openMetroButton.setOnAction((event) -> {
                    if (cbxLoadSaveStrategy.getValue() != null) {
                        controlCenterPaneController.openMetroStation(cbxLoadSaveStrategy.getValue());
                    }
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
        gatesHBox = new HBox(10);
        gatesHBox.setPadding(new Insets(5));
        gatesHBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
        gatesHBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT)));
        rootVBox.getChildren().add(gatesHBox);

        // Alerts Label
        Label alertsLabel = new Label("ALERTS");
        alertsLabel.setPadding(new Insets(0, 0, 0, 10));
        alertsLabel.setFont(new Font(20));
        rootVBox.getChildren().add(alertsLabel);

        // Alerts Scroll Pane
        ScrollPane alertsScrollPane = new ScrollPane();
        textArea = new TextArea();
        textArea.setWrapText(true);


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


        for(Gate gate: controlCenterPaneController.getGates()) {
            // Gate 1 VBox
            VBox gate1VBox = new VBox(10);
            gate1VBox.setPadding(new Insets(5));
            gate1VBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
            gate1VBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
                    BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY,
                    BorderWidths.DEFAULT)));
            gatesHBox.getChildren().add(gate1VBox);
            gate1VBox.setStyle("-fx-background-color: #de5b0b;");
            // Gate 1 Label
            Label gate1Label = new Label(gate.getName() + " / ACTIVE");
            gate1VBox.getChildren().add(gate1Label);

            // Gate 1 Activate Button
            Button gate1ActivateButton = new Button("Activate");
            gate1VBox.getChildren().add(gate1ActivateButton);
            gate1ActivateButton.setOnAction((event) -> {
                gate.activate();
                gate1VBox.setStyle("-fx-background-color: #FFFFFF;");
            });

            // Gate 1 Deactivate Button
            Button gate1DeactivateButton = new Button("Deactivate");
            gate1VBox.getChildren().add(gate1DeactivateButton);
            gate1DeactivateButton.setOnAction((event) -> {
                gate1VBox.setStyle("-fx-background-color: #de5b0b;");
                gate.deactivate();
            });

            // Gate 1 Amount Scanned Cards Label
            Label gate1AmountScannedCardsLabel = new Label("# scanned cards");
            gate1VBox.getChildren().add(gate1AmountScannedCardsLabel);

            // Gate 1 Amount Scanned Cards TextField
            TextField gate1AmountScannedCardsTextField = new TextField(String.valueOf(gate.getScannedCards()));
            gate.setOutCardsScanned(gate1AmountScannedCardsTextField);
            gate1AmountScannedCardsTextField.setEditable(false);
            gate1VBox.getChildren().add(gate1AmountScannedCardsTextField);




        }

    }


    public void refresh() {
        String out = "";
        for(String alert: controlCenterPaneController.getAlerts()){
            out += alert+'\n';
        }
        textArea.setText(out);


        for(Gate gate: controlCenterPaneController.getGates()) {
            System.out.println(gate.getScannedCards());
            gate.getOutCardsScanned().setText(String.valueOf(gate.getScannedCards()));
        }
    }
}

