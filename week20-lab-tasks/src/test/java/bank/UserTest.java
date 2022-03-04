package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    Transaction withdraw;
    Transaction deposit;
    Account account;

    @BeforeEach
    void init() {
        withdraw = new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 01, 12, 13, 15), 10_000);
        deposit = new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 01, 11, 13, 15), 20_000);
        account = new Account("112222333-0172135-1100000044", 200_000);
        user = new User("Tóth János", account);
    }

    @Test
    void testInitUser() {
        assertEquals("Tóth János", user.getName());
        assertEquals(200_000, user.getAccount().getBalance());
    }

    @Test
    void testDoTransactionWithdraw() {
        user.doTransaction(withdraw);
        assertEquals(190_000, user.getAccount().getBalance());
    }

    @Test
    void testDoTransactionDeposit() {
        user.doTransaction(deposit);
        assertEquals(220_000, user.getAccount().getBalance());
    }

}