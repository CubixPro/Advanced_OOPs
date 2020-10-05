import java.util.*;

class Student
{
	int roll;
	String name;
	double score;
	
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
	
	public void copy(Student s)
	{
		roll= s.roll;
		name= s.name;
		score= s.score;
	}
}

class Prog1_7
{
	public static void main(String args[])
	{
		Student s1= new Student();
		Student s2= new Student();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter student details (roll,name,score): ");
		int i=sc.nextInt();
		String s=sc.next();
		double d= sc.nextDouble();
		s1.set(i,s,d);
		System.out.println("Student 1: ");
		s1.show();
		s2.copy(s1);
		System.out.println("Student 2: ");
		s2.show();
	}
}