package otp;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;


/*
* This code is based on jersey-client library.
* 
* For gradle based project use compile 'com.sun.jersey:jersey-client:1.18.4'
* You can also download the jar and add it to you project.
* */
public class SendOTPServer {

    private static String otp;

    //Base URL
    public static String baseUrl = "https://sendotp.msg91.com/api";

    // Your application key
    public static String applicationKey = "THD9_5OphSMOFzATkG20GCfl6aXPrxUiGarqKJ8EdGmsMSatgombk3ZcvOgUNaujoc7W3FrjS_f4p_HCpYywCGU6MTts63F91lT0WYSBSQJfQPwSHp4HqzlabTtSiYydj6nB3CT9F8nPJUSjAbLQlA==";
    
    public static void generateOTP(String countryCode, String mobileNumber){
        try {
            Client client = Client.create();
            String Url  = baseUrl+"/generateOTP";
            WebResource webResource = client.resource(Url);

            HashMap<String, String> requestBodyMap = new HashMap<String, String>();
            requestBodyMap.put("countryCode",countryCode);
            requestBodyMap.put("mobileNumber",mobileNumber);
            requestBodyMap.put("getGeneratedOTP","true");
            JSONObject requestBodyJsonObject = new JSONObject(requestBodyMap);
            String input = requestBodyJsonObject.toString();

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("application-Key", applicationKey)
                    .post(ClientResponse.class, input);
            String output = response.getEntity(String.class);
            System.out.println("Request: "+output);
            //fetch your oneTimePassword and save it to session or db
            JSONObject jsonObj = new JSONObject(output);
            JSONObject responseJson = jsonObj.getJSONObject("response");
            otp = responseJson.getString("oneTimePassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyOTP(String countryCode, String mobileNumber, String oneTimePassword){
    	boolean verify=true;
        try {
            //fetch your oneTimePassword from session or db
            //and compare it with the OTP sent from client
            Client client = Client.create();
            String Url  = baseUrl+"/verifyOTP";
            WebResource webResource = client.resource(Url);

            HashMap<String, String> requestBodyMap = new HashMap<String, String>();
            requestBodyMap.put("countryCode",countryCode);
            requestBodyMap.put("mobileNumber",mobileNumber);
            requestBodyMap.put("oneTimePassword",oneTimePassword);
            String inputstr = "{\"countryCode\":\"91\",\"mobileNumber\":\""+mobileNumber+"\",\"oneTimePassword\":\""+oneTimePassword+"\"}";
            JSONObject requestBodyJsonObject = new JSONObject(requestBodyMap);
            String input = requestBodyJsonObject.toString();

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("application-Key", applicationKey)
                    .post(ClientResponse.class, input);
            String output = response.getEntity(String.class);
            System.out.println("Response: "+output);
            JSONObject jsonObj = new JSONObject(output);
            JSONObject responseJson = jsonObj.getJSONObject("response");
            String status = responseJson.getString("code");

            if("NUMBER_VERIFIED_SUCCESSFULLY".equalsIgnoreCase(status)){
                System.out.println("Verified");
            }
            else{
                System.out.println("Invalid code");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verify;
    }
   
   
}