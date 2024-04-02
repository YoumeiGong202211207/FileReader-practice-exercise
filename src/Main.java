import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws Exception {

        String filePathForMac = "C:\\Users\\GYM\\Desktop\\PROG-2-2024\\FileReader practice exercise\\Groceries.txt";
        String fileToWrite = "C:\\Users\\GYM\\Desktop\\PROG-2-2024\\FileReader practice exercise\\GroceriesFormatted.txt";


        String[] array = new String[4];

        double price;
        String separator = ",";
        double total = 0;

        FileReader fileReader = new FileReader(filePathForMac);
        FileWriter fileWriter = new FileWriter(fileToWrite);

        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write("****************************************" + "\n");
        writer.write("ID#"+"\t"+"Item"+"\t"+"Quantity"+"\t"+"Price(€)" +"\t"+ "\n");
        String line;

        while ((line = reader.readLine()) != null) {

            array = line.split(separator);

            price = Double.parseDouble(array[3]);

            String id = array[0];
            String itemName = array[1];
            String quantity = array[2];
            total += price;

            System.out.println(line);
            writer.write(id + "\t" + itemName + "\t" + quantity + "\t" + price );
            writer.newLine();

        }
        writer.write("****************************************");
        System.out.println("\n" + "Total price of groceries: " + Math.round(total));
        writer.write("\n" + "Total price of groceries: " + Math.round(total));
        writer.write("\n" + "****************************************");

        reader.close();

        writer.flush();
        writer.close();
    }
}
