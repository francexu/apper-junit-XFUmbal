package org.example;

import java.util.*;

// database of accounts
public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    public String createAccount(String name, Double initialBalance) {
        String id = UUID.randomUUID().toString();
        Account account = new Account(id, name, initialBalance);

        accounts.add(account);

        return id;
    }

    public Account getAccount(String id) {
        // verify if account exists
        for (Account account : accounts) {
            if (account.id().equals(id)) {
                return account;
            }
        }

        return null;
    }

    public void deleteAccount(String id) {
        // verify first if account exists then delete
        for (Account account : accounts) {
            if (account.id().equals(id)) {
                accounts.remove(account);
                return;
            }
        }

    }

    public Integer getNumberOfAccounts() {
        return accounts.size();
    }
}
