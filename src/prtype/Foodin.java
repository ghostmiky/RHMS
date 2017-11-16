
package prtype;


public class Foodin {
    int ItemId;
    String Name;
    double Needed;
    double OnHand;
    double LefttoBuy;
    int SupplierID;
    
    
    
    public String getName() {
        return Name;
    }

    public int getItemId() {
        return ItemId;
    }

    public double getLefttoBuy() {
        return LefttoBuy;
    }

    public double getNeeded() {
        return Needed;
    }

    public double getOnHand() {
        return OnHand;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public void setLefttoBuy(double LefttoBuy) {
        this.LefttoBuy = LefttoBuy;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNeeded(double Needed) {
        this.Needed = Needed;
    }

    public void setOnHand(double OnHand) {
        this.OnHand = OnHand;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }
    
    
}
