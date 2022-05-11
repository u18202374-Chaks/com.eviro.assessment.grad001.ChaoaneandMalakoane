import exception.AccountNotFoundException;
import exception.WithdrawalAmountTooLargeException;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.Before;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class Enviro_BankTest {

    SystemDB systemdb;
    BigDecimal amountowithdraw;
    BigDecimal withdrawaccount;

    BigDecimal amountwithdrawC;
    BigDecimal withdrawaccountC;
    /**
     *
     */
    @Before
    public void setUp(){
        systemdb =  SystemDB.Systemdb();
        amountowithdraw = new BigDecimal("5000");
        withdrawaccount = new BigDecimal("1000");
        amountwithdrawC = new BigDecimal("5000");
        withdrawaccountC = new BigDecimal("20000");
    }
    @Test
    @Description("The withdrawal amount is greater than the balance for savings account")
    public void testThrowsWithdrawalAmountTooLargeExceptionSavingsAccount(){
        assertThrows(WithdrawalAmountTooLargeException.class,()->systemdb.s1.withdraw(systemdb.s1.accounnum,amountowithdraw));
    }

    @Test
    @Description("The account number does not exist in the database for savings account")
    public void testAccountNotFoundException(){
        assertThrows(AccountNotFoundException.class,()->systemdb.s1.withdraw(2, withdrawaccount));
    }

    @Test
    @Description("The balance of the withdrawal changes from savings")
    public void testWithdrawalChangesSavingsAccount() throws WithdrawalAmountTooLargeException, AccountNotFoundException {
        BigDecimal expected;
        expected = new BigDecimal("1000");
        assertEquals(expected,systemdb.s1.withdraw(systemdb.s1.accounnum, withdrawaccount));
    }


    @Test
    @Description("The balance withdrawal amount of current account changes")
    public void testWithdrawalChangesCurrentAccount() throws WithdrawalAmountTooLargeException, AccountNotFoundException {
        BigDecimal expected;
        expected = new BigDecimal("10000");
        assertEquals(expected,systemdb.c2.withdraw(systemdb.c2.accounnum,amountwithdrawC));
    }

    @Test
    @Description("The balance withdrawal amount of current account changes")
    public void testThrowsWithdrawalAmountTooLargeExceptionCurrentAccount() throws WithdrawalAmountTooLargeException, AccountNotFoundException {
        assertThrows(WithdrawalAmountTooLargeException.class,()->systemdb.c2.withdraw(systemdb.c2.accounnum,withdrawaccountC));
    }
    @Test
    @Description("The account number does not exist in the database for current account")
    public void testAccountNotFoundExceptionCurrentAccount(){
        assertThrows(AccountNotFoundException.class,()->systemdb.c2.withdraw(23, withdrawaccount));
    }







}
