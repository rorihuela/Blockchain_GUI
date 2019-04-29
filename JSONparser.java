import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONparser {

    public static ObservableList<Drug> parse(InputStream json){
        JSONParser parser = new JSONParser();
        ArrayList<Drug> drugList = new ArrayList<>();

        // Read in JSON file as JSONObject
        try {
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(json)); // creates JSON Object from JSON input
            JSONArray array = (JSONArray) obj.get("data"); // converts array value in "data" key of json to JSON Array

            // iterates through JSON array, each index represents a block of transaction data (data block) consisting of
            // a JSON block of data representing the information of a single transaction.
            for(int i = 0; i < array.size(); i++){
                JSONObject dataBlock = (JSONObject) array.get(i);
                drugList.add(makeDrug(dataBlock));// create a Drug object from the data block and add it to the ArrayList
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return FXCollections.observableArrayList(drugList);
    }

    // method: makeDrug
    // purpose: creates Drug object out of JSON data
    private static Drug makeDrug(JSONObject data){

        return new Drug(
                (Long) data.get("productID"),
                (String) data.get("productName"),
                (String) data.get("owner"),
                (String) data.get("previousOwner"),
                (Long) data.get("quantity"),
                (Long) data.get("pricePerUnit"),
                (Long) data.get("totalPrice"));
    }
}
