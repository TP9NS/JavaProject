package workshop.bank.control;

import workshop.bank.entity.Bank;
import workshop.bank.exception.AccountNotFoundException;

public class BankDemo {
    public static void main(String[] args) {
    	
        Bank bank = new Bank();
        
        System.out.println("=== 계좌 생성 ===");

        bank.createSavingsAccount("홍길동", 10000.0, 0.03);    //이자율 3%
        bank.createCheckingAccount("김철수", 20000.0, 5000.0); //출금 한도 5000
        bank.createSavingsAccount("이영희", 30000.0, 0.02);    //이자율 2%
        System.out.println();

        //모든 계좌 목록
        bank.printAllAccounts();
        System.out.println();
        
        System.out.println("=== 입금/출금 테스트 ===");
        //입 출금 test
        try {
            bank.deposit("AC1000", 5000.0);  //홍길동
            bank.withdraw("AC1001", 3000.0);
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== 이자 적용 테스트 ===");
        //이자 적용 test
        try {
            bank.applyInterest("AC1000");  //홍길동의 저축계좌
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        System.out.println("=== 계좌 이체 테스트 ===");
        //계좌 이체 test
        try {
            bank.transfer("AC1002", "AC1001", 5000.0); // 이영희가 김철수에게
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        //모든 계좌 목록
        System.out.println("=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        //예외 test
        try {
            bank.withdraw("AC1001", 6000.0);  //한도 초과
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC1001", 6000.0);  //다시 한도 초과
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.deposit("AC9999", 1000.0);  //없는 계좌
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
