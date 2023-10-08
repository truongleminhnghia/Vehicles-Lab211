package TheVehicleManagement;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FileIOManager {
    private static final String FILE_NAME = "vehicle.txt"; // Tên tệp văn bản

    public static void writeDataToFile(List<Vehicle> vehicles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
            System.out.println("Data saved to file: " + FILE_NAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> readDataFromFile() {
    List<Vehicle> vehicles = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Phân tích từng dòng để tạo đối tượng Vehicle và thêm vào danh sách
            String[] parts = line.split(",");
            if (parts.length == 7) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                String color = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                String brand = parts[4].trim();
                String type = parts[5].trim();
                int productYear = Integer.parseInt(parts[6].trim());

                Vehicle vehicle = new Vehicle(id, name, color, price, brand, type, productYear);
                vehicles.add(vehicle);
            }
        }
        System.out.println("Data loaded from file: " + FILE_NAME);

    } catch (IOException | DateTimeParseException e) {
        e.printStackTrace();
    }
    return vehicles;
}
}