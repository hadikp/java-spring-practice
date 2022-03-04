package bank;

public class User {

    private String name;
    private Account account;

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public void doTransaction(Transaction transaction) {
        if(transaction.getDirection() == Direction.WITHDRAW) {
            account.withdraw(transaction.getAmount());
            account.addTransaction(transaction);

        } else {
            account.deposit(transaction.getAmount());
            account.addTransaction(transaction);
        }

    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
