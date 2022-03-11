
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Manager {

    Validate v = new Validate();
    static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    static final ArrayList<Product> products = new ArrayList<>();
    static final ArrayList<Storekeeper> storekeepers = new ArrayList<>();

    //FUCNT 1
    public void addStorekeeper() {
        String name = v.inputString("[a-zA-Z ]+", "Storekeeper name: ", "Re-input");
        int id = 1;
        if (!storekeepers.isEmpty()) {
            id = storekeepers.get(storekeepers.size() - 1).getId() + 1;
        }
        storekeepers.add(new Storekeeper(name, id));
        System.out.println("Storekeeper added successful");
        System.out.println("List storekeeper:");
        displayStorekeeper(storekeepers);
    }

//    public void deleteStorekeeper() {
//        if (storekeepers.isEmpty()) {
//            System.out.println("List storekeeper is empty");
//            return;
//        }
//        System.out.println("---------Del Storekeeper------");
//        int idDel = v.inputInt("ID: ", "ID invalid. Re-input", 1, Integer.MAX_VALUE);
//        boolean isExsist = false; //Check whether ID exist or not
//        for (Storekeeper storekeeper : storekeepers) {
//            if (storekeeper.getId() == idDel) {
//                storekeepers.remove(storekeeper);
//                isExsist = true;
//                System.out.println("Storekeeper deleted!");
//                break;
//            }
//        }
//        
//        if (!isExsist) {
//            System.out.println("ID not found");
//        }
//    }
    
    //FUNCT 2
    public void addProduct() {
        if (storekeepers.isEmpty()) {
            System.out.println("Storekeeper list is empty. Add failed!");
            return;
        }
        int id;
        while (true) {
            id = v.inputInt("ID: ", "Re-input", 1, Integer.MAX_VALUE);
            if (getProductId(id) != null) {
                System.out.println("This ID is already exist. Try again");
                continue;
            }
            break;
        }
        String name = v.inputString("[a-zA-Z ]+", "Name: ", "Re-input");
        String location = v.inputString("[a-zA-Z0-9 ]+", "Location: ", "Re-input");
        double price = v.inputDouble("Price: ", "Re-input", 0, Double.POSITIVE_INFINITY);
        String category = v.inputString("[a-zA-Z ]+", "Category: ", "Re-input");
        String manuDate = v.inputDate("Date of manufacture: ", "Re-input", "dd-MM-yyyy");
        String exDate;
        while (true) {
            try {
                exDate = v.inputDate("Expiry date: ", "Re-input", "dd-MM-yyyy");
                if (SDF.parse(exDate).before(SDF.parse(manuDate))) {
                    System.out.println("Expiry date must come after manufacture date");
                    continue;
                }
                break;
            } catch (ParseException ex) {
            }
        }
        String receiptDate;
        while (true) {
            try {
                receiptDate = v.inputDate("Receipt Date: ", "Re-input", "dd-MM-yyyy");
                if (SDF.parse(receiptDate).before(SDF.parse(manuDate))) {
                    System.out.println("Receipt date must come after Manufacture date");
                    continue;
                }
                break;
            } catch (ParseException ex) {
            }
        }
        int storekeeperId;
        Storekeeper found;
        while (true) {
            System.out.println("List storekeeper:");
            displayStorekeeper(storekeepers);
            storekeeperId = v.inputInt("Please choose storekeeper ID: ", "Re-input", 1, Integer.MAX_VALUE);
            found = getStorekeeperId(storekeeperId);
            if (found == null) {
                System.out.println("This ID doesn't exist. Try again");
                continue;
            }
            break;
        }
        products.add(new Product(id, name, location, price, category, exDate, manuDate, receiptDate, storekeeperId));
        System.out.println("Product added successful");
        System.out.println("\nList after add:");
        displayProduct(products);
        System.out.println();
    }

    public Product getProductId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Storekeeper getStorekeeperId(int id) {
        for (Storekeeper storekeeper : storekeepers) {
            if (storekeeper.getId() == id) {
                return storekeeper;
            }
        }
        return null;
    }

    //FUNCT 3
    public void update() {
        if (products.isEmpty()) {
            System.out.println("Product list is empty. Update failed!");
            return;
        }
        int idU;
        Product p;
        while (true) {
            idU = v.inputInt("ID: ", "Re-input", 1, Integer.MAX_VALUE);
            p = getProductId(idU);
            if (p == null) {
                System.out.println("This ID doesn't exist. Try again");
                continue;
            }
            break;
        }
        String nameU = v.inputString("[a-zA-Z ]+", "Name: ", "Re-input");
        String locationU = v.inputString("[a-zA-Z0-9 ]+", "Location: ", "Re-input");
        double priceU = v.inputDouble("Price: ", "Re-input", 0, Double.POSITIVE_INFINITY);
        String categoryU = v.inputString("[a-zA-Z ]+", "Category: ", "Re-input");
        String manuDateU = v.inputDate("Date of manufacture: ", "Re-input", "dd-MM-yyyy");
        String exDateU;
        while (true) {
            try {
                exDateU = v.inputDate("Expiry date: ", "Re-input", "dd-MM-yyyy");
                if (SDF.parse(exDateU).before(SDF.parse(manuDateU))) {
                    System.out.println("Expiry date must come after manufacture date");
                    continue;
                }
                break;
            } catch (ParseException ex) {
            }
        }
        String receiptDateU;
        while (true) {
            try {
                receiptDateU = v.inputDate("Receipt Date: ", "Re-input", "dd-MM-yyyy");
                if (SDF.parse(receiptDateU).before(SDF.parse(manuDateU))) {
                    System.out.println("Receipt date must come after Manufacture date");
                    continue;
                }
                break;
            } catch (ParseException ex) {
            }
        }
        int storekeeperIdU;
        Storekeeper found;
        while (true) {
            System.out.println("List storekeeper:");
            displayStorekeeper(storekeepers);
            storekeeperIdU = v.inputInt("Please choose storekeeper ID: ", "Re-input", 1, Integer.MAX_VALUE);
            found = getStorekeeperId(storekeeperIdU);
            if (found == null) {
                System.out.println("This ID doesn't exist. Try again");
                continue;
            }
            break;
        }
        p.setName(nameU);
        p.setLocation(locationU);
        p.setPrice(priceU);
        p.setCategory(categoryU);
        p.setDateOfManufacture(manuDateU);
        p.setExpiryDate(exDateU);
        p.setReceiptDate(receiptDateU);
        p.setStorekeeperId(storekeeperIdU);

        System.out.println("Update successful");
        System.out.println("\nList after update:");
        displayProduct(products);
        System.out.println();
    }

    //FUNCT 4
    public void searchProduct() {
        if (products.isEmpty()) {
            System.out.println("Product list is empty. Search failed!");
            return;
        }
        searchMenu();
        int opt = v.inputInt("You choose: ", "Must be integer in range [1-4]", 1, 4);
        ArrayList<Product> result = new ArrayList<>();
        switch (opt) {
            case 1:
                String name = v.inputString("[a-zA-Z ]+", "Search for Name: ", "re-input");
                getProductBy(name, result, opt);
                break;
            case 2:
                String category = v.inputString("[a-zA-Z ]+", "Search for Category: ", "Re-input");
                getProductBy(category, result, opt);
                break;
            case 3:
                String id = v.inputString("[0-9]+", "Search for ID: ", "Re-input");
                getProductBy(id, result, opt);
                break;
            case 4:
                String receipt = v.inputDate("Search for Receipt date: ", "Re-input", "dd-MM-yyyy");
                getProductBy(receipt, result, opt);
                break;
        }
        if (result.isEmpty()) {
            System.out.println("No match result");
            return;
        }
        System.out.println("\nList product found:");
        displayProduct(result);
        System.out.println();
    }

    public void searchMenu() {
        System.out.println("Search by:\n"
                + "1.   Name\n"
                + "2.   Category\n"
                + "3.   Storekeeper\n"
                + "4.   Receipt date");
    }

    public void getProductBy(String text, ArrayList<Product> lf, int opt) {
        if (products.isEmpty()) {
            System.out.println("List product is empty");
            return;
        }
        for (Product product : products) {
            switch (opt) {
                case 1:
                    if (product.getName().equalsIgnoreCase(text)) {
                        lf.add(product);
                    }
                    break;
                case 2:
                    if (product.getCategory().equalsIgnoreCase(text)) {
                        lf.add(product);
                    }
                    break;
                case 3:
                    if (product.getStorekeeperId() == Integer.parseInt(text)) {
                        lf.add(product);
                    }
                    break;
                default: {
                    while (true) {
                        if (product.getReceiptDate().equals(text)) {
                            lf.add(product);
                        }
                        break;
                    }
                }
                break;
            }
        }

    }

    public void displayProduct(ArrayList<Product> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.printf("%-10s|%-10s|%-10s|%-10s|%-10s|%-20s|%-20s|%-20s|%-20s\n",
                "ID", "Name", "Location", "Price", "Category", "Date of manufacture", "Expiry date",
                "Receipt date", "Storekeeper");
        for (Product product : list) {
            System.out.printf("%-10d|%-10s|%-10s|%-10.1f|%-10s|%-20s|%-20s|%-20s|%-20s\n",
                    product.getId(), product.getName(), product.getLocation(), product.getPrice(), product.getCategory(), product.getDateOfManufacture(),
                    product.getExpiryDate(), product.getReceiptDate(), storekeepers.get(product.getStorekeeperId() - 1).getName());
        }
    }

    public void displayStorekeeper(ArrayList<Storekeeper> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.printf("%-5s|%-20s\n", "ID", "Name");
        for (Storekeeper storekeeper : list) {
            storekeeper.display();
            System.out.println();
        }
    }

    //FUNCT 5
    public void sort() {
        if (products.isEmpty()) {
            System.out.println("List product is empty. Sort failed!");
            return;
        }
        sortMenu();
        int opt = v.inputInt("You choose: ", "Must be integer in range [1-2]", 1, 2);
//        switch (opt) {
//            case 1:
//                Collections.sort(products, new Comparator<Product>() {
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        try {
//                            return SDF.parse(o1.getDateOfManufacture()).compareTo(SDF.parse(o2.getDateOfManufacture()));
//                        } catch (ParseException ex) {
//                        }
//                        return 0;
//                    }
//                });
//                break;
//            case 2:
//                Collections.sort(products, new Comparator<Product>() {
//                    @Override
//                    public int compare(Product o1, Product o2) {
//                        try {
//                            return SDF.parse(o1.getExpiryDate()).compareTo(SDF.parse(o2.getExpiryDate()));
//                        } catch (ParseException ex) {
//                        }
//                        return 0;
//                    }
//                });
//                break;
//        }

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                switch(opt) {
                    case 1:
                        try {
                            return SDF.parse(o1.getDateOfManufacture()).compareTo(SDF.parse(o2.getDateOfManufacture()));
                        } catch (ParseException ex) {
                        }
                        break;
                    case 2:
                        try {
                            return SDF.parse(o1.getExpiryDate()).compareTo(SDF.parse(o2.getExpiryDate()));
                        } catch (ParseException ex) {
                        }
                        break;
                }
                return 0;
            }
        });

        System.out.println("\nList after sort:");
        displayProduct(products);
        System.out.println();
    }

    public void sortMenu() {
        System.out.println("Sort by:\n"
                + "1.   Date of manufacture\n"
                + "2.   Expiry date");
    }
}
