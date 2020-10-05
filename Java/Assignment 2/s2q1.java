import java.lang.reflect.Constructor;
import java.util.Scanner;

class Customer
{
    String customerID;
    String name;
    String phoneNumber;
    static final Long creditLimit = 6000000;
    Long totalLoan;

    public Customer()
    {
        totalLoan = 0;
    }

    void setDetails()
    {
        System.out.print("Enter Customer name: ");
        Scanner ip = new Scanner(System.in);
        this.name = ip.nextLine();
        System.out.print("Enter Customer ID: ");
        this.customerID = ip.nextLine();
        System.out.print("Enter Customer phone number: ");
        this.phoneNumber = ip.nextLine();
    }

    void showDetails()
    {
        System.out.println("Customer name: " + name);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer phone number: " + phoneNumber);
        System.out.println("Credit Limit: "+ creditLimit);
        System.out.println("Total loan can be credited: " +(creditLimit-totalLoan));

    }

    void creditLoan()
    {
        int loan;
        System.out.print("Enter your required loan amount: ");
        Scanner ip = new Scanner(System.in);
        loan = ip.nextInt();
        if(totalLoan+loan >= creditLimit)
        {
            System.out.println("CreditLimit reached!! Loan cannot be credited!!!");
        }
        else
        {
            totalLoan = totalLoan + loan;
            System.out.println("Loan credited!!! Enjoy your day!!!");
    }

}

public class s2q1
{
    public static void main (String args[])
    {
        Customer[] c;
        c = new Customer[10];
        int i;
        for(i=0;i<10;i++)
        {
            c[i] = new Customer();
            c[i].setDetails();
            c[i].creditLoan();
        }

    }
}