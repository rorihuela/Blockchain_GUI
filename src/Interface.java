import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Interface extends Application {
	int test = 0;
	Scene scene1, scene2;


	public void start(Stage primaryStage) {
		ObservableList<Drug> data = FXCollections.observableArrayList();
		TableView<Drug> table = new TableView<>();

		primaryStage.setTitle("Drug Lookup");

		// Scene 1
		Label username = new Label("Username:");
		Label password = new Label("Password:");
		TextField uField = new TextField("student");
		TextField pField = new TextField("password");
		Button login = new Button("Login");

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(username, 0, 0);
		grid.add(password, 0, 1);
		grid.add(uField, 1, 0);
		grid.add(pField, 1, 1);

		VBox vbox = new VBox(10, grid, login);
		scene1 = new Scene(vbox, 300, 250);
		vbox.setPadding(new Insets(10));
		vbox.setAlignment(Pos.CENTER);

		login.setOnAction(e -> {
			if (uField.getText().equals("student") && pField.getText().equals("password"))
				primaryStage.setScene(scene2);
			else
				System.out.println("Incorrect");
		});

		// Scene 2

		ObservableList<String> options = FXCollections.observableArrayList("Etherium", "Hyper Ledger", "Open Chain");

		Button apply = new Button("apply");

		final ComboBox comboBox = new ComboBox(options);

		HBox hbox = new HBox(20, comboBox, apply);


		// Seach box code start
		ChoiceBox<String> choiceBox = new ChoiceBox();
		choiceBox.getItems().addAll("Product SKU", "Product Name", "Owner");
		choiceBox.setValue("Product Name");

		TextField textField = new TextField();
		textField.setPromptText("Search");


		try {
			data = JSONparser.parse(new FileInputStream(new File("src/testJSON.json")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		table = createTable(data);
		
		try {
			FilteredList<Drug> flPerson = new FilteredList(data, p -> true);

			table.setItems(flPerson);

			textField.setOnKeyReleased(keyEvent -> {
				switch (choiceBox.getValue())
				{
				case "Product Name":
					flPerson.setPredicate(
							p -> p.getProductName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
					break;
				 case "Product SKU":
					 
							flPerson.setPredicate(
						p ->  p.getID().contains(textField.getText().toLowerCase().trim()));
				 break;
				case "Owner":
					flPerson.setPredicate(
							p -> p.getOwner().toLowerCase().contains(textField.getText().toLowerCase().trim()));
					break;
				}
			});
		} catch (Exception f) {
			System.out.println("exception");
		}
		
		//Search box code end

		//Popup dialog start
		Alert alert = new Alert(AlertType.INFORMATION);
		try {
			table.setRowFactory(tv -> {
				TableRow<Drug> row = new TableRow<>();
				row.setOnMouseClicked(event -> {
					if (event.getClickCount() == 2 && (!row.isEmpty())) {
						Drug rowData = row.getItem();
						alert.setTitle("Drug Details");
						alert.setHeaderText(rowData.getProductName());
						alert.setContentText(rowData.report());
						alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
						alert.showAndWait();
					}
				});
				return row;
			});
		} catch (Exception E) {
			System.out.println("hi");
		}

		//Popup Dialog end
		
		HBox hbox2 = new HBox(10, choiceBox, textField);
		hbox.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);


		VBox vbox2 = new VBox(10, hbox, hbox2, table);

		vbox2.setPadding(new Insets(10));
		vbox2.setAlignment(Pos.TOP_CENTER);

		scene2 = new Scene(vbox2, 700, 700);

		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public TableView<Drug> createTable(ObservableList data) {
		TableView<Drug> table = new TableView();
		table.setItems(data);

		TableColumn<Drug, String> Pid = new TableColumn<>("Product ID");
		TableColumn<Drug, String> Pname = new TableColumn<>("Product Name");
		TableColumn<Drug, String> Powner = new TableColumn<>("Owner");
		TableColumn<Drug, String> PprevOwner = new TableColumn<>("Previous Owner");
		TableColumn<Drug, String> Pquantity = new TableColumn<>("Quantity");
		TableColumn<Drug, String> PpricePerUnit = new TableColumn<>("Price Per Unit");
		TableColumn<Drug, String> PtotalPrice = new TableColumn<>("Total Price");

		Pid.setCellValueFactory(new PropertyValueFactory<>("productID"));
		Pname.setCellValueFactory(new PropertyValueFactory<>("productName"));
		Powner.setCellValueFactory(new PropertyValueFactory<>("owner"));
		PprevOwner.setCellValueFactory(new PropertyValueFactory<>("previousOwner"));
		Pquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		PpricePerUnit.setCellValueFactory(new PropertyValueFactory<>("pricePerUnit"));
		PtotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

		Pid.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Pname.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Powner.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PprevOwner.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Pquantity.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PpricePerUnit.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PtotalPrice.prefWidthProperty().bind(table.widthProperty().multiply(.2));

		table.getColumns().add(Pid);
		table.getColumns().add(Pname);
		table.getColumns().add(Powner);
		table.getColumns().add(PprevOwner);
		table.getColumns().add(Pquantity);
		table.getColumns().add(PpricePerUnit);
		table.getColumns().add(PtotalPrice);

		return table;
	}
}
