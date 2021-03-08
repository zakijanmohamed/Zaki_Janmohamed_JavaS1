import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    public class Address{
        String street1 = "";
        String street2 = "";
        String city = "";
        String state = "";
        int zip;

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getZip() {
            return zip;
        }

        public void setZip(int zip) {
            this.zip = zip;
        }
    }
    String firstName = "";
    String lastName = "";
    String email = "";
    String phoneNumber = "";
    boolean rewardsMember;
    private Address shippingAddress;
    private Address billingAddress;

    public Customer(String firstName, String lastName, String email, String phoneNumber,boolean rewardsMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rewardsMember =rewardsMember;
        this.shippingAddress = new Address();
        this.billingAddress = new Address();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        if (rewardsMember == true){
            System.out.println("Thank you for being a rewards member!");
        }
    }

    public String getBillingStreet1(){
        return billingAddress.getStreet1();
    }
    public void setBillingStreet1(String street1){
        billingAddress.setStreet1(street1);
    }
    public String getBillingStreet2(){
        return billingAddress.getStreet2();
    }
    public void setBillingStreet2(String street2){
        billingAddress.setStreet2(street2);
    }

    public String getBillingCity(){
        return billingAddress.getCity();
    }

    public void setBillingCity(String city){
         billingAddress.setCity(city);
    }

    public String getBillingState(){
        return billingAddress.getState();
    }

    public void setBillingState(String State){
        billingAddress.setState(State);
    }

    public int getBillingZip(){
        return billingAddress.getZip();
    }

    public void setBillingZip(int Zip){
        billingAddress.setZip(Zip);
    }

    public String getShippingStreet1(){
    return shippingAddress.getStreet1();
}
    public void setShippingStreet1(String street1){
        shippingAddress.setStreet1(street1);
    }
    public String getShippingStreet2(){
        return shippingAddress.getStreet2();
    }
    public void setShippingStreet2(String street2){
        shippingAddress.setStreet2(street2);
    }

    public String getShippingCity(){
        return shippingAddress.getCity();
    }

    public void setShippingCity(String city){
        shippingAddress.setCity(city);
    }

    public String getShippingState(){
        return shippingAddress.getState();
    }

    public void setShippingState(String State){
        shippingAddress.setState(State);
    }

    public int getShippingZip(){
        return shippingAddress.getZip();
    }

    public void setShippingZip(int Zip){
        shippingAddress.setZip(Zip);
    }

}
