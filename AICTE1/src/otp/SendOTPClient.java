package otp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SendOTPClient {
    private static String otpReceived;
    private static String countryCode;
    private static String mobNumber;
    private static InputStreamReader r=new InputStreamReader(System.in);
    private static BufferedReader br=new BufferedReader(r);

    public static void main(String gg[]){
        try {
            System.out.println("Enter country code: ");
            countryCode = br.readLine();
            System.out.println("Enter mobile number: ");
            mobNumber = br.readLine();

            System.out.println("Auto verify? ('Y' / 'N'): ");
            String choice = br.readLine();
            if(!("Y".equalsIgnoreCase(choice)) && !("N".equalsIgnoreCase(choice))){
                System.out.println("Invalid choice.");
                return;
            }
            if("Y".equalsIgnoreCase(choice)){
                sendOTPAutoVerification();
            }
            if("N".equalsIgnoreCase(choice)){
                sendOTPAutoVerification();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendOTP(String mobileNumber,String cCode) {
    	mobNumber = mobileNumber;
    	countryCode = cCode;
    	System.out.println("mob_no:" +mobNumber);
    	sendOTPAutoVerification();
    }
    
 

    private static void sendOTPAutoVerification(){
        SendOTPAutoVerification sendOTPServer = new SendOTPAutoVerification();
        sendOTPServer.generateOTP(countryCode,mobNumber);

        System.out.println("Enter received otp: ");
        try {
            otpReceived = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendOTPServer.verifyOTP(countryCode,mobNumber,otpReceived);
    }
}