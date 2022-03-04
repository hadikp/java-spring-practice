package bank;

import java.util.List;

public class Bank {

    private List<User> users;

    public void addUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User should not be null!");
        }
        users.add(user);
    }

    public void transactionFromUserToOther(User user, User otherUser) {
        System.out.println();
    }


}
