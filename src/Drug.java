//{
//        "productID": 0,
//        "productName": "name0",
//        "owner": "ownername0",
//        "previousOwner": "prevownername0",
//        "quantity": 10,
//        "pricePerUnit": 15,
//        "totalPrice": 100
//        }


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Drug {
    private final IntegerProperty productID;
    private final StringProperty productName;
    private final StringProperty owner;
    private final StringProperty previousOwner;
    private final IntegerProperty quantity;
    private final IntegerProperty pricePerUnit;
    private final IntegerProperty totalPrice;
    private StringProperty ID;

    public Drug(Long productID, String productName, String owner, String previousOwner, Long quantity, Long pricePerUnit, Long totalPrice) {
        this.productID = new SimpleIntegerProperty(productID.intValue());
        this.productName = new SimpleStringProperty(productName);
        this.owner = new SimpleStringProperty(owner);
        this.previousOwner = new SimpleStringProperty(previousOwner);
        this.quantity = new SimpleIntegerProperty(quantity.intValue());
        this.pricePerUnit = new SimpleIntegerProperty(pricePerUnit.intValue());
        this.totalPrice = new SimpleIntegerProperty(totalPrice.intValue());
    }
    
    public String getID() {
    	return productID.get() + "";
    }

    public int getProductID() {
        return productID.get();
    }

    public IntegerProperty productIDProperty() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID.set(productID);
    }

    public String getProductName() {
        return productName.get();
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getOwner() {
        return owner.get();
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner.set(owner);
    }

    public String getPreviousOwner() {
        return previousOwner.get();
    }

    public StringProperty previousOwnerProperty() {
        return previousOwner;
    }

    public void setPreviousOwner(String previousOwner) {
        this.previousOwner.set(previousOwner);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public int getPricePerUnit() {
        return pricePerUnit.get();
    }

    public IntegerProperty pricePerUnitProperty() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public int getTotalPrice() {
        return totalPrice.get();
    }

    public IntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    @Override
    public String toString() {
        return "Drug{" +
                "productID=" + productID +
                ", productName=" + productName +
                ", owner=" + owner +
                ", previousOwner=" + previousOwner +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", totalPrice=" + totalPrice +
                '}';
    }
    public String report() {
        return 
                "productID=" + getProductID() +
                "\nproductName=" + getProductName() +
                "\nowner=" + getOwner() +
                "\npreviousOwner=" + getPreviousOwner() +
                "\nquantity=" + getQuantity() +
                "\npricePerUnit=" + getPricePerUnit() +
                "\ntotalPrice=" + getTotalPrice() ;
               
    }
}

