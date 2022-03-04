package bank;

public class Account {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if(amount > this.balance || amount <= 0) {
            throw new IllegalArgumentException("Invalid amount!");
        } else {
            this.balance -= amount;
        }
    }

    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount can't be negative or 0!");
        } else {
            this.balance += amount;
        }
        //return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
