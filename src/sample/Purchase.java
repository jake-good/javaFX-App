package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;

import javax.swing.text.html.ListView;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Purchase implements Comparable<Purchase> {
    String Type;
    LocalDate Date;
    double Price;
    static double net;
    static ObservableList<Purchase> purchases;
    static LocalDate _first;
    static LocalDate _last;

    public Purchase(String category, LocalDate date, double price) {
        this.Type = category;
        this.Date = date;
        this.Price = price;
        net -= price;
        if (purchases == null) {
            purchases = FXCollections.observableArrayList();
            _first = date;
        }
        purchases.add(this);
        _last = date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public int compareTo(Purchase o) {
        if (getDate() == null || o.getDate() == null) {
            return 0;
        }
        return getDate().compareTo(o.getDate());
    }

    public static List<Purchase> datesAfter(LocalDate date) {
        List<Purchase> after = new ArrayList<>();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if (purchase.getDate().isAfter(date) || purchase.getDate().isEqual(date)) {
                    after.add(purchase);
                }
            }
        }
        return after;
    }

    public static List<Purchase> datesBetween(LocalDate after, LocalDate before) {
        List<Purchase> between = new ArrayList<>();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if (purchase.getDate().isAfter(after) || purchase.getDate().isEqual(after)) {
                    if (purchase.getDate().isBefore(before)) {
                        between.add(purchase);
                    }

                }
            }
        }
        return between;
    }
}
