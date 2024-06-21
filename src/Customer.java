import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private String address;
    private int phone;
    private String email;

    public int getCustomerID() {
        return customerID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Customer(String name, String address, int phone, String email, String password, ArrayList<BankAccount> arr1) {

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
       this.customerID=0;
    }

    public Customer() {
    }



}
