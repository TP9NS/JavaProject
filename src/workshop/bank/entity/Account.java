package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;

public abstract class Account {
	private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    //계좌번호
    public String getAccountNumber() {
        return accountNumber;
    }

    //소유자
    public String getOwnerName() {
        return ownerName;
    }

    //잔액
    public double getBalance() {
        return balance;
    }

    // 입금
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    // 출금
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
    }

    // 계좌 정보
    @Override
    public String toString() {
    	return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
    }
}
