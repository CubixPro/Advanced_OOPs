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
    int maxSize;
    int size;
    Dept[] list;

    public DeptList(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        list = new Dept[maxSize];
    }

    public boolean isPresent(String deptCode) {
        for (int i = 0; i < size; i++) {
            if(list[i].deptCode.equals(deptCode)) {
                return true;
            }
        }
        return false;
    }

    public void add(Dept obj) {
        if(!isPresent(obj.deptCode)) {
            list[size++] = obj;
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
    int maxSize;
    int size;
    Emp[] list;

    public EmpList(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        list = new Emp[maxSize];
    }

    public boolean isUsed(String empCode) {
        for(int i = 0; i < size; i++) {
            if(list[i].empCode.equals(empCode)) {
                return true;
            }
        }
        return false;       
    }

    public void add(Emp obj , DeptList dlist) {
        if(!isUsed(obj.empCode) && dlist.isPresent(obj.deptCode)) {
            list[size++] = obj;
        }
    }

    public void printEmp(String empCode) {
        if(!isUsed(empCode)) {
            System.out.println("Employee not found!!\n");
        }
        for(int i = 0; i < size; i++) {
            if(list[i].empCode.equals(empCode)) {
                System.out.println(list[i]);
                break;
            }
        }
    }

    public void printAll() {
        for(int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }

    public float totalBasic(String deptCode) {
        float res = 0;
        for(int i = 0; i < size; i++) {
            if(list[i].deptCode.equals(deptCode)) {
                res = res + list[i].basic;
            }
        }
        return res;
    }

    public void remove(String empCode) {
        if(!isUsed(empCode)) return;

        for(int i = 0 , k = 0; i < size; i++) {
            if(list[i].empCode.equals(empCode)) continue;
            else {
                list[k] = list[i];
                k++;
            }
        }
        list[size-1] = null;
        size--;
    }

    public void modifyBasic(String empCode , float basic) {
        if(!isUsed(empCode)) return;

        for(int i = 0; i < size; i++) {
            if(list[i].empCode.equals(empCode)) {
                list[i].updateBasic(basic);
                break;
            }
        }
    }

    public void sortByBasic() {
        Arrays.sort(list, 0, size, new BasicCmp());
    }

    public void sortByEmpCode() {
        Arrays.sort(list, 0, size, new EmpCodeCmp());
    }

    public void sortByDeptCode() {
        Arrays.sort(list, 0, size,  new DeptCodeCmp());
    }
}

public class Prog3_1a {
    public static void main(String[] args) {
        Dept d1 = new Dept();
        d1.getData();

        Emp e1  = new Emp(), e2 = new Emp();
        e1.getData();
        e2.getData();

        DeptList dlist = new DeptList(100);
        dlist.add(d1);
        EmpList elist = new EmpList(100);
        elist.add(e1 , dlist);
        elist.add(e2 , dlist);

        elist.sortByBasic();
        elist.printAll();
    }
}