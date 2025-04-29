package workshop.bank.entity;

public class SavingsAccount extends Account {
	
	private double interestRate;  //이자율

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    //이자 적용
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    //계좌 정보
    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + (interestRate * 100) + "%";
    }
}
