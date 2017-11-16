/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prtype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import prtype.DBconnection;

public class Order {
    private 
        int OrderID;
        String CustomerName;
        String ContactNumber;
        String NoG;
        String Address;
        String Description;
        String Deposit;
        String Due;
        String PaymentStatus;

    public String getAddress() {
        return Address;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getDeposit() {
        return Deposit;
    }

    public String getDescription() {
        return Description;
    }

    public String getDue() {
        return Due;
    }

    public String getNoG() {
        return NoG;
    }

    public int getOrderID() {
        return OrderID;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    
    public String getContactNumber() {
        return ContactNumber;
    }
    
public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setDeposit(String Deposit) {
        this.Deposit = Deposit;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDue(String Due) {
        this.Due = Due;
    }

    public void setNoG(String NoG) {
        this.NoG = NoG;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }    
        
    public
         Order(){
               
             
             

         }
    public void AddOrder(String CustomerName,String ContactNumber,String NoG,String Address,String Description,String Deposit,String Due,String PaymentStatus) throws SQLException    {
        
        PreparedStatement pst = null;
        Connection con = null;
        con = DBconnection.connect();
        
        String Sq = "insert into order(CustomerName,CustomerNumber,NumberOfGuests,Address,Description,Deposit,Due,PaymentStatus) values (CustomerName,ContactNumber,NoG,Address,Description,Deposit,Due,PaymentStatus)";
        pst=con.prepareStatement(Sq);
        pst.execute();
    
    }     

    public void AddOrder(String name, String cnumber, String nog, String address, String description, String deposit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
             
         };
         
        
        
        
        
    
    
    
    

