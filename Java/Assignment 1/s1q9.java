import java.util.Scanner;

class BankAcc
{
    String accNo;
    long balance;
    double rate = 4.50;

    public BankAcc(String accNo, long balance, double rate )
    {
        this.accNo = accNo;
        this.balance = balance;
        this.rate = rate;
    }

    void displayRate()
    {
        System.out.println("Interest rate is: " + rate + "% :)");
    }

    void setRate(double rate )
    {
        this.rate = rate;
    }

    void calculateInterest()
    {
        double time;
        System.out.print("Enter time(in year): ");
        Scanner ip = new Scanner(System.in);
        time = ip.nextDouble();
        double money = (balance*time*rate)/100; 
        System.out.println("Interest is: " + money);
        //ip.close();
    }
}

public class s1q9
{
    public static void main(String args[])
    {
        BankAcc b;
        b = new BankAcc("abc123456",100000,6.25);
        b.calculateInterest();
        b.setRate(9.25);
        b.calculateInterest();

    }
}


