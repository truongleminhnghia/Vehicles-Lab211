package TheVehicleManagement;

import Tools.tool;
import Tools.MyTools;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VehicleList extends ArrayList<Vehicle> {

    public static final Scanner sc = new Scanner(System.in);

    // method find
    public Vehicle find(String id) {
        for (Vehicle vehicle : this) {
            if (vehicle.getId().equalsIgnoreCase(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle() throws ParseException {
        String name = MyTools.readStr("Enter name vehivle", "[aA-zZ ]+");
        String color = MyTools.readStr("Enter color vehicle", "[aA-zZ0-9#*]+");
        double price = tool.inputPrice("enter price vehicle");
        String brand = MyTools.readStr("Enter brand of vehicle", "[aA-zZ]+");
        String type = MyTools.readStr("Enter type of vehicle", "[aA-zZ]+");
        int productYear = Integer.parseInt(MyTools.readStr("Enter product Year", "[\\d{4}]+"));

        try {
            Vehicle newVehicle = new Vehicle(type, name, color, price, brand, type, productYear);
            if (newVehicle == null) {
                System.out.println("No add");
            } else {
                this.add(newVehicle);
                System.out.println("Added Successfull!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkVehicleExxist() {
        String idCheck = tool.inputStr("enter ID to check: ");

        Vehicle findCheck = find(idCheck);
        if (findCheck == null) {
            System.out.println("Not Found!");
            return false;
        } else {
            System.out.println("Existed Vehicle!");
            return true;
        }
    }

    public boolean updateVehicle() throws ParseException {
        String idUpdate = tool.inputStr("enter id to update: ");
        Vehicle findUpdate = find(idUpdate);
        if (findUpdate == null) {
            System.out.println("Not Found!");
            return false;
        } else {
            String nameUp = MyTools.inputStr("Update name: ");
            if (!nameUp.isEmpty()) {
                findUpdate.setName(nameUp);
            }
            String colorUp = MyTools.inputStr("Update color: ");
            if (!colorUp.isEmpty()) {
                findUpdate.setColor(colorUp);
            }
            double priceUp = tool.inputPrice("Update price vehicle");
            if (priceUp != 0) {
                findUpdate.setPrice(priceUp);
            }
            String brandUp = MyTools.inputStr("Update breand: ");
            if (!brandUp.isEmpty()) {
                findUpdate.setBrand(brandUp);
            }
            String type = MyTools.inputStr("Update type: ");
            if (!type.isEmpty()) {
                findUpdate.setType(type);
            }
            int productYear = Integer.parseInt(MyTools.inputStr("Update product year: "));
            if (productYear == 0.0) {
                try {
                    findUpdate.setProductYear(productYear);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Updated SuccessFull!");
            System.out.println();
            System.out.println(findUpdate.toString());
            return true;
        }
    }

    public void deleteVehicle() {
        String idDele = tool.inputStr("enter id to delete: ");

        Iterator<Vehicle> iterator = this.iterator(); // lặp qa các vehiclelist
        while (iterator.hasNext()) { // kiểm tra xem còn các phần tử trong danh sách để lặp qa hay không.
            Vehicle vehicle = iterator.next(); // lấy phần tử tiếp theo và gán cho ve..
            if (vehicle.getId().equalsIgnoreCase(idDele)) {
                System.out.println("Information Vehicle find by id: " + idDele);
                String option = tool.inputStr("are you sure (Y/N)?");
                if (option.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("Deleted ID " + idDele + " successfull!");
                } else {
                    System.out.println("No delete!");
                }
            } else {
                System.out.println("Not Found!");
            }
        }
    }

    public List<Vehicle> searchByName() {
        String nameSearch = tool.inputStr("enter name to search: ");
        return this.stream() // chuyển đỏi danh sách các xe thành môut luộng stream.
                // xử lý trên các đối tượng trong danh sách.
                .filter(vehicle -> vehicle.getName().contains(nameSearch))
                // filter: lọc các đối tượng dựa trên một điều kiện.
                .sorted(Comparator.comparing(Vehicle::getName).reversed()).collect(Collectors.toList());
        // sắp xếp đảo ngược từ A-Z to Z-A.
    }

    public void displayAllVehicles() {
        for (Vehicle vehicle : this) {
            System.out.println(vehicle);
        }
    }

    public List<Vehicle> displayVehicleByPrice() {
        double maxPrice = tool.inputPrice("enter price to display");
        return this.stream()
                .filter(vehicle -> vehicle.getPrice() <= maxPrice)
                .sorted(Comparator.comparing(Vehicle::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Vehicle> dislpayByYear() {
        int productYear =  Integer.parseInt(MyTools.readStr("Enter Year To Print", "\\d{4}"));
        return this.stream()
                .filter(vehicle -> vehicle.getProductYear() >= productYear)
                .sorted(Comparator.comparing(Vehicle::getProductYear).reversed())
                .collect(Collectors.toList());
    }

    // subMenu
    public void subMenuSearch() {
        int choice = 0;
        do {
            System.out.println("Search Vehicle: ");
            System.out.println("1. Search by name.");
            System.out.println("2. Search by id");
            System.out.println("3. QUIT!");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Vehicle> vehicleSearch = searchByName();
                    if (!vehicleSearch.isEmpty()) {
                        System.out.println("Result vehicle fount by name: ");
                        for (Vehicle vehicle : vehicleSearch) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 2:
                    String idFind = tool.inputStr("enter id to find: ");
                    Vehicle findSearch = find(idFind);
                    if (findSearch == null) {
                        System.out.println("Not Found!");
                    } else {
                        System.out.println("Vehicle Found by Id: " + idFind);
                        System.out.println(findSearch.toString());
                    }
                default:
                    System.out.println("Exited!");
                    break;
            }
        } while (choice > 0 && choice <= 2);
    }

    public void subMenuPrint() {
        int choice = 0;
        do {
            System.out.println("Print Vehicle: ");
            System.out.println("1. Print All Vehicle in File");
            System.out.println("2. Print By Year.");
            System.out.println("3. QUIT!");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    List<Vehicle> showPrice = dislpayByYear();
                    if (!showPrice.isEmpty()) {
                        System.out.println("Result vehicle fount by year: ");
                        for (Vehicle vehicle : showPrice) {
                            System.out.println(vehicle);
                        }
                    }
                default:
                    System.out.println("Exited!");
                    break;
            }
        } while (choice > 0 && choice <= 2);
    }

    public void subMenuDisplay() {
        int choice = 0;
        do {
            System.out.println("Display Vehicle: ");
            System.out.println("1. Show All Vehicle.");
            System.out.println("2. Show By Price.");
            System.out.println("3. QUIT!");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAllVehicles();
                    break;
                case 2:
                    List<Vehicle> printByYear = displayVehicleByPrice();
                    if (!printByYear.isEmpty()) {
                        System.out.println("Result vehicle fount by price: ");
                        for (Vehicle vehicle : printByYear) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                default:
                    System.out.println("Exited!");
                    break;
            }
        } while (choice > 0 && choice <= 2);
    }
}
