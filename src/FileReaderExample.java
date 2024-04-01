import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "Groceries.txt";

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            double totalPrice = 0.0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(",");

                String id = elements[0];
                String itemName = elements[1];
                String quantity = elements[2];
                String priceString = elements[3].replaceAll("[^\\d.]", ""); // Remove non-numeric characters
                double price = Double.parseDouble(priceString);

                System.out.println("ID: " + id);
                System.out.println("Item Name: " + itemName);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: " + price);

                double quantityValue = extractQuantityValue(quantity);
                totalPrice += quantityValue * price;

                System.out.println();
            }

            System.out.println("Total Price: " + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double extractQuantityValue(String quantity) {
        String quantityString = quantity.replaceAll("[^\\d.]", ""); // Remove non-numeric characters
        return Double.parseDouble(quantityString);
    }
}
