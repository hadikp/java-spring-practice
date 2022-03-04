package bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
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
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public List<Transaction> depositFilter(){
        return transactions.stream().filter(t->t.getDirection() == Direction.DEPOSIT).toList();
    }

    public List<Transaction> withdrawFilter(){
        return transactions.stream().filter(t->t.getDirection() == Direction.WITHDRAW).toList();
    }

    public List<Transaction> dateFilter(LocalDateTime time){
        return transactions.stream().filter(f -> f.getTime().isAfter(time)).toList();
    }
}
