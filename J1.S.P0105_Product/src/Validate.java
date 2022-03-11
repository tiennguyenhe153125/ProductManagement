
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Validate {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    public int inputInt (String msg, String err, int min, int max) {
        int num = 0;
        do {            
            try {
                System.out.print(msg);
                num = Integer.parseInt(bf.readLine());
                if (num >= min && num <= max) {
                    break;
                }
                System.out.println(err);
            } catch (Exception ex) {
                System.out.println(err);
            }
        } while(true);
        return num;
    }
    
    public String inputString (String regex, String msg, String err) {
        String value = "";
        boolean check = true;
        do {
            try {
                check = true;
                System.out.print(msg);
                value = bf.readLine().trim();
                if (!value.matches(regex)) {
                    System.out.println(err);
                    check = false;
                }
                
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (!check);
        return value;
    }
    
    public double inputDouble (String msg, String err, double min, double max) {
        double num = 0;
        do {            
            System.out.print(msg);
            try {
                num = Double.parseDouble(bf.readLine());
                if (num >= min && num <= max) {
                    break;
                }
                System.out.println(err);
                
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
        return num;
    }
    
//    public Date inputDate (String msg, String err, String format) {
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        Date date = null;
//        sdf.setLenient(false);
//        do {    
//            System.out.print(msg);
//            try {
//                String value = bf.readLine();
//                date = sdf.parse(value);
////                Date now = new Date();
////                if (date.after(now)) {
////                    System.out.println(err);
////                    continue;
////                }
//                break;
//            } catch (Exception ex) {
//                System.out.println(err);
//            } 
//            
//        } while (true);
//        return date;
//    }
    
    public String inputDate (String msg, String err, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        String value = "";
        sdf.setLenient(false); //Check Date-parsing
        do {     
            System.out.print(msg);
            try {
                value = bf.readLine();
                date = sdf.parse(value);
//                Date now = new Date();
//                if (date.after(now)) {
//                    System.out.println(err);
//                    continue;
//                }
                break;
            } catch (IOException | ParseException ex) {
                System.out.println(err);
            }
            
        } while (true);
        return value;
    }
}
