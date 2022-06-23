package ims.inventory;
import ims.inventory.*;

import java.io.*;
import java.nio.*;
import java.util.*;

import javax.xml.transform.Source;

import java.lang.*;


public class OfflineECommerce {

    public static void main(String[] args) throws IOException {
        int userID = 0;
        String Password = "";
        int exitInput = 1;
        
        Scanner sc = new Scanner(System.in);

        while (exitInput == 1){            
            System.out.println("\n===== WELCOME TO INVENTORY MANAGEMENT SYSTEM =====\n");

            System.out.println("1. Log in\n2. Create new account\n3. Exit\nYour choice:");
            int userInput = sc.nextInt();

            if (userInput == 1){
                System.out.println("\n ------------------------------- \n1. Administrator\n2. User\nYour choice : ");
                int auInput = sc.nextInt();

                // Administrator login
                if (auInput == 1){
                    System.out.println("\n-------------------------------");
                    System.out.print("Enter userId : ");
                    userID = sc.nextInt();
                    System.out.print("Enter password : ");
                    Password = sc.next();
            
                    while ((Administrator.LogIn(userID, Password)) != true){
                        System.out.println("\nInvalid input. Please try again.\n");
                        System.out.println("Enter userId: ");
                        userID = sc.nextInt();
                        System.out.println("Enter password: ");
                        Password = sc.next();
                    }

                    if (Administrator.LogIn(userID, Password) == true){
                        System.out.println("\n-------------------------------");
                        System.out.println("\n1. Enter a new product\n2. View inventory\nYour choice : ");

                        int adminChoice = sc.nextInt();

                        if (adminChoice == 1){
                            Inventory i = new Inventory();
                        }
                        else if (adminChoice == 2){
                            showInventory s = new showInventory();
                        }
                    }

                    System.out.print("Press 1 to continue and 0 to exit : ");
                    exitInput = sc.nextInt();
                }

                // User login
                if (auInput == 2){
                    System.out.println("\n-------------------------------");
                    System.out.print("Enter userId : ");
                    userID = sc.nextInt();
                    System.out.print("Enter password : ");
                    Password = sc.next();
            
                    while ((Customer.LogIn(userID, Password)) != true){
                        System.out.println("\nInvalid input. Please try again.\n");
                        System.out.println("Enter userId: ");
                        userID = sc.nextInt();
                        System.out.println("Enter password: ");
                        Password = sc.next();
                    }

                    if (Customer.LogIn(userID, Password) == true){
                        System.out.println("===== WELCOME TO E-COMMERCE =====\n");
                        System.out.print("1. View inventory\n2. Place order\nYour choice : ");
                        System.out.println("\n-------------------------------");
                        int userChoice = sc.nextInt();

                        if (userChoice == 1){
                            showInventory s = new showInventory();
                        }
                        else if (userChoice == 2){
                            System.out.println("Enter product ID: ");
                            int pID = sc.nextInt();

                            String tempPID = String.valueOf(pID);
                            showInventory.showOrder(tempPID);

                            System.out.print("\nEnter 1 to place the displayed order and 0 to exit : ");
                            int orderChoice = sc.nextInt();
                            if (orderChoice == 1){

                            }
                        }
                    }
                    System.out.print("Press 1 to continue and 0 to exit : ");
                    exitInput = sc.nextInt(); 
                }
            }

            // Create new account

            else if (userInput == 2){
                System.out.println("\n-------------------------------");
                System.out.println("Enter a numeric userID : ");
                int setID = sc.nextInt();
                System.out.println("Enter the password : ");
                String setPass = sc.next();
                String tempUID = String.valueOf(setID);

                User u = new Customer(tempUID, setPass);

                String insertDetails = u.UserID + "," + u.Password + ",\n";
                    
                try{
                    File file = new File("Customers.txt");
                    FileWriter writter = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(writter);
                    bw.write(insertDetails);
                    bw.close();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("\nUser Registered succesfully\n!!!");
                System.out.println("--------------------\n");
                System.out.print("Press 1 to continue and 0 to exit : ");
                exitInput = sc.nextInt();
            }

            // Exit
            else if (userInput == 3){
                System.exit(0);
            }
        }
    }
}