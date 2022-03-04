package bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User should not be null!");
        }
        users.add(user);
    }

    public void transactionFromUserToOther(User user, User otherUser, double amount) {
        user.doTransaction(new Transaction(Direction.WITHDRAW, LocalDateTime.now(), amount));
        otherUser.doTransaction(new Transaction(Direction.DEPOSIT, LocalDateTime.now(), amount));
    }


}
