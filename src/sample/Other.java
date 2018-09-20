package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Other implements Initializable {

    public Button sample;
    public Button summaryStats;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       sample.setOnAction(e -> {
           try {
               new sceneChange(FXMLLoader.load(getClass().getResource("sample.fxml")));
           } catch (IOException e1) {
               e1.printStackTrace();

           }});
       summaryStats.setOnAction(e -> {
           try {
               new sceneChange(FXMLLoader.load(getClass().getResource("summaryStats.fxml")));
           } catch (IOException e1) {
               e1.printStackTrace();
           }});
    }
}
