import lab01.example.exception.IllegalAmountException;
import lab01.example.exception.IllegalUserException;
import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;


    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDepositWithATM() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - SimpleBankAccountWithAtm.ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithATM() {
        assertThrows(IllegalUserException.class, () -> bankAccount.deposit(2, 50));
    }

    @Test
    void testWithdrawWithATM() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - 2 * SimpleBankAccountWithAtm.ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongUserWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertThrows(IllegalUserException.class, () -> bankAccount.withdraw(2, 70));
    }

    @Test
    void testWrongAmountWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertThrows(IllegalAmountException.class, () -> bankAccount.withdraw(accountHolder.getId(), 120));
    }

}