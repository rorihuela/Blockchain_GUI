
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Drug {
    private final StringProperty productID;
    private final StringProperty productName;
    private final StringProperty owner;
    private final StringProperty previousOwner;
    private final IntegerProperty quantity;
    private final IntegerProperty pricePerUnit;
    private final IntegerProperty totalPrice;
    private final StringProperty componentOf;
    private final StringProperty transactionDate;
    private final StringProperty orderID;


    public Drug(String productID, String productName, String componentOf,
                String owner, String previousOwner, Long quantity, Long pricePerUnit,
                Long totalPrice, String transactionDate, String orderID) {
        this.productID = new SimpleStringProperty(productID);
        this.productName = new SimpleStringProperty(productName);
        this.componentOf = new SimpleStringProperty(componentOf);
        this.owner = new SimpleStringProperty(owner);
        this.previousOwner = new SimpleStringProperty(previousOwner);
        this.quantity = new SimpleIntegerProperty(quantity.intValue());
        this.pricePerUnit = new SimpleIntegerProperty(pricePerUnit.intValue());
        this.totalPrice = new SimpleIntegerProperty(totalPrice.intValue());
        this.transactionDate = new SimpleStringProperty(transactionDate);
        this.orderID = new SimpleStringProperty(orderID);
    }
    public String getID() {
        return productID.get() + "";
    }

    public String getProductID() {
        return productID.get();
    }

    public StringProperty productIDProperty() {
        return productID;
    }

    public void setProductID(String productID) {
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

    public String getComponentOf() {
        return componentOf.get();
    }

    public StringProperty componentOfProperty() {
        return componentOf;
    }

    public void setComponentOf(String componentOf) {
        this.componentOf.set(componentOf);
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

    public String getTransactionDate() {
        return transactionDate.get();
    }

    public StringProperty transactionDateProperty() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate.set(transactionDate);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    @Override
    public String toString() {
        return "Drug{" +
                "productID=" + productID +
                ", productName=" + productName +
                ", componentOf=" + componentOf +
                ", owner=" + owner +
                ", previousOwner=" + previousOwner +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", totalPrice=" + totalPrice +
                ", transactionDate=" + transactionDate +
                ", orderID=" + orderID +
                '}';
    }
    public String report() {
        return
                "productID = " + getProductID() +
                        "\ncomponentOf = " + getComponentOf() +
                        "\nproductName = " + getProductName() +
                        "\nowner = " + getOwner() +
                        "\npreviousOwner = " + getPreviousOwner() +
                        "\nquantity = " + getQuantity() +
                        "\npricePerUnit = " + getPricePerUnit() +
                        "\ntotalPrice = " + getTotalPrice() +
                        "\ntransactionDate = " + getTransactionDate() +
                        "\norderID = " + getOrderID();

    }
}
