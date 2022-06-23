package ims.inventory;
import ims.inventory.*;


public abstract class User {
    
    protected String Name;
    protected String UserID;
    protected String Password;
    protected static Boolean valid = false;

    public static boolean LogIn(int UserID, String password){
        return valid;
    }
}