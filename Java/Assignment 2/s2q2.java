import java.util.Scanner;


class Address
{
    String premises_no;
    String street;
    String city;
    String pin;
    String state;

    Address()
    {
        premises_no = "";
        street = "";
        city = "";
        pin = "";
        state = "";
    }

    public void getDetails()
    {
        System.out.println("premises no: " + premises_no);
        System.out.println("Street no: " + street);
        System.out.println("city: " + city);
        System.out.println("pin no: " + pin);
        System.out.println("state: " + state);
    }

    public void setPremisesNo()
    {
        System.out.print("Enter Premises no: ");
        Scanner ip = new Scanner(System.in);
        this.premises_no = ip.nextLine();
    }

    public void setStreetNo()
    {
        System.out.print("Enter Street No: ");
        Scanner ip = new Scanner(System.in);
        this.street = ip.nextLine();
    }

    public void setCity()
    {
        System.out.print("Enter City: ");
        Scanner ip = new Scanner(System.in);
        this.city = ip.nextLine();
    }

    public void setState()
    {
        System.out.print("Enter State: ");
        Scanner ip = new Scanner(System.in);
        this.state = ip.nextLine();
    }

    public void setPin()
    {
        System.out.print("Enter Pin: ");
        Scanner ip = new Scanner(System.in);
        this.pin = ip.nextLine();
    }

    public void setDetails()
    {
        this.setPremisesNo();
        this.setStreetNo();
        this.setPin();
        this.setCity();
        this.setState();
    }

}
class Person
{
    String name;
    Address address;
    String phone;
    String email; 

    Person()
    {
        address = new Address();
    }
    public void setDetails()
    {
        this.setName();
        this.setPhone();
        this.setAddress();
        this.setEmail();
    }

    public void setName()
    {
        System.out.print("Enter name: ");
        Scanner ip = new Scanner(System.in);
        this.name = ip.nextLine();
    }

    public void setPhone()
    {
        System.out.print("Enter Phone number: ");
        Scanner ip = new Scanner(System.in);
        this.phone = ip.nextLine();
    }

    public void setEmail()
    {
        System.out.print("Enter Email ID: ");
        Scanner ip = new Scanner(System.in);
        this.email = ip.nextLine();
    }

    public void setAddress()
    {
        this.address.setDetails();
    }

    public void getDetails()
    {
        //System.out.println("##################################");
        System.out.println("\nName: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email ID: " + email);
        //System.out.println("Address:------");
        address.getDetails();
        //System.out.println("##################################");
    }
}

class Student extends Person
{
    String roll;
    String course;

    Student()
    {
        super();
        roll = "";
        course = "";
    }

    public void setDetails()
    {
        super.setDetails();
        System.out.println("Enter your roll no: ");
        Scanner ip = new Scanner(System.in);
        roll = ip.nextLine();
        System.out.println("Enter your course of study: ");
        course = ip.nextLine();
    }

    public void getDetails()
    {
        super.getDetails();
        System.out.println("Roll No: " + this.roll);
        System.out.println("Course Of Study: " + this.course);
    }
}

class Faculty extends Person
{
    String id;
    String specialization;

    Faculty()
    {
        super();
        this.id = "";
        this.specialization = "";
    }

    public void setDetails()
    {
        super.setDetails();
        System.out.print("Enter your Employee ID: ");
        Scanner ip = new Scanner(System.in);
        id = ip.nextLine();
        System.out.print("Enter your specialization : ");
        specialization = ip.nextLine();
    }

    public void getDetails()
    {
        super.getDetails();
        System.out.println("Emplyee ID: " + this.id);
        System.out.println("Subject of Specialization: " + this.specialization);
    }
}


public class Prog2_2
{
    public static void main(String args[])
    {
        Faculty f = new Faculty();
        Student s = new Student();

        System.out.println("Enter faculty details: ");
        f.setDetails();
        System.out.println("##################################");
        f.getDetails();
        System.out.println("##################################");

        System.out.println("Enter Stident details: ");
        s.setDetails();
        System.out.println("##################################");
        s.getDetails();
        System.out.println("##################################");
    }
}