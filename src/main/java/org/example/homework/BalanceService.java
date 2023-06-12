package main.java.org.example.homework;

import java.io.IOException;

public class BalanceService {

    private AccountRepository accountRepository = new AccountRepository();;
    private Account account;

    public BalanceService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Double getBalance(String id) throws Exception {
        Account account = accountRepository.getAccount(id);
        if (account == null) {
            throw new Exception("Account not found");
        } else {
            return account.getBalance();
        }
    }

    public void debit(String id, Double amount) throws Exception {
        Account account = accountRepository.getAccount(id);

        if (account == null) {
            throw new Exception("Account not found.");
        } else if (amount > account.getBalance()) {
            throw new Exception("Insufficient balance.");
        } else {
            Double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }

    public void credit(String id, Double amount) throws Exception {
        Account account = accountRepository.getAccount(id);

        if (account == null) {
            throw new Exception("Account not found.");
        } else {
            Double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
        }
    }

    public void transfer(String fromId, String toId, Double amount) throws Exception {
        Account sender = accountRepository.getAccount(fromId);
        Account recipient = accountRepository.getAccount(toId);

        if (sender == null) {
            throw new Exception("Sender not found.");
        } else if (recipient == null) {
            throw new Exception("Recipient not found.");
        } else if (sender.getBalance() < amount) {
            throw new Exception("Insufficient funds to transfer.");
        } else {
            debit(sender.getId(), amount);
            credit(recipient.getId(), amount);
        }
    }
}
