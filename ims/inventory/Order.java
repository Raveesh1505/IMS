package ims.inventory;
import ims.inventory.*;

public class Order {
    
    protected int OrderID = 000000;
    private String UserID;
    private double TotalAmount;
    private String ShippingAddress;
    private Product Ordered;
    
    
    public Order(String UserID, Product Ordered, double Amount, String Address)
    {
        OrderID = OrderID + 1;
        this.UserID = UserID;
        this.ShippingAddress = Address;
        this.TotalAmount = Amount;
        this.Ordered = Ordered;
    }
    
    public String ViewOrder(int OrderID) 
    {      
        return "Order ID: " + OrderID +"User ID: " + UserID + "Product ID: " + Ordered.GetID() + "Product Name: " + Ordered.GetName() + "Product Price: " + Ordered.GetPrice() + "Address: " + ShippingAddress;
    }
}