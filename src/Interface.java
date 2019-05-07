//package firstgui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedInputStream;

public class Interface extends Application {
	private TableView<Drug> table;
	Scene scene1, scene2;

	private ObservableList<Drug> data;
	private String apiURL = "https://blockchain-restful-api.herokuapp.com/api/query";

	@Override
	public void start(Stage primaryStage) {

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
				System.out.println("garbage");
		});
		/**
		 * Popup Stage popup = new Stage(); popup.initModality(Modality.NONE);
		 * popup.setTitle("Product Information"); Label pLabel = new Label("This should
		 * say information on the thing"); pLabel.setAlignment(Pos.CENTER); Scene scene1
		 * = new Scene (pLabel,300,300);
		 * 
		 * popup.setScene(scene1); popup.show();
		 */
		// Scene 2

		ObservableList<String> options = FXCollections.observableArrayList("Etherium", "Hyper Ledger", "Open Chain");

		Button apply = new Button("apply");
		apply.setOnAction(e ->{
//			displayData();
			table.setItems(data); // add data to the table
		});

		Button Nlookup = new Button("New Lookup");

		final ComboBox comboBox = new ComboBox(options);

		HBox hbox = new HBox(20, comboBox, apply, Nlookup);

		Label sku = new Label("Product SKU:");
		Label name = new Label("Product Name:");
		Label supplier = new Label("Supplier:");
		TextField skuField = new TextField();
		TextField nameField = new TextField();
		TextField supplyField = new TextField();

		GridPane lookupGrid = new GridPane();
		lookupGrid.setHgap(10);
		lookupGrid.setVgap(10);
		lookupGrid.add(sku, 0, 0);
		lookupGrid.add(name, 0, 1);
		lookupGrid.add(supplier, 0, 2);
		lookupGrid.add(skuField, 1, 0);
		lookupGrid.add(nameField, 1, 1);
		lookupGrid.add(supplyField, 1, 2);

		lookupGrid.setAlignment(Pos.TOP_CENTER);

		Button lookup = new Button("Lookup");
		lookup.setOnAction(e -> {
			System.out.println(skuField.getText() + " " + nameField.getText() + " " + supplyField.getText());
			primaryStage.setScene(scene1);
		});

		data = JSONparser.parse(new BufferedInputStream(API_Calls.getInputStream(apiURL)));
		table = createTable();

		VBox vbox2 = new VBox(10, hbox, lookupGrid, lookup, table);
		vbox2.setPadding(new Insets(10));
		vbox2.setAlignment(Pos.TOP_CENTER);

		// layout2.getChildren().addAll(sku, lookup);
		scene2 = new Scene(vbox2, 700, 700);

		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	// method: createTable
	// purpose: create and populate tableView
	public TableView<Drug> createTable(){
		TableView<Drug> table = new TableView<>();

		// create and link columns to Drug fields
		TableColumn<Drug, String> Pid = new TableColumn<>("Product ID");
		TableColumn<Drug, String> Pname = new TableColumn<>("Product Name");
		TableColumn<Drug, String> PcomponentOf = new TableColumn<>("Component Of");
		TableColumn<Drug, String> Powner = new TableColumn<>("Owner");
		TableColumn<Drug, String> PprevOwner = new TableColumn<>("Previous Owner");
		TableColumn<Drug, String> Pquantity = new TableColumn<>("Quantity");
		TableColumn<Drug, String> PpricePerUnit = new TableColumn<>("Price Per Unit");
		TableColumn<Drug, String> PtotalPrice = new TableColumn<>("Total Price");
		TableColumn<Drug, String> PtransactionDate = new TableColumn<>("Transaction Date");
		TableColumn<Drug, String> PorderID = new TableColumn<>("Order ID");

		// populate cell with data
		Pid.setCellValueFactory(new PropertyValueFactory<>("productID"));
		Pname.setCellValueFactory(new PropertyValueFactory<>("productName"));
		PcomponentOf.setCellValueFactory(new PropertyValueFactory<>("componentOf"));
		Powner.setCellValueFactory(new PropertyValueFactory<>("owner"));
		PprevOwner.setCellValueFactory(new PropertyValueFactory<>("previousOwner"));
		Pquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		PpricePerUnit.setCellValueFactory(new PropertyValueFactory<>("pricePerUnit"));
		PtotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		PtransactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
		PorderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));

		Pid.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Pname.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PcomponentOf.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Powner.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PprevOwner.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Pquantity.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PpricePerUnit.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PtotalPrice.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PtransactionDate.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		PorderID.prefWidthProperty().bind(table.widthProperty().multiply(.2));

		// add columns to table
		table.getColumns().add(Pid);
		table.getColumns().add(Pname);
		table.getColumns().add(PcomponentOf);
		table.getColumns().add(Powner);
		table.getColumns().add(PprevOwner);
		table.getColumns().add(Pquantity);
		table.getColumns().add(PpricePerUnit);
		table.getColumns().add(PtotalPrice);
		table.getColumns().add(PtransactionDate);
		table.getColumns().add(PorderID);

		return table;
	}

	public void displayData(){

	}
}
