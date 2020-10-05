import java.util.*;

class Dept {
    String deptCode;
    String deptName;
    String location;

    public Dept() {}

    public Dept(String deptCode , String deptName , String location) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.location = location;
    }

    public void getData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter DeptCode : ");
        deptCode = in.nextLine();
        System.out.print("Enter DeptName : ");
        deptName = in.nextLine();
        System.out.print("Enter Location : ");
        location = in.nextLine();
        System.out.print("\n");
    }
}

class Emp {
    String empCode;
    String empName;
    float basic;
    String deptCode;

    public Emp() {}

    public Emp(String empCode, String empName, float basic, String deptCode) {
        this.empCode = empCode;
        this.empName = empName;
        this.basic = basic;
        this.deptCode = deptCode;
    }

    public void getData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter EmpCode : ");
        empCode = in.nextLine();
        System.out.print("Enter EmpName : ");
        empName = in.nextLine();
        System.out.print("Enter Basic Pay : ");
        basic = Float.parseFloat(in.nextLine());
        System.out.print("Enter DeptCode : ");
        deptCode = in.nextLine();
        System.out.print("\n");
    }

    public void updateBasic(float basic) {
        this.basic = basic;
    }

    public String toString() {
        return "\nEmpCode: " + empCode + "\nEmpName: " + empName + "\nBasicPay: " + basic + "\nDeptCode: " + deptCode;
    }
}

class DeptList {
    LinkedList<Dept> list;

    public DeptList() {
        list = new LinkedList<>();
    }

    public boolean isPresent(String deptCode) {
        for(Dept dept : list) {
            if(dept.deptCode.equals(deptCode)) {
                return true;
            }
        }
        return false;
    }

    public void add(Dept obj) {
        if(!isPresent(obj.deptCode)) {
            list.add(obj);
        }
    }
}

class EmpCodeCmp implements Comparator<Emp> { 
    public int compare(Emp a, Emp b) { 
        return a.empCode.compareTo(b.empCode); 
    } 
}

class DeptCodeCmp implements Comparator<Emp> { 
    public int compare(Emp a, Emp b) { 
        return a.deptCode.compareTo(b.deptCode); 
    } 
}

class BasicCmp implements Comparator<Emp> { 
    public int compare(Emp a, Emp b) { 
        if(a.basic > b.basic) return -1;
        else if(a.basic < b.basic) return 1;
        else return 0; 
    } 
}

class EmpList {
    LinkedList<Emp> list;

    public EmpList() {
        list = new LinkedList<>();
    }

    public boolean isUsed(String empCode) {
        for(Emp emp : list) {
            if(emp.empCode.equals(empCode)) {
                return true;
            }
        }
        return false;       
    }

    public void add(Emp obj , DeptList dlist) {
        if(!isUsed(obj.empCode) && dlist.isPresent(obj.deptCode)) {
            list.add(obj);
        }
    }

    public void printEmp(String empCode) {
        if(!isUsed(empCode)) {
            System.out.println("Employee not found!!\n");
        }
        for(Emp emp : list) {
            if(emp.empCode.equals(empCode)) {
                System.out.println(emp);
                break;
            }
        }
    }

    public void printAll() {
        for(Emp emp : list) {
            System.out.println(emp);
        }
    }

    public float totalBasic(String deptCode) {
        float res = 0;
        for(Emp emp : list) {
            if(emp.deptCode.equals(deptCode)) {
                res = res + emp.basic;
            }
        }
        return res;
    }

    public void remove(String empCode) {
        if(!isUsed(empCode)) return;

        int index = -1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).empCode.equals(empCode)) {
                index = i;
                break;
            }
        }

        if(index != -1) list.remove(index);
    }

    public void modifyBasic(String empCode , float basic) {
        if(!isUsed(empCode)) return;

        for(int i = 0; i < list.size(); i++) {
            Emp obj = list.get(i);
            if(obj.empCode.equals(empCode)) {
                obj.updateBasic(basic);
                list.add(i, obj);
                list.remove(i+1);
                break;
            }
        }
    }

    public void sortByBasic() {
        Collections.sort(list, new BasicCmp());
    }

    public void sortByEmpCode() {
        Collections.sort(list, new EmpCodeCmp());
    }

    public void sortByDeptCode() {
        Collections.sort(list, new DeptCodeCmp());
    }
}

public class Prog3_1b {
    public static void main(String[] args) {
        Dept d1 = new Dept();
        d1.getData();

        Emp e1  = new Emp(), e2 = new Emp();
        e1.getData();
        e2.getData();

        DeptList dlist = new DeptList();
        dlist.add(d1);
        EmpList elist = new EmpList();
        elist.add(e1 , dlist);
        elist.add(e2 , dlist);

        elist.sortByBasic();
        elist.printAll();
    }
}