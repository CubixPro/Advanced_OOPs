import java.util.*;

class Department{
    String code;
    String location;
    String name;



    public Department() {}

    public Department(String code, String location, String name) {
        this.code = code;
        this.location = location;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department code(String code) {
        this.code = code;
        return this;
    }

    public Department location(String location) {
        this.location = location;
        return this;
    }

    public Department name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Department)) {
            return false;
        }
        Department department = (Department) o;
        return Objects.equals(code, department.code) && Objects.equals(location, department.location) && Objects.equals(name, department.name);
    }


    @Override
    public String toString() {
        return "DeptCode = " + getCode() + "\nLocation = " + getLocation() + "\nName = " + getName() ;

    }

    public void getData(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Enter department code: ");
        String code = sc1.nextLine();
        System.out.print("Enter department location: ");
        String location = sc2.nextLine();
        System.out.print("Enter department name: ");
        String name = sc3.nextLine();
        setName(name);
        setCode(code);
        setLocation(location);
    }


    void display(){
        System.out.println(this);
    }


}


class Employee{
    String code;
    String name;
    int basic;
    String dept_code;

    public Employee() {
    }

    public Employee(String code, String name, int basic, String dept_code) {
        this.code = code;
        this.name = name;
        this.basic = basic;
        this.dept_code = dept_code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasic() {
        return this.basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public String getDept_code() {
        return this.dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public Employee code(String code) {
        this.code = code;
        return this;
    }

    public Employee name(String name) {
        this.name = name;
        return this;
    }

    public Employee basic(int basic) {
        this.basic = basic;
        return this;
    }

    public Employee dept_code(String dept_code) {
        this.dept_code = dept_code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(code, employee.code) && Objects.equals(name, employee.name) && basic == employee.basic && Objects.equals(dept_code, employee.dept_code);
    }

    @Override
    public String toString() {
        return "Code = " + getCode() + "\nName = " + getName() + "\nBasic pay = " + getBasic() + "\nDept code = " + getDept_code();
    }

    public void getData(){
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        System.out.print("Enter employee code\n");
        String code = sc1.nextLine();
        System.out.print("Enter employee name\n");
        String name = sc2.nextLine();
        System.out.print("Enter basic pay\n");
        int basic = sc3.nextInt();
        System.out.print("Enter department code\n");
        String dept_code = sc4.nextLine();
        setName(name);
        setBasic(basic);
        setCode(code);
        setDept_code(dept_code);
    }

    public void show()
    {
        System.out.println(this);
    }

}

class Dept_List{
    ArrayList<Department> arr;
    public Dept_List() {
        arr = new ArrayList<Department>();
    }
    void add(){
        Department d = new Department();
        for ( int i = 0 ; i < arr.size() ; i++ ){
            if ( arr.get(i).getCode().equals(d.getCode())){
                System.out.println("Not unique department!! Try agian!!");
            }
        }
        d.getData();
        arr.add(d);
    }

    void show( String code){
        for ( int  i = 0 ; i < arr.size() ; i ++ ){
            if ( arr.get(i).getCode().equals(code)){
                arr.get(i).display();
            }
        }
        System.out.println("Not found");
    }

    void calTotalPay(Emp_List e , String code){
        int f =0;
        for ( int i =0 ; i < arr.size() ; i ++ ){
            if ( arr.get(i).getCode().equals(code)){
                f = 1;
                break;
            }
        }
        if ( f == 0){
            System.out.println("wrong code");
            return ;        }
        int sum = 0;
        for ( int i = 0 ; i < e.arr.size() ; i++ ){
            if ( e.arr.get(i).getDept_code().equals(code)){
                sum += e.arr.get(i).getBasic();
            }
        }
        System.out.println("Total pay: "+ sum);
    }
}

class Emp_List{
    ArrayList<Employee> arr;
    public Emp_List(){
        arr = new ArrayList<Employee>();
    }

    void add(){
        Employee d = new Employee();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode() == d.getCode()) {
                System.out.println("Employee exists!!!");
            }
        }
        d.getData();
        arr.add(d);
    }

    void display( String code){
        for ( int i = 0; i < arr.size() ; i++){
            if ( arr.get(i).getCode().equals(code) ){
                arr.get(i).show();
                Dept_List d = new Dept_List();
                d.show(arr.get(i).getDept_code());
                return ;
            }
        }
    }
    void displayAll(){
        for ( int i =0 ; i  < arr.size() ; i ++ ){
            System.out.println(arr.get(i));
        }
    }

    void remove( String code){
        for ( int i =0 ; i < arr.size() ; i++){
            if ( arr.get(i).getCode().equals(code)){
                arr.remove(i);
                return;
            }
        }
        System.out.println("Employee Not present!! Terminating!!");
    }

    void modify( String code , int new_basic){
        for ( int i =0 ; i < arr.size() ; i++){
            if ( arr.get(i).getCode().equals(code)){
                arr.get(i).setBasic(new_basic);
                return;
            }
        }
        System.out.println("Employee Not found!! Try again!!");
    }
}



class s3p1{
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Emp_List e = new Emp_List();
        Dept_List d = new Dept_List();
        while(true){
            System.out.println("....................................................................");
            System.out.println("1 add a new Employee");
            System.out.println("2 Add a new department");
            System.out.println("3 Display all the employee details");
            System.out.println("4 Find total basic pay for a department");
            System.out.println("5 Remove an employee");
            System.out.println("6.Modify basic pay of an employee");
            System.out.println("7.exit");
            System.out.println("....................................................................");
            //System.out.println("6 Sort employees");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    e.add();
                    break;
                case 2:
                    d.add();
                    break;
                case 3:
                    e.displayAll();
                    break;
                case 4:
                {
                    System.out.print("Enter code\n");
                    Scanner sc1 = new Scanner(System.in);
                    
                    String code = sc1.nextLine();
                    
                    d.calTotalPay(e, code);
                    break;
                }
                case 5:
                {
                    System.out.print("Enter employee code\n");
                    Scanner sc2 = new Scanner(System.in);
                    String code = sc2.nextLine();
                    
                    e.remove(code);
                    break;
                }
                case 6:
                {   
                    System.out.print("Enter employee code\n");
                    Scanner sc3 = new Scanner(System.in);
                    String code = sc3.nextLine();
                    Scanner sc4 = new Scanner(System.in);
                    int new_basic = sc4.nextInt();
                    
                    e.modify(code,new_basic);
                    break;
                }
                case 7:
                {
                    break;
                }
                default:
                    System.out.println("Wrong entry!! try again!!");
                    break;
            }
            

            // System.out.println("Enter 7 to exit");
            // char c = sc.next().charAt(0);
            // if ( c == '7')
            //     break;
        }

     }
}