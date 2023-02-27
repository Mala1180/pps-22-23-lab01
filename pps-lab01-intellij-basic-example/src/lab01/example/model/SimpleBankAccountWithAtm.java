package lab01.example.model;

import lab01.example.exception.IllegalAmountException;
import lab01.example.exception.IllegalUserException;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (userID != holder.getId()) {
            throw new IllegalUserException();
        }
        this.balance = this.balance + amount - ATM_FEE;
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (userID != holder.getId()) {
            throw new IllegalUserException();
        }
        double newBalance = this.balance - amount - ATM_FEE;
        if (newBalance < 0) {
            throw new IllegalAmountException();
        }
        this.balance = newBalance;
    }
}
