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




}