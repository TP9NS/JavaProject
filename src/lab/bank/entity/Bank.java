package lab.bank.entity;

import lab.bank.exception.*;
import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        Account acc = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(acc);
        System.out.println("Saving(����) ���°� �����Ǿ����ϴ�: " + acc);
        return accountNumber;
    }

    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        Account acc = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + acc);
        return accountNumber;
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        if (acc == null) throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        Account acc = findAccount(accountNumber);
        if (acc == null) throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
        acc.withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
        System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
    }

    public void printAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}