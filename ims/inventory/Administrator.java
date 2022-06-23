package ims.inventory;
import ims.inventory.*;


public class Administrator extends User {
    
    protected static final int AdminID = 12345;
    protected static final String Password = "admin";
    

    public static boolean LogIn(int UserID, String Password) 
    {
        if (UserID == AdminID)
        {
            if (Password.equals(Administrator.Password))
            {
                valid = true;
            }
            else 
            {
                valid = false;
            }
        }
        return valid;
    }
    
}
