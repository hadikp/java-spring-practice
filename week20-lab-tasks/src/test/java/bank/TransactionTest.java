package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction transaction;

    @BeforeEach
    void init() {
        transaction = new Transaction(Direction.DEPOSIT, LocalDateTime.of(2022, 02, 12, 11, 23), 10_000);
    }

    @Test
    void testInit() {
        assertEquals(Direction.DEPOSIT, transaction.getDirection());
        assertEquals(LocalDateTime.of(2022, 02, 12, 11, 23), transaction.getTime());
        assertEquals(10_000, transaction.getAmount());
    }

}