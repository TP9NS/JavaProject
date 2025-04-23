// package: lab.bank.exception
package lab.bank.exception;

public class WithdrawalLimitExceededException extends Exception {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}