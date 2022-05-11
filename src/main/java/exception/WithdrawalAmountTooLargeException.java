package exception;

public class WithdrawalAmountTooLargeException extends Exception{

    public WithdrawalAmountTooLargeException() {
    }


    public WithdrawalAmountTooLargeException(String message) {
        super(message);
    }

    public WithdrawalAmountTooLargeException(String message, Throwable cause) {
        super(message, cause);
    }


    public WithdrawalAmountTooLargeException(Throwable cause) {
        super(cause);
    }

    public WithdrawalAmountTooLargeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}