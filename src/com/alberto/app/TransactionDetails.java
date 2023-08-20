package com.alberto.app;


/**
 *
 * @author Ejuku A. I
 */
public class TransactionDetails {
    private String amount = "";
    private String partyA = "";
    private String phoneNumber = "";

    public TransactionDetails() {
    }

    public TransactionDetails(String amount, String phoneNumber) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.partyA = phoneNumber;
    }

    public String getAmount() {
        return amount == null ? "0.0" : amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? "0.0" : amount;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPhoneNumber() {
        return phoneNumber == null ? "No phone number" : phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
    }

    /**
     *
     * @return request parameters associated with our transaction
     */
    public String transactionDetails() {

        if(this.amount == null || this.phoneNumber == null){
            System.out.println("You have null values, ");
        }

        return "{" +
                "\"BusinessShortCode\": \"" + Config.BUSINESS_SHORT_CODE + "\"," +
                "\"Password\":  \"" + Config.PASSWORD + "\", " +
                "\"Timestamp\": \"" + Config.TIMESTAMP + "\", " +
                "\"TransactionType\": \"" + Config.TRANSACTION_TYPE + "\"," +
                "\"Amount\": \"" + this.amount + "\"," +
                "\"PartyA\": \"" + this.partyA + "\"," +
                "\"PartyB\": \"" + Config.BUSINESS_SHORT_CODE + "\", " +
                "\"PhoneNumber\": \"" + this.phoneNumber + "\"," +
                "\"CallBackURL\": \"" + Config.CALLBACK_URL + "\"," +
                "\"AccountReference\": \"" + Config.ACCOUNT_REFERENCE + "\"," +
                "\"TransactionDesc\": \"" + Config.TRANSACTION_DESC + "\"" +
                "}";
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "amount='" + amount + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    
}
