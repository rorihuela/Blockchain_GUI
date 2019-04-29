import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//{
//        "productID": 0,
//        "productName": "name0",
//        "owner": "ownername0",
//        "previousOwner": "prevownername0",
//        "quantity": 10,
//        "pricePerUnit": 15,
//        "totalPrice": 100
//        }


public class Drug {
    private final SimpleIntegerProperty productID;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty owner;
    private final SimpleStringProperty previousOwner;
    private final SimpleIntegerProperty quantity;
    private final SimpleIntegerProperty pricePerUnit;
    private final SimpleIntegerProperty totalPrice;

    public Drug(Long productID, String productName, String owner, String previousOwner, Long quantity, Long pricePerUnit, Long totalPrice) {
        this.productID = new SimpleIntegerProperty(productID.intValue());
        this.productName = new SimpleStringProperty(productName);
        this.owner = new SimpleStringProperty(owner);
        this.previousOwner = new SimpleStringProperty(previousOwner);
        this.quantity = new SimpleIntegerProperty(quantity.intValue());
        this.pricePerUnit = new SimpleIntegerProperty(pricePerUnit.intValue());
        this.totalPrice = new SimpleIntegerProperty(totalPrice.intValue());
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
}

