import java.util.*;

class Instructor{
	String name;
	int phno;
	
	void view(){
		System.out.println("Name: "+ name + "\nContact: "+ phno);
	}
	void set(){
		Scanner sc = new Scanner(System.in);
		name = sc.next();
		System.out.println("Enter phone number : ");
		phno = sc.nextInt();
	}
}
class Textbook{
	String title;
	String name;
	String publisher;
	void view(){
		System.out.println("Title: "+ title + "\nName: " + name + "\nPublisher: " + publisher);
	}
	void set(){
		Scanner sc = new Scanner(System.in);
		title = sc.next();
		name = sc.next();
		publisher = sc.next();
	}
}

class Course{
	Instructor ins;
	Textbook t;
	Course(){
		ins = new Instructor();
		t = new Textbook();
	}
	void view(){
		t.view();
		ins.view();
	}
	void set(){
		t.set();
		ins.set();
	}
	public static void main(String args[]){
		Course c = new Course();
		c.set();
		c.view();
	}
}
