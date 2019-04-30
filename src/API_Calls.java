import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class API_Calls{
    private static String qIdPost = ""; //queryID
    private static int bcId = 2; //blockchainID;

    public static void main(String[] args) throws IOException {
        POSTRequest();
        GETRequest();
    }

    public static void POSTRequest() throws IOException {
        final String POST_PARAMS = "{\n" + "\"blockchainID\":" + bcId + "\r\n}";
        System.out.println(POST_PARAMS);
        URL obj = new URL("https://blockchain-restful-api.herokuapp.com/api/query");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("databaseID", "1");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);

        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());

        BufferedReader in = new BufferedReader(new InputStreamReader(
            postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
            qIdPost = response.toString();
            qIdPost = qIdPost.substring(12,qIdPost.length()-2);
            System.out.println(qIdPost);
        }
        in.close();
        // print result
        System.out.println(response.toString());
    }

    public static void GETRequest() throws IOException {
        URL urlForGetRequest = new URL("https://blockchain-restful-api.herokuapp.com/api/query?queryID="+qIdPost);
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("queryID", qIdPost);
        int responseCode = conection.getResponseCode();
        System.out.println("\nGET response code: "+ responseCode);
        System.out.println("GET Response Message : " + conection.getResponseMessage());
        System.out.println("request property: " + conection.getURL().toString());

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result: \n" + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }

    }
}
