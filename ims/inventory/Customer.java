package ims.inventory;
import ims.inventory.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer extends User {
    
    int CustomerID = 20000;
    
    Customer(String setUID, String setPass) 
    {
        CustomerID = CustomerID + 1;
        this.Password = setPass;
        this.UserID = setUID;
    }

    public static boolean LogIn (int UserID, String Password){

        String userID = String.valueOf(UserID);
        Boolean valid = false;
        try{    
            File file = new File ("Customers.txt");
            Scanner sc = new Scanner(file);
            String line = sc.nextLine();
            while (sc.hasNextLine()){
                String[] tokens = line.split(",");
                if (userID.equals(tokens[0])){
                    if (Password.equals(tokens[1])){
                        valid = true;
                        break;
                    }
                }
            }
            System.out.println("Log in Succesfull!!!\n");
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return valid;
    }
}