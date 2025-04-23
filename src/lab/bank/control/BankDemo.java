package lab.bank.control;

import lab.bank.entity.*;
import lab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        String acc1 = bank.createSavingsAccount("홍길동", 10000, 0.03);
        String acc2 = bank.createCheckingAccount("김철수", 20000, 5000);
        String acc3 = bank.createSavingsAccount("이영희", 30000, 0.02);

        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(acc1, 5000);
            bank.withdraw(acc1, 3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            Account sa = bank.findAccount(acc1);
            if (sa instanceof SavingsAccount) {
                ((SavingsAccount) sa).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(acc3, acc2, 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.printAllAccounts();

        System.out.println("\n=== 예외 테스트 ===");
        try {
            bank.withdraw(acc2, 6000); // 출금 한도 초과
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.transfer("AC9999", acc1, 1000); // 존재하지 않는 계좌
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}