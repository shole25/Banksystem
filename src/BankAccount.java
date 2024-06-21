import java.util.ArrayList;
import java.util.List;

public class BankAccount extends  Customer{

    private int accountNumber,balance;
    private AccountType accountType ;

    public BankAccount( AccountType accountType, String name, String address,
                       int phone, String email, String password, ArrayList<BankAccount> arr) {
       super(name, address, phone, email, password,arr);
//        this.accountNumber = accountNumber;
        this.accountType = accountType;
        arr.add(this);
        while (this.accountNumber == 0) {
            int ran = (int) (Math.random() * 9998 + 1);
            for (BankAccount bankAccount : arr) {
                if (ran != bankAccount.getAccountNumber()) {
                    this.accountNumber = ran;
                }
            }
        }
    }


public BankAccount(){

   // super(name, address, phone, email, password);
}
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
