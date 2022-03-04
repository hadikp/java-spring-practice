package bank;

import java.time.LocalDateTime;

public class Transaction {

    private Direction direction;
    private LocalDateTime time;
    private double amount;

    public Transaction(Direction direction, LocalDateTime time, double amount) {
        this.direction = direction;
        this.time = time;
        this.amount = amount;
    }

    public Direction getDirection() {
        return direction;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "direction=" + direction +
                ", time=" + time +
                ", amount=" + amount +
                '}' + "\n";
    }
}
