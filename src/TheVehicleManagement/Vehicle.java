package TheVehicleManagement;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Vehicle implements Serializable {
    private static int idCounter = 1;
    private String id;
    private String name;
    private String color;
    private double price;
    private String brand;
    private String type;
    private int productYear;

    public Vehicle() {

    }

    public Vehicle(String id, String name, String color, double price, String brand, String type, int productYear) {
        this.id = "V" + String.format("%07d", idCounter++);
        this.setName(name);
        this.setColor(color);
        this.setPrice(price);
        this.setBrand(brand);
        this.setType(type);
        this.setProductYear(productYear);
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Vehicle.idCounter = idCounter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.isEmpty()) {
            String[] cutName = name.split(" ");
            String formatter = " ";
            for (String string : cutName) {
                if(!string.isEmpty()) {
                    formatter += string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase() + " ";
                }
            }
            this.name = formatter;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(!color.isEmpty()) {
            this.color = color.toUpperCase();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if( price >= 0) {
            this.price = price;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
    if(!brand.isEmpty()) {
        this.brand = brand.toUpperCase();
    }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(!type.isEmpty()) {
            this.type = type.toUpperCase();
        }
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return id + ", " + name + ", " + color + ", " + price + ", " + brand + ", " + type + ", "
                + productYear;
    }
}
