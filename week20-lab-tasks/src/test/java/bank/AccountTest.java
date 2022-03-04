package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void init() {
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

}