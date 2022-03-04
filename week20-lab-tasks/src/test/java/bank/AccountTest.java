package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void init() {
        List<Transaction> transactions = List.of(
          new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 02, 28, 10, 11), 10_000),
          new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 03, 01, 11, 22), 5_000));
        account = new Account("111135233-111148172-1100000052", 100_000);
    }

    @Test
    void testInitAccount() {
        assertEquals("111135233-111148172-1100000052", account.getAccountNumber());
        assertEquals(100_000, account.getBalance());
    }


    @Test
    void testWithdraw() {
        account.withdraw(10_000);
        assertEquals(90_000, account.getBalance());
    }

    @Test
    void testAmountZero() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertEquals("Invalid amount!", ex.getMessage());
    }

    @Test
    void testAmountNegative() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10_000));
        assertEquals("Invalid amount!", ex.getMessage());
    }

    @Test
    void testDeposit() {
        account.deposit(10_000);
        assertEquals(110_000, account.getBalance());
    }

    @Test
    void testDepositNegative() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-20_000));
        assertEquals("Amount can't be negative or 0!", ex.getMessage());
    }

    @Test
    void testDoTransaction() {
        System.out.println();
    }

}