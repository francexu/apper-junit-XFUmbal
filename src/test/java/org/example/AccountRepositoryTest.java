package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountRepositoryTest {

    @Test
    void successfulAccountCreation() {
        // Setup - initialize yung itetest
        AccountRepository repository = new AccountRepository();


        // Kick - try to invoke the method
        String accountId = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
    }

    @Test
    void successfulGetAccount() {
        // Setup
        AccountRepository repository = new AccountRepository();

        // Kick
        String accountId = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals("Xenia", repository.getAccount(accountId).name());
        Assertions.assertEquals(90.0, repository.getAccount(accountId).balance());
        Assertions.assertEquals(null, repository.getAccount("randomid"));
    }

    @Test
    void successfulDeleteAccount() {
        // Setup
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("Xenia", 90.0);

        // Kick
        repository.deleteAccount(accountId);

        // Verify
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }

    @Test
    void getNumberOfAccounts() {
        // Setup
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("Xenia", 90.0);
        String accountId1 = repository.createAccount("Xenia", 90.0);
        String accountId2 = repository.createAccount("Xenia", 90.0);
        String accountId3 = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals(4, repository.getNumberOfAccounts());
    }
}