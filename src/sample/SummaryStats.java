package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class SummaryStats implements Initializable {
    public Label week;
    public Label week2;
    public Label week3;
    public Button returnButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocalDate now = LocalDate.now();
        Double weekD = weekNet(Purchase.datesAfter(getMonday()));
        Double week2D = weekNet(Purchase.datesBetween(getMonday().minusDays(7), getMonday()));
        Double week3D = weekNet(Purchase.datesBetween(getMonday().minusDays(14), getMonday().minusDays(7)));

        week.setText("$" + weekD);
        week2.setText("$" + week2D);
        week3.setText("$" + week3D);

        if (weekD >= week2D) {
            week.setTextFill(Color.GREEN);
        } else {
            week.setTextFill(Color.RED);
        }



        returnButton.setOnAction(e -> {
            try {
                new sceneChange(FXMLLoader.load(getClass().getResource("other.fxml")));
            } catch (IOException e1) {
                e1.printStackTrace();
            }});
    }

    public LocalDate getMonday() {
        LocalDate date = LocalDate.now();
        date = date.with(DayOfWeek.MONDAY);
        System.out.println(date.withDayOfMonth(1));
        return date;
    }

    public Double weekNet(List<Purchase> week) {
        double total = 0.0;
        for (Purchase purchase:week) {
            total-= purchase.getPrice();
        }
        return total;
    }
}
