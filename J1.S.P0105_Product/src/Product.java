

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Product {
//    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    
    private int id;
    private String name;
    private String location;
    private double price;
    private String category;
    private String dateOfManufacture, expiryDate, receiptDate;
    private int storekeeperId;

    public Product() {
    }

    public Product(int id, String name, String location, double price, String category, String expiryDate, String dateOfManufacture, String receiptDate, int storekeeperId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.category = category;
        this.dateOfManufacture = dateOfManufacture;
        this.expiryDate = expiryDate;
        this.receiptDate = receiptDate;
        this.storekeeperId = storekeeperId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(int storekeeperId) {
        this.storekeeperId = storekeeperId;
    }
    
//    public void display() {
//        
//        System.out.printf("%-10d|%-10s|%-10s|%-10.1f|%-10s|%-20s|%-20s|%-20s|%-20s\n",
//                id, name, location, price, category, SDF.format(dateOfManufacture), 
//                SDF.format(expiryDate), SDF.format(receiptDate), storekeeperId);
//    }
}
