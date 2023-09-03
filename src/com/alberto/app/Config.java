package com.alberto.app;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * <h3>Global Configuration Class</h3>
 * <p>
 *     This class contains all static properties to use in your app.
 * </p>
 *
 *
 * @author Ejuku A. I
 */
public class Config {

    //    Request parameters
    public static final String PASSKEY = "USE YOUR APP'S PASSKEY";
    public static final String BUSINESS_SHORT_CODE = "174379";
    public static final String TIMESTAMP = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    public static String PASSWORD = getPASSWORD();
    public static String TRANSACTION_TYPE = "CustomerPayBillOnline";
    public static String PARTY_B = BUSINESS_SHORT_CODE;
    public static final String CALLBACK_URL = "https://myexamplecompany.com/payments";
    public static String ACCOUNT_REFERENCE = "My Company Name";
    public static String TRANSACTION_DESC = "Payment for product XYZ";
    public static final String CONSUMER_KEY = "USE YOUR APP'S CONSUMER_KEY";
    public static final String CONSUMER_SECRET = "USE YOUR APP'S CONSUMER_SECRET";


    public static String getPASSWORD() {
        // creating our base64 password
        // password = Base64.encode(shortcode + passkey + timestamp) in string format
        byte[] str = (BUSINESS_SHORT_CODE + PASSKEY + TIMESTAMP).getBytes(StandardCharsets.UTF_8);
        byte[] key = Base64.getEncoder().encode(str);
        StringBuilder password = new StringBuilder();

        for (byte b : key) {
            password.append((char) b);
        }
        return String.valueOf(password);
    }
    
}
