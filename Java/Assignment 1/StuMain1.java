import java.util.Scanner;

class Stu
{
	int roll;
	String name;
	double score;
	
	public Stu()
	{
		roll=0;
	}
	
	public Stu(int r)
	{
		roll=r;
	}
	
	public Stu(int r, String n)
	{
		roll=r;
		name=n;
	}
	
	public Stu(int r, String n, double s)
	{
		roll=r;
		name=n;
		score=s;
	}
	
	public Stu(Stu s)
	{
		roll=s.roll;
		name=s.name;
		score=s.score;
	}
	
	public void set(int r, String n, double s)
	{
		roll=r;
		name=n;
		score=s;
	}
	
	public void show()
	{
		System.out.println("Roll: "+roll);
		System.out.println("Name: "+name);
		System.out.println("Score: "+score);
	}

}

class StuMain1
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter student details (roll,name,score): ");
		int i=sc.nextInt();
		String s=sc.next();
		double d= sc.nextDouble();
		Stu s1= new Stu();
		Stu s2= new Stu(i);
		Stu s3= new Stu(i,s);
		Stu s4= new Stu(i,s,d);
		Stu s5= new Stu(s4);
		System.out.println("Student 1: ");
		s1.show();
		System.out.println("Student 2: ");
		s2.show();
		System.out.println("Student 3: ");
		s3.show();
		System.out.println("Student 4: ");
		s4.show();
		System.out.println("Student 5: ");
		s5.show();
		s4.set(i+1, s, d);
		if(s4.roll==s5.roll)
			System.out.println("Shallow copy");
		else
			System.out.println("Deep copy");
	}
}