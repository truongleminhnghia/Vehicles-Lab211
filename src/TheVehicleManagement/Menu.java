 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheVehicleManagement;

import java.util.List;
import java.util.Scanner;
import Tools.MyTools;

/**
 *
 * @author Administrator
 */
public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int choice = 0;
        VehicleList listVehicle = new VehicleList();
        List<Vehicle> loadedData = FileIOManager.readDataFromFile();
        listVehicle.clear();
        listVehicle.addAll(loadedData);
        boolean change = false;
        do {

            System.out.println("----------Menu----------");
            System.out.println("1. Add new vehicle.");
            System.out.println("2. Check vehicle exist.");
            System.out.println("3. Update vehicle.");
            System.out.println("4. Delete vehicle.");
            System.out.println("5. Serach vehicle.");
            System.out.println("6. Display vehicle.");
            System.out.println("7. Save to file.");
            System.out.println("8. Print from file.");
            System.out.println("9. QUIT!");
            System.out.println();

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        listVehicle.addVehicle();
                        do {
                            System.out.print("If you want continue add new vehicle (Y/N): ");
                            scanner = new Scanner(System.in);
                            String op = scanner.nextLine();
                            if (op.equalsIgnoreCase("y")) {
                                listVehicle.addVehicle();
                            } else {
                                break;
                            }
                        } while (true);
                        change = true;
                        break;
                    case 2:
                        listVehicle.checkVehicleExxist();
                        change = true;
                        break;
                    case 3:
                        listVehicle.updateVehicle();
                        change = true;
                        break;
                    case 4:
                        listVehicle.deleteVehicle();
                        change = true;
                        break;
                    case 5:
                        listVehicle.subMenuSearch();
                        break;
                    case 6:
                        listVehicle.subMenuDisplay();
                        break;
                    case 7:
                        FileIOManager.writeDataToFile(listVehicle);
                        change = false;
                        break;
                    case 8:
                        listVehicle.subMenuPrint();
                        break;
                    default:
                        if (change){
                            boolean b = MyTools.readBoolean("Data changed. Save to file? Y/N");
                            if(b==true) {
                                FileIOManager.writeDataToFile(loadedData);
                            }
                        }
                        System.out.println("YOU EXITED!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice > 0 && choice < 9);
    }
}
