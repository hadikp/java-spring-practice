package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void init() {
        account = new Account("111135233-111148170-11000002", 100_000);
        account.addTransaction(new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 02, 28, 10, 11), 10_000));
        account.addTransaction(new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 03, 01, 11, 22), 5_000));

    }

    @Test
    void testInitAccount() {
        assertEquals("111135233-111148170-11000002", account.getAccountNumber());
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
    void testDepositFilter() {
        account.addTransaction(new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 01, 13, 10, 11), 25_000));
        account.addTransaction(new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 01, 15, 12, 30), 75_000));
        assertEquals(3, account.depositFilter().size());
    }

    @Test
    void testWithdrawFilter() {
        account.addTransaction(new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 01, 17, 10, 11), 25_000));
        account.addTransaction(new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 01, 15, 12, 30), 75_000));
        assertEquals(2, account.withdrawFilter().size());
    }

    @Test
    void testDateFilter() {
        assertEquals(1, account.dateFilter(LocalDateTime.of(2022,03, 01, 10, 22)).size());
    }

    @Test
    void testGetTransactions() {
        account.addTransaction(new Transaction(Direction.WITHDRAW, LocalDateTime.of(2022, 01, 11, 10, 11), 15_000));
        assertEquals(3, account.getTransactions().size());
    }

}