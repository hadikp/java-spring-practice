package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    User user;
    User otherUser;
    Transaction withdraw;
    Transaction deposit;
    Account account;
    Account otherAccount;

    @BeforeEach
    void init() {
        withdraw = new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 01, 12, 13, 15), 10_000);
        deposit = new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 01, 11, 13, 15), 20_000);
        account = new Account("112222333-01721350-11000004", 200_000);
        otherAccount = new Account("112222333-01721350-11000005", 300_000);
        user = new User("Tóth János", account);
        otherUser = new User("Lópiczi Gáspár", otherAccount);
    }

    @Test
    void testTransactionFromUserToOther() {
        Bank bank = new Bank();
        bank.transactionFromUserToOther(user, otherUser, 20_000);
        assertEquals(180_000, user.getAccount().getBalance());
        assertEquals(320_000, otherUser.getAccount().getBalance());
    }

}