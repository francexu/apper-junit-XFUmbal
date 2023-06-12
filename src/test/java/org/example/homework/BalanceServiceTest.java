package test.java.org.example.homework;

import main.java.org.example.homework.AccountRepository;
import main.java.org.example.homework.BalanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceServiceTest {

    @Test
    void successfullyGetBalance() throws Exception {
        // Setup
        AccountRepository accountRepository = new AccountRepository();
        BalanceService balanceService = new BalanceService(accountRepository);

        // Kick
        String newAccount = accountRepository.createAccount("Xenia", 95.0);

        // Verify
        Assertions.assertEquals(95.0, balanceService.getBalance(newAccount));
        Assertions.assertEquals("Xenia", accountRepository.getAccount(newAccount).getName());
        Assertions.assertEquals(1, accountRepository.getNumberOfAccounts());
    }

    @Test
    void successfullyDebit() throws Exception {
        // Setup
        AccountRepository accountRepository = new AccountRepository();
        BalanceService balanceService = new BalanceService(accountRepository);

        // Kick
        String newAccount = accountRepository.createAccount("Xenia", 95.0);
        balanceService.debit(newAccount, 90.0);

        // Verify
        Assertions.assertEquals(5.0, balanceService.getBalance(newAccount));
    }

    @Test
    void successfullyCredit() throws Exception {
        // Setup
        AccountRepository accountRepository = new AccountRepository();
        BalanceService balanceService = new BalanceService(accountRepository);

        // Kick
        String newAccount = accountRepository.createAccount("Xenia", 95.0);
        balanceService.credit(newAccount, 90.0);

        // Verify
        Assertions.assertEquals(185.0, balanceService.getBalance(newAccount));
    }

    @Test
    void successfullyNoRegisteredAccounts() {
        // Setup
        AccountRepository accountRepository = new AccountRepository();
        BalanceService balanceService = new BalanceService(accountRepository);

        // Verify
        Assertions.assertEquals(0, accountRepository.getNumberOfAccounts());
        Assertions.assertTrue(accountRepository.noRegisteredAccounts());
    }
}