//package firstgui;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Interface extends Application {
	private TableView table = new TableView();
	Scene scene1, scene2;
	
	final ObservableList<Drug> dData = FXCollections
			.observableArrayList(new Drug("1234", "Crack", "Big5", "List", "List1"));


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

		ObservableList<String> options = FXCollections.observableArrayList("Etherium", "Blockchain 2", "BlockChain 3",
				"I honestly dont know what other blockchains are being used");

		Button apply = new Button("apply");
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
		TableColumn Psku = new TableColumn("Product SKU");
		//Psku.setCellValueFactory(
		//		new PropertyValueFactory <Drug, String>("sku"));
		
		TableColumn Pname = new TableColumn("Product Name");
		TableColumn Psupply = new TableColumn("Supplier");
		TableColumn list = new TableColumn("List");
		TableColumn list2 = new TableColumn("One More List");

		Psku.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Pname.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		Psupply.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		list.prefWidthProperty().bind(table.widthProperty().multiply(.2));
		list2.prefWidthProperty().bind(table.widthProperty().multiply(.2));

		// Add data to list

		table.setItems(dData);
		table.getColumns().addAll(Psku, Pname, Psupply, list, list2);

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

	public static class Drug {
		private final SimpleStringProperty sku;
		private final SimpleStringProperty name;
		private final SimpleStringProperty supplier;
		private final SimpleStringProperty list;
		private final SimpleStringProperty list2;

		private Drug(String sku, String name, String supplier, String list, String list2) {
			this.sku = new SimpleStringProperty(sku);
			this.name = new SimpleStringProperty(name);
			this.supplier = new SimpleStringProperty(supplier);
			this.list = new SimpleStringProperty(list);
			this.list2 = new SimpleStringProperty(list2);
		}
	}

}
