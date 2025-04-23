package lab.bank.control;

import lab.bank.entity.*;
import lab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        String acc1 = bank.createSavingsAccount("ȫ�浿", 10000, 0.03);
        String acc2 = bank.createCheckingAccount("��ö��", 20000, 5000);
        String acc3 = bank.createSavingsAccount("�̿���", 30000, 0.02);

        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit(acc1, 5000);
            bank.withdraw(acc1, 3000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        try {
            Account sa = bank.findAccount(acc1);
            if (sa instanceof SavingsAccount) {
                ((SavingsAccount) sa).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer(acc3, acc2, 5000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        bank.printAllAccounts();

        System.out.println("\n=== ���� �׽�Ʈ ===");
        try {
            bank.withdraw(acc2, 6000); // ��� �ѵ� �ʰ�
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.transfer("AC9999", acc1, 1000); // �������� �ʴ� ����
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}