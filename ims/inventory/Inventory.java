package ims.inventory;
import ims.inventory.*;

import java.io.FileReader;
import java.io.File;
import java.io.*;
import java.nio.*;
import java.util.*;


public class Inventory {
    private String ProductName;
    private int ProductQuantity;
    
    
    public Inventory() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Product name");
        String name = input.next();
        ProductName = name;
        System.out.println("Enter price");
        double price = input.nextDouble();
        System.out.println("Enter quantity: ");
        int qty = input.nextInt();
        Product p = new Product(ProductName, price, qty);
        System.out.println("New Product Added");
    
        String insertLines = p.GetName()+";" + p.GetPrice()+";" + p.ProductQuantity + ";" + p.Availability+";\n";
        
        try{
            File file = new File("Products.txt");
            FileWriter writter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writter);
            bw.write(insertLines);
            bw.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}


class showInventory{
    showInventory() throws FileNotFoundException{

        File file = new File("Products.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
       }
       sc.close();
    }


    public static void showOrder(String PID) throws FileNotFoundException{
        File file = new File("Products.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String lines = sc.nextLine();
            String[] b = lines.split(";");

            if (b[0] == PID){
                System.out.println(b);
            }
        }
    }
}
