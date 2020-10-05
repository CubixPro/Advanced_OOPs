import java.util.*; 

class Account{
	private	int accno;
	private String name;
	private double balance;
	Account(int code)
	{
	  accno=code;
	}
	Account(Account A)
       {
         accno=A.retaccno();
         balance=A.retbalance();
         name=A.retname();
       }
	Account(int accno,String name,double balance)
	{
	  this.accno=accno;
	  this.name=name;
	  this.balance=balance;
	}
	public int retaccno()
	{
	  return accno;
	}
	public double retbalance()
	{
	  return balance;
	}
    public String retname()
    {
         return name;
	}

	public void display()
	{
	  System.out.println(this);
	}
	public String toString()
	{
	return("\nAccount number: "+accno+"\nName: "+name+" \nBalance: "+balance+"\n");
	}
	public boolean equals(Account t)
	{
	  if(t.accno==accno)
	   return true;
	else
	return false;
	}
}
public class s3p2{
	public static void main(String args[])
	{	
		HashMap<Integer,Account> h=new HashMap();
		int code;
		double balance;
		String name=new String(); 	
		Scanner S=new Scanner(System.in);
		Scanner S1=new Scanner(System.in);
		while(true)
		{
	        System.out.println("Press 1 to create the Account list");
	        System.out.println("Press 2 to display details of an account");
	        System.out.println("Press 3 to display all accounts");
	        System.out.println("Enter your choice");
	        int choice=S.nextInt();
			switch(choice)
			{
		        case 1:
		        System.out.println("Enter the name");
		        name=S1.nextLine();
				System.out.println("Enter the code");
				code=S.nextInt();
		        System.out.println("Enter the balance ammount");
				balance=S.nextDouble();
				Account A=new Account(code,name,balance);
		        h.put(code,A);
		        break;
				case 2:
				System.out.println("Enter the code");
				code=S.nextInt();
				
				if(h.containsKey(code))
			    { 
						Account Acc=new Account(h.get(code));
						Acc.display();
				}
			    else{
			        System.out.println("The account does not exist");
				}
		        break;      
		       case 3:
		       Set <Map.Entry<Integer,Account>> s;
		       s = h.entrySet();
		       for(Map.Entry m:s){
		           	System.out.println(m.getValue());
		       }
		       break;
		       default:
		       System.exit(1);
			}
		}
	}
}

