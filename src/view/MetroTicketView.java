package view;

import controller.MetroTicketViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class MetroTicketView {
	private Stage stage = new Stage();

	private List<Integer> IDs;
	private MetroTicketViewController metroTicketViewController;

	private ComboBox<Integer> metroCardIDCheckbox;
		
	public MetroTicketView(){
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		System.out.println(bounds);
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());

		// Root VBox
		VBox rootVBox = new VBox(10);
		rootVBox.setPadding(new Insets(10));

		// Top Vbox
		VBox topVBox = new VBox(10);
		topVBox.setPadding(new Insets(5));
		topVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		topVBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		rootVBox.getChildren().add(topVBox);

			// New Metro Card Button
			Button newMetroCardButton = new Button("New metro card");
			newMetroCardButton.setOnAction(event -> metroTicketViewController.newMetroCard());
			topVBox.getChildren().add(newMetroCardButton);

			// Metro Card Price Label
			Label metroCardPriceLabel = new Label("Metro card price is € 15 - 2 free rides included");
			topVBox.getChildren().add(metroCardPriceLabel);

		// Bottom Vbox
		VBox botVBox = new VBox(10);
		botVBox.setPadding(new Insets(5));
		botVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
		botVBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		rootVBox.getChildren().add(botVBox);

			// Select Metro Card Hbox
			HBox selectMetroCardHBox = new HBox(10);
			selectMetroCardHBox.setAlignment(Pos.CENTER_LEFT);
			botVBox.getChildren().add(selectMetroCardHBox);

				// Select Metro Card Label
				Label selectMetroCardLabel = new Label("Select metro card");
				selectMetroCardHBox.getChildren().add(selectMetroCardLabel);

				// Select Metro Card Checkbox
				metroCardIDCheckbox = new ComboBox<>();
				selectMetroCardHBox.getChildren().add(metroCardIDCheckbox);

			// Number of Rides Hbox
			HBox numberRidesHBox = new HBox(10);
			numberRidesHBox.setAlignment(Pos.CENTER_LEFT);
			botVBox.getChildren().add(numberRidesHBox);

				// Number of Rides Label
				Label numberRidesLabel = new Label("Number of rides");
				numberRidesHBox.getChildren().add(numberRidesLabel);

				// Number of Rides TextField
				TextField numberRidesTextField = new TextField();
				numberRidesHBox.getChildren().add(numberRidesTextField);

			// Student Hbox
			HBox studentHBox = new HBox(10);
			botVBox.getChildren().add(studentHBox);

				// Student CheckBox
				CheckBox studentCheckBox = new CheckBox();
				studentHBox.getChildren().add(studentCheckBox);

				// Student Label
				Label studentLabel = new Label("Higher education student?");
				studentHBox.getChildren().add(studentLabel);

			// Discount Hbox
			HBox discountHBox = new HBox(10);
			botVBox.getChildren().add(discountHBox);

				// Younger 26 RadioButton
				RadioButton younger26CheckBox = new RadioButton();
				discountHBox.getChildren().add(younger26CheckBox);
				// Younger 26 Label
				Label younger26Label = new Label("Younger than 26 years");
				discountHBox.getChildren().add(younger26Label);
				// Older 64 RadioButton
				RadioButton older64CheckBox = new RadioButton();
				discountHBox.getChildren().add(older64CheckBox);
				// Older 64 Label
				Label older64Label = new Label("Older than 64 years");
				discountHBox.getChildren().add(older64Label);
				// Between 26 and 64 RadioButton
				RadioButton between26and64CheckBox = new RadioButton();
				discountHBox.getChildren().add(between26and64CheckBox);
				// Between 26 and 64 Label
				Label between26and64Label = new Label("Between 26 and 64 years");
				discountHBox.getChildren().add(between26and64Label);

			// subVbox
			VBox subVBox = new VBox(10);
			subVBox.setPadding(new Insets(5));
			subVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY,Insets.EMPTY)));
			subVBox.setBorder(new Border(new BorderStroke(Color.valueOf("#9E9E9E"),
					BorderStrokeStyle.SOLID,
					CornerRadii.EMPTY,
					BorderWidths.DEFAULT)));
			botVBox.getChildren().add(subVBox);

				// Add Extra Rides Button
				Button addExtraRidesButton = new Button("Add extra rides to metro card");
				subVBox.getChildren().add(addExtraRidesButton);

				// Total Price Hbox
				HBox totalPriceHBox = new HBox(10);
				totalPriceHBox.setAlignment(Pos.CENTER_LEFT);
				subVBox.getChildren().add(totalPriceHBox);

					// Number of Rides Label
					Label totalPriceLabel = new Label("Total price:");
					totalPriceHBox.getChildren().add(totalPriceLabel);

					// Number of Rides TextField
					TextField totalPriceTextField = new TextField();
					totalPriceHBox.getChildren().add(totalPriceTextField);

				// Ride Price Label
				Label ridePriceLabel = new Label("Basis price of ride is € 2,10 - € 0,15 64+ " +
						"age discount - € 0,10 Christmas leave discount");
				subVBox.getChildren().add(ridePriceLabel);

				// Request Handling HBox
				HBox requestHandlingHBox = new HBox(10);
				subVBox.getChildren().add(requestHandlingHBox);

					// Confirm Request Button
					Button confirmRequestButton = new Button("Confirm request");
					requestHandlingHBox.getChildren().add(confirmRequestButton);

					// Cancel Request Button
					Button cancelRequestButton = new Button("Cancel request");
					requestHandlingHBox.getChildren().add(cancelRequestButton);


		Scene scene = new Scene(rootVBox, bounds.getWidth() / 2, (bounds.getHeight() / 2) - bounds.getMinY());
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void updateMetroCardIdList(List<Integer> IDs) {
		this.IDs = IDs;
		metroCardIDCheckbox.getItems().setAll(IDs);
	}

	public void setMetroTicketViewController(MetroTicketViewController metroTicketViewController) {
		this.metroTicketViewController = metroTicketViewController;
	}
}
