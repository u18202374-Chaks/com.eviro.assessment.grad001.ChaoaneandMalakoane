import exception.AccountNotFoundException;
import exception.WithdrawalAmountTooLargeException;

import java.math.BigDecimal;

public class SavingsAccount {

    String customnum;
    Integer id;
    Integer accounnum;
    BigDecimal balance;
    BigDecimal startaccountamount;

    public SavingsAccount(String _custonum,Integer _id,Integer _accounum,BigDecimal _balance)
    {
        customnum=_custonum;
        id=_id;
        accounnum=_accounum;
        balance=_balance;
        startaccountamount = new BigDecimal("1000");
    }

    public BigDecimal withdraw(Integer accnum,BigDecimal amountowithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException{

        // check if the account number exists in the database else throw an exception
        if(accounnum==accnum) {

            int result = balance.compareTo(startaccountamount);
            int res = balance.compareTo(amountowithdraw);
            if((result==0 || result == 1)&& res == 1)
            {

                balance = balance.subtract(amountowithdraw);
                return balance;
            }
            else
            {
                throw new WithdrawalAmountTooLargeException("The withdrwal amount is greater than the balance");
            }



        }
        else
        {
            throw new AccountNotFoundException("Account number was not found in the database");
        }


    }





}
