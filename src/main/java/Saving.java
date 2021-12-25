import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Saving extends BankAccount{


    static ArrayList <Integer> record1= new ArrayList();
    static ArrayList<BankAccount> record= new ArrayList();


    public Saving(String fn,String ln,String address,int accno,int balance,String phoneno,int type)
    {

        super(fn,ln,address,accno,balance,phoneno,type);
    }

    public int makeDeposit(int cash)
    {
        Scanner deposit=new Scanner(System.in);

        balance=(getBalance()+cash);
        setBalance(balance);
        record1.add(balance);
        System.out.println("Balance: "+getBalance());
        return getBalance();

    }


    public int makeWithdrawl(int withcash)
    {
        Scanner withdrawl= new Scanner(System.in);
        balance=(balance-withcash);
        setBalance(balance);
        record1.add(balance);
        System.out.println("Balance: "+getBalance());
        return getBalance();
    }

    public void DisplayBalance()
    {
        System.out.println("First Name: " +fname);
        System.out.println("Last Name: "+lname);
        System.out.println("Address: "+address);
        System.out.println("Phone No: "+phoneno);
        System.out.println("Account No: "+accno);
        LocalDateTime date=LocalDateTime.now()	;
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formatdate=date.format(myFormatObj);
        System.out.println("Creation Date: "+formatdate);
        System.out.println("Current Balance: "+balance);
    }

    public void AllDeductions()
    {
        System.out.println("--------------------");
        System.out.println("Your Account History: ");

        for (int i=0;i<record.size();i++)
        {
            System.out.println("New Amount was: "+record.get(i));
        }
        System.out.println("--------------------");
    }



    public int calculateZakat(int zakat)
    {
        zakat=(int)(balance*0.25);
        if(getBalance()>=20000)
        {
            balance -= zakat;
            setBalance(balance);
            System.out.println("Zakat has been deducted");
            System.out.println("Now balance left: "+getBalance());

        }

        else if(getBalance()<20000)
        {
            System.out.println("Insufficent Balance for Zakat");
        }
        return getBalance();
    }

    public int calculateInterest(int interest)
    {
        interest=60;
        if(getBalance()>=5000)
        {
            //	Random rand= new Random();
            //int upperlimit=3000;

            int interestrate=(int)((interest*5.50)/2);
            int balance=getBalance()+interestrate;
            setBalance(balance);
            System.out.println("Current Interest Rate: "+interestrate);
            System.out.println("Balance after interest rate: "+balance);

        }
        return balance;
    }

    public void TransferAmount()
    {
        int transamount;
        Scanner input1= new Scanner(System.in);
        System.out.println("Enter your Account Number: ");
        int acc1=input1.nextInt();
        System.out.println("Enter Account Number in which amount has to be transferred: ");
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
                int balance1=record.get(k).getBalance()+transamount;
                record.get(k).setBalance(balance1);
            }
        }
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
