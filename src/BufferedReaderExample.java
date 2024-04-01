import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
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
                double price = Double.parseDouble(elements[3]);

                System.out.println("ID: " + id);
                System.out.println("Item Name: " + itemName);
                System.out.println("Quantity: " + quantity);
                System.out.println("Price: " + price);

                totalPrice += Double.parseDouble(quantity) * price;

                System.out.println();
            }

            System.out.println("Total Price: " + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
