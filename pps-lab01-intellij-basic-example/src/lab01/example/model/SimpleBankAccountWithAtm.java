package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    public static final int ATM_FEE = 1;
    private final BankAccount bankAccount;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.bankAccount.deposit(userID, amount - ATM_FEE);
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.bankAccount.withdraw(userID, amount + ATM_FEE);
    }
}
