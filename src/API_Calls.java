import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class API_Calls{
    private static String qIdPost = ""; //queryID
    private static int bcId = 2; //blockchainID;

    public static InputStream getInputStream(String url){

        try {
            POSTRequest(url);
            return GETRequest(url);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static void POSTRequest(String url) throws IOException {
        final String POST_PARAMS = "{\n" + "\"blockchainID\":" + bcId + "\r\n}";
        System.out.println(POST_PARAMS);
        URL postRequestURL = new URL(url);
        HttpURLConnection postConnection = (HttpURLConnection) postRequestURL.openConnection();
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

    private static InputStream GETRequest(String url) throws IOException {
        URL urlForGetRequest = new URL(url+"?queryID="+qIdPost);
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("queryID", qIdPost);
        int responseCode = connection.getResponseCode();
        System.out.println("\nGET response code: "+ responseCode);
        System.out.println("GET Response Message : " + connection.getResponseMessage());
        System.out.println("request property: " + connection.getURL().toString());

        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("GET NOT WORKED");

//            BufferedReader in = new BufferedReader(
//                new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            } in .close();
//            // print result
//            System.out.println("JSON String Result: \n" + response.toString());
//            //GetAndPost.POSTRequest(response.toString());
            return null;
        }

        return connection.getInputStream();

    }
}
