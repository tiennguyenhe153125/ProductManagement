

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void menu() {
        System.out.println("Main menu:\n"
                + "1.   Add Storekeeper\n"
                + "2.   Add product\n"
                + "3.   Update product\n"
                + "4.   Search product by Name, Category, Storekeeper, ReceiptDate\n"
                + "5.   Sort product by Date of manufacture, Expiry date\n"
                + "6.   Exit");
    }
    
//    public static void data() {
//        Storekeeper s1 = new Storekeeper("Tien", 3);
//        Storekeeper s2 = new Storekeeper("Loan", 2);
//        Storekeeper s3 = new Storekeeper("Huyen", 1);
//        Manager.storekeepers.add(s1);
//        Manager.storekeepers.add(s2);
//        Manager.storekeepers.add(s3);
//        
////        try {
//            Product p1 = new Product(1, "Banana", "NA", 10, "fruit", /*Manager.SDF.parse(*/"30-6-2021"/*)*/, /*Manager.SDF.parse(*/"25-5-2021"/*)*/, /*Manager.SDF.parse(*/"24-6-2021"/*)*/, 1);
//            Product p2 = new Product(4, "Orange", "HN", 5, "fruit", /*Manager.SDF.parse(*/"30-7-2021"/*)*/, /*Manager.SDF.parse(*/"24-4-2021"/*)*/, /*Manager.SDF.parse(*/"27-4-2021"/*)*/, 3);
//            Product p3 = new Product(2, "Beef", "SG", 40, "meat", /*Manager.SDF.parse(*/"10-9-2021"/*)*/, /*Manager.SDF.parse(*/"27-5-2021"/*)*/, /*Manager.SDF.parse(*/"23-8-2021"/*)*/, 2);
//            Manager.products.add(p1);
//            Manager.products.add(p2);
//            Manager.products.add(p3);
////        } catch (ParseException ex) {
////            System.out.println("Error");
////        }
//    }
    
    public static void main(String[] args) {
        Manager m = new Manager();
        Validate v = new Validate();
//        data();
        int op;
        do {
            menu();
            op = v.inputInt("Your option: ", "Please input integer in range [1-6]: ", 1, 6);
            switch (op) {
                case 1:
                    m.addStorekeeper();
                    break;
                case 2:
                    m.addProduct();
                    break;
                case 3:
                    m.update();
                    break;
                case 4:
                    m.searchProduct();
                    break;
                case 5:
                    m.sort();
                    break;
                case 6:
//                    m.displayProduct(Manager.products);
                    break;
//                case 7:
//                    m.deleteStorekeeper();
//                    break;
            }
        } while (op != 6);
    }
    
}
