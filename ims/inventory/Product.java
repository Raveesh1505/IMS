package ims.inventory; 
import ims.inventory.*;


public class Product {
    private String Name;
    public boolean Availability;
    private Double price;
    protected int ProductQuantity = 0;
    protected int ProductId = 1;
    
    public Product(String Name, Double price, int qty)
    {
        this.price = price;
        this.Name = Name;
        ProductQuantity = qty;
        Availability = true;
    }
    
    public String GetName()
    {
        return Name;
    }
    
    public double GetPrice()
    {
        return price;
    }
    
    public int GetID()
    {
        return ProductId;
    }
    
    public boolean GetAvailability()
    {
        if (ProductQuantity > 10){
            Availability = true;
        }
        else{
            Availability = false;
        }
        return Availability;
    }
        
    
    public int getQuantity(){
        if (ProductQuantity ==0) {
            Availability = false;  
        }
        return ProductQuantity;
    }
}