import java.math.BigDecimal;

public class SystemDB{

    private static SystemDB systemdb = null;


    BigDecimal bg;
    BigDecimal bg1;

    BigDecimal b;
    BigDecimal b1;

    BigDecimal bgg;
    BigDecimal bgg1;

    public  SavingsAccount s1;
    public  SavingsAccount s2;
    public  CurrentAccount c1;
    public  CurrentAccount c2;


    private SystemDB()
    {

        bg  = new BigDecimal("2000");
        bg1 = new BigDecimal("5000");


        b= new BigDecimal("1000");
        b1 = new BigDecimal("100000");


        bgg= new BigDecimal("-5000");
        bgg1= new BigDecimal("20000");

        s1 = new SavingsAccount("CUS101",101,1,bg);
        s2 = new SavingsAccount("CUS102",102,2,bg1);

        c1 = new CurrentAccount("CUS201",103,3,b,b1);
        c2 = new CurrentAccount("CUS202",104,4,bgg,bgg1);


    }
    public static SystemDB Systemdb()
    {
        if(systemdb==null){
            systemdb = new SystemDB();
        }
        return systemdb;
    }

}