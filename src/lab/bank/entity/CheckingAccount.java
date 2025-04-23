package lab.bank.entity;

import lab.bank.exception.*;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() + ", ��� �ѵ�: " + withdrawalLimit + "��";
    }
}
