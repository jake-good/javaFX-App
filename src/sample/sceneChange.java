package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneChange {

    public sceneChange(Parent root) {
        Main.getPrimaryStage().setScene(new Scene(root));
    }

}
