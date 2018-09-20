package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Purchase> tableView;
    public Button newButton;
    public Button returnButton;
    public Button saveButton;
    public ComboBox<String> typeChoice;
    public TextField priceText;
    public DatePicker datePicker;
    public TableColumn priceColumn;
    public TableColumn dateColumn;
    public TableColumn typeColumn;
    Loader _loader;


    public void newRow() {
        // Extra condition used when history is cleared
        if (Purchase.purchases == null) {
            new  Purchase(typeChoice.getValue(), datePicker.getValue(), Double.valueOf(priceText.getText()));
            tableView.setItems(Purchase.purchases);
        } else {
            new Purchase(typeChoice.getValue(), datePicker.getValue(), Double.valueOf(priceText.getText()));
        }
        Collections.sort(Purchase.purchases);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        priceColumn.setCellValueFactory(new PropertyValueFactory("Price"));
        dateColumn.setCellValueFactory(new PropertyValueFactory("Date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory("Type"));
        if (Purchase.purchases != null) {
            tableView.setItems(Purchase.purchases);
        }


        typeChoice.setItems(FXCollections.<String>observableArrayList(
                "Food", "Tech", "Uni", "Other"
        ));
        typeChoice.setEditable(true);

        returnButton.setOnAction(e -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("other.fxml"));
                Scene scene = new Scene(root);
                Stage stage = Main.getPrimaryStage();
                stage.setScene(scene);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        _loader = new Loader();
    }

    public void save(){
        _loader.save(Purchase.purchases);
    }

}
