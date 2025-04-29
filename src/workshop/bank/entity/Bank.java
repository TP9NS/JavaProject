package workshop.bank.entity;

import workshop.bank.exception.AccountNotFoundException;
import workshop.bank.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public void createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
        accounts.add(account);
        System.out.println("저축 계좌가 생성되었습니다: " + account);
    }

    public void createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
    }

    private Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + account.getBalance() + "원");
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        try {
            account.withdraw(amount);
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + account.getBalance() + "원");
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    public void applyInterest(String accountNumber) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        if (account instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) account;
            double before = sa.getBalance();
            sa.applyInterest();
            double interest = sa.getBalance() - before;
            System.out.println(interest + "원이 입금되었습니다. 현재 잔액: " + sa.getBalance() + "원");
            System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + sa.getBalance() + "원");
        } else {
            System.out.println("예외 발생: 저축 계좌가 아닙니다.");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        try {
            from.withdraw(amount);
            System.out.println(amount + "원이 출금되었습니다." + "현재 잔액: " + from.getBalance() + "원");
            to.deposit(amount);
            System.out.println(amount + "원이 입금되었습니다." + "현재 잔액: " + to.getBalance() + "원");
            System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
        } catch (InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
