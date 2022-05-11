import java.math.BigDecimal;
import exception.AccountNotFoundException;
import exception.WithdrawalAmountTooLargeException;

public class CurrentAccount{

    String customnum;
    Integer id;
    Integer accounnum;
    BigDecimal balance;
    BigDecimal maximumdraft;
    BigDecimal overdraft;

    public CurrentAccount(String _custonum,Integer _id,Integer _accounum,BigDecimal _balance,BigDecimal _overdreaft)
    {
        customnum = _custonum;
        id=_id;
        accounnum=_accounum;
        balance=_balance;
        overdraft=_overdreaft;
        maximumdraft = new BigDecimal("100000");
    }


    public BigDecimal withdraw(Integer accnum,BigDecimal amountowithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException
    {
        //check if the account number exist in the database
        if(accounnum == accnum)
        {
            BigDecimal overwithdrawal;
            int result ;

            overwithdrawal = balance.add(overdraft);

            result = overwithdrawal.compareTo(amountowithdraw);

            if(result==1)
            {

                overwithdrawal = overwithdrawal.subtract(amountowithdraw);
                return overwithdrawal;
            }
            else
            {
                throw new WithdrawalAmountTooLargeException("The withdrawal amount is greater than the balance");
            }
        }
        else
        {
            throw new AccountNotFoundException("Account number was not found in the database");
        }



    }




}