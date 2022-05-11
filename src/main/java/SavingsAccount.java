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




}
