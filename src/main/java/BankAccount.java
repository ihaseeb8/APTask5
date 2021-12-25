import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class BankAccount {
    protected String fname;
    protected String lname;
    protected String address;
    protected int accno;
    protected int balance;
    protected int type;
    //protected String date;
    protected String phoneno;



    public BankAccount(String fn,String ln,String add, int acc,int bal,String phn, int typ) {
        // TODO Auto-generated constructor stub
        this.fname=fn;
        this.lname=ln;
        this.address=add;
        this.accno=acc;
        this.balance=bal;
        this.type=typ;
//	this.date=date;
        this.phoneno=phn;
    }

    public String getFName()
    {
        return fname;
    }

    public String getLName()
    {
        return lname;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhoneNo()
    {
        return phoneno;
    }

    public int getAccNo()
    {
        return accno;
    }

    public int getBalance()
    {
        return balance;
    }

    public int getType()
    {
        return type;
    }

//	public String getDate()
    //{
    //return date;
    //}

    public void setFName(String fn)
    {
        fname=fn;
    }

    public void setLName(String ln)
    {
        lname=ln;
    }

    public void setAddress(String add)
    {
        address=add;
    }

    public void setPhoneNo(String phn)
    {
        phoneno=phn;
    }

    public void setAccNo(int acc)
    {
        accno=acc;
    }

    public void setBalance(int bal)
    {
        balance = bal;
    }

    public void setType(int typ)
    {
        type=typ;
    }

    //public void setDate(String dat)
    //{
    //date=dat;
    //}
    public void DisplayDetails()
    {

        System.out.println("First Name: "+fname);
        System.out.println("Last Name: "+lname);
        System.out.println("Address: "+address);
        System.out.println("Phone Number: "+phoneno);
        System.out.println("Bank Account type 1.Checking 2.Savings : "+type);
        System.out.println("Account Number: "+accno);
        System.out.println("Current Balance: "+balance);
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String formatdate=date.format(myFormatObj);
        System.out.println("Account Created on: "+formatdate);

    }



}