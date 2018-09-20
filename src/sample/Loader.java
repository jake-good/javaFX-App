package sample;

import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loader {

    public void save(ObservableList<Purchase> purchases) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("num.txt"), "utf-8"))) {
            for (Purchase purchase : purchases) {
                writer.write(purchase.getType() + " " + purchase.getDate() + " " + purchase.getPrice() + "\r\n");
            }
        } catch (FileNotFoundException e) {

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() throws IOException {
        File file = new File("num.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String[] temp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

        while ((st = br.readLine()) != null) {
            temp = st.split(" ");
            String date = temp[1];
            LocalDate localDate = LocalDate.parse(date);
            new Purchase(temp[0], localDate, Double.valueOf(temp[2]));
        }
    }
}


