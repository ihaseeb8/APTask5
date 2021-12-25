import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Checking extends BankAccount {

    static ArrayList <BankAccount> record = new ArrayList();
    static ArrayList<Integer> record1=new ArrayList();

    int Transfee=10;

    public Checking(String fn,String ln,String address,int accno,int balance,String phoneno,int type)
    {

        super(fn,ln,address,accno,balance,phoneno,type);
    }

    static int count=0;
    public int makeDeposit(int cash)
    {
        Scanner deposit=new Scanner(System.in);

        balance=(getBalance()+cash)-Transfee;
        setBalance(balance);
        record1.add(balance);
        System.out.println("Balance: "+getBalance());
        count++;
        return getBalance();

    }


    public int makeWithdrawl(int withcash)
    {
        Scanner withdrawl= new Scanner(System.in);
        //System.out.println("Enter Amount to Withdraw");
        //withcash=withdrawl.nextInt();

        if(withcash<=getBalance())
        {
            balance=(balance-withcash)-Transfee;
            setBalance(balance);
            record1.add(balance);
            System.out.println("Balance: "+getBalance());
            count++;
            return getBalance();

        }

        else
        {
            System.out.println("Amount Exceeded from 5000");
        }
        return getBalance();
    }

    public void DisplayBalance()
    {
        System.out.println("First Name: " +fname);
        System.out.println("Last Name: "+lname);
        System.out.println("Address: "+address);
        System.out.println("Phone No: "+phoneno);
        System.out.println("Account No: "+accno);
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formatdate=date.format(myFormatObj);
        System.out.println("Creation Date: "+formatdate);
        System.out.println("Current Balance: "+balance);
    }

    public void AllDeductions()
    {
        System.out.println("Your record History: ");

        for (int i=0;i<record.size();i++)
        {
            System.out.println("New Amount is: "+record.get(i));
        }
        System.out.println("--------------------");
        System.out.println("Transactions Made: "+count);
        System.out.println("Deduction made upon your transactions is 10Rs: "+(10*count));
        System.out.println("--------------------");
    }

    public void TransferAmount()
    {
        int transamount;
        Scanner input1= new Scanner(System.in);
        System.out.println("Enter your account Number: ");
        int acc1=input1.nextInt();
        System.out.println("Enter account Number in which amount has to be transferred: ");
        int acc2=input1.nextInt();

        System.out.println("Enter Amount to Transfer: ");
        transamount=input1.nextInt();

        for(int j=0;j<record.size();j++)
        {
            if(record.get(j).getAccNo()==acc1)
            {
                int bal=record.get(j).getBalance()-transamount;
                record.get(j).setBalance(bal);
            }
        }

        for(int k=0;k<record.size();k++)
        {
            if(record.get(k).getAccNo()==acc2)
            {
                int balance=record.get(k).getBalance()+transamount;
                record.get(k).setBalance(balance);
            }
        }

        //return true;
        System.out.println("Amount Has Been Trasnferred Successfully!");

    }




    public int generateRandNo()
    {
        Random rand=new Random();
        int upperbound=1000;
        int accno=rand.nextInt(upperbound);
        //	System.out.println("record Number: "+accno);
        return accno;
    }

}
