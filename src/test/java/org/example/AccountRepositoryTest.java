package test.java.org.example;

import main.java.org.example.notes.AccountRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class AccountRepositoryTest {

    AccountRepository repository;

    @BeforeEach // executes before EACH test
    void setup() {
        System.out.println("Setting up...");
        repository = new AccountRepository();
    }

    @AfterEach // executes after EACH test
    void cleanup() {
        System.out.println("Cleaning up...");
        repository.deleteAllAccounts();
    }

    @BeforeAll // executes before ALL tests
    static void globalSetup() {
        System.out.println("Global setup");
    }

    @AfterAll // executes after ALL tests
    static void globalCleanup() {
        System.out.println("Global cleanup");
    }

    @Test
    @DisplayName("Successful account creation") // gives a more descriptive report
    void successfulAccountCreation() {
        // Setup - initialize yung itetest
        //AccountRepository repository = new AccountRepository();


        // Kick - try to invoke the method
        String accountId = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
    }

    @Test
    void successfulGetAccount() {
        // Setup
        //AccountRepository repository = new AccountRepository();

        // Kick
        String accountId = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals("Xenia", repository.getAccount(accountId).getName(), "The name should not be blank."); // third parameter for reporting
        Assertions.assertEquals(90.0, repository.getAccount(accountId).getBalance());
        Assertions.assertEquals(null, repository.getAccount("randomid"));
    }

    @Test
    void successfulDeleteAccount() {
        // Setup
        //AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("Xenia", 90.0);

        // Kick
        repository.deleteAccount(accountId);

        // Verify
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }

    @Test
    void getNumberOfAccounts() {
        // Setup
        //AccountRepository repository = new AccountRepository();

        // Kick
        String accountId = repository.createAccount("Xenia", 90.0);
        String accountId1 = repository.createAccount("Xenia", 90.0);
        String accountId2 = repository.createAccount("Xenia", 90.0);
        String accountId3 = repository.createAccount("Xenia", 90.0);

        // Verify
        Assertions.assertEquals(4, repository.getNumberOfAccounts());
    }

    @Test
    void getAllAccountNames() {
        //AccountRepository repository = new AccountRepository();

        // Kick
        repository.createAccount("Xenia", 100.0);
        repository.createAccount("Seungcheol", 100.0);
        repository.createAccount("Jeonghan", 100.0);
        repository.createAccount("Joshua", 100.0);
        repository.createAccount("Jun", 100.0);

        List<String> allAccountNames = repository.getAllAccountNames();

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("Xenia");
        expectedNames.add("Seungcheol");
        expectedNames.add("Jeonghan");
        expectedNames.add("Joshua");
        expectedNames.add("Jun");

        // Verify
        Assertions.assertIterableEquals(expectedNames, allAccountNames);

    }
}