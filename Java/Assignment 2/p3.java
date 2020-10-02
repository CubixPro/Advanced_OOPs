import java.io.BufferedReader;
import java.util.*;
import java.io.*;

//import javax.imageio.plugins.tiff.ExifTIFFTagSet;

class Book {
    int bookid;
    String title;

    Book() {

    }

    Book(int id, String t) {
        bookid = id;
        title = t;
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Book ID : ");
        bookid = sc.nextInt();
        sc.nextLine();
        System.out.print("Title : ");
        title = sc.nextLine();
        //sc.close();

    }

    void printBook() {
        System.out.println("Book ID : " + bookid + "\nTitle : " + title);
    }
}

class BookList {
    int size;
    int max_size;
    int bookids[];
    String titles[];
    int total_copies[];
    int available[];

    BookList(int s) {
        max_size = s;
        size = 0;
        bookids = new int[max_size];
        titles = new String[max_size];
        total_copies = new int[max_size];
        available = new int[max_size];
    }

    int existsID(int id) {
        for (int i = 0; i < size; i++) {
            if (id == bookids[i])
                return i;
        }
        return -1;
    }

    int addBook(Book b) {
        int val = existsID(b.bookid);
        if (val == -1) {
            System.out.println("Unique Book ID identified");
            if (size < max_size) {
                bookids[size] = b.bookid;
                titles[size] = b.title;
                total_copies[size] = 1;
                available[size] = 1;
                size++;
                return 1;
            } else {
                System.out.println("Cannot add anymore books");
                return -1;
            }
        } else {
            System.out.println("Book ID is not unique, book cannot be added to List");
            return -1;
        }
    }

    int addCopies(int id, int new_val) {
        int val = existsID(id);
        if (val == -1) {
            System.out.println("Book does not exist");
            return val;
        } else {
            available[val] += new_val;
            total_copies[val] += new_val;
            return 1;
        }
    }
    
    int addCopy(int id){
    	int val = existsID(id);
    	if(val != -1)
    	{
    		available[val]++;
    		return 1;
    	}
    	return -1;
    }

    int removeCopies(int id, int sub) {
        int val = existsID(id);
        if (val == -1) {
            System.out.println("Book does not exist");
            return val;
        } else {
            available[val] -= sub;
            if (available[val] < 0) {
                System.out.println("No more books left, cannot be issued/removed");
                return -1;
            }
            return 1;
        }

    }

    void displayBookInformation(int id) {
        int val = existsID(id);
        if (val != -1) {
            Book b = new Book(bookids[val], titles[val]);
            b.printBook();
        } else {
            System.out.print("Book does not Exist.\n");
        }
    }

    void displayList() {
        System.out.println("Book ID\tTitle\tCopies Left");
        for (int i = 0; i < size; i++) {
            System.out.println(bookids[i] + "\t" + titles[i] + "\t" + available[i]);
        }
    }

}

class Date {
    int day, month, year;
    Date(int a, int b, int c){
        day = a;
        month = b;
        year = c;
    }

    void print() {
        System.out.println(day + "/" + month + "/" + year);
    }


}

class Member {
    int memberid;
    String name;
    Date dob;
    int books;
    static int total_books = 5;

    Member() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Member ID : ");
        memberid = sc.nextInt();
        sc.nextLine();
        System.out.println("Name : ");
        name = sc.nextLine();
        books = 0;
        dob = new Date(1, 1, 2000);
        //sc.close();
    }

    Member(int id, String t, Date dob) {
        memberid = id;
        name = t;
        this.dob = dob;
        books = 0;
    }

    void printMember() {
        System.out.println("Member ID : " + memberid + "\nName : " + name + "\nBooks Issued : " + books);
        dob.print();
    }
}

class MemberList {
    int size;
    int max_size;
    Member members[];

    MemberList(int s) {
        max_size = s;
        s = 0;
        members = new Member[max_size];
        
    }

    int addBooks(int id) {
        int val = existsMember(id);
        if (members[val].books < Member.total_books) {
            members[val].books++;
            return 1;
        } else {
            System.out.println("Maximum books issued");
            return -1;
        }
    }

    int removeBooks(int id) {
        int val = existsMember(id);
        members[val].books--;
        return 1;
    }

    int existsMember(int x) {
        for (int i = 0; i < size; i++) {
            if (members[i].memberid == x) {
                return i;
            }

        }
        return -1;
    }

    int insertMember(Member m) {
        int val = existsMember(m.memberid);
        if (val == -1) {
            if (size < max_size) {
                members[size] = m;
                size++;
                return 1;
            } else {
                System.out.println("Member List is full");
                return -1;
            }
        } else {
            System.out.println("Member already exists");
            return -1;
        }
    }

    void displayList() {
        for (int i = 0; i < size; i++) {
            members[i].printMember();
        }
    }

    void displayMemberInformation(int val) {
        int id = existsMember(val);
        System.out.println(id);
        members[id].printMember();
    }
}

class Transaction {
    Member m;
    Book b;
}

class TransactionList {
    int bookids[];
    int memberids[];
    int max_size;
    int size;

    TransactionList(int s) {
        max_size = s;
        size = 0;
        memberids = new int[s];
        bookids = new int[s];
    }

    int addTransaction(int memid, int bookid) {
        if (size < max_size) {
            memberids[size] = memid;
            bookids[size] = bookid;
            size++;
            return 1;
        } else {
            System.out.println("Too many Transactions");
            return -1;
        }
    }

    int existsTransaction(int memid, int bookid) {
        for (int i = 0; i < size; i++) {
            if (memberids[i] == memid && bookids[i] == bookid) {
                return i;
            }
        }
        return -1;
    }

    int removeTransaction(int memid, int bookid) {
        int val = existsTransaction(memid, bookid);
        if (val == -1) {
            System.out.println("No such transaction\n");
            return -1;
        } else {
            memberids[val] = -9999;
            return 1;

        }
    }

}

class LibraryManagement {
    MemberList ml;
    BookList bl;
    TransactionList tl;

    LibraryManagement() {
        ml = new MemberList(10000);
        bl = new BookList(10000);
        tl = new TransactionList(10000);
    }

    void run() throws IOException{
        int choice = 10;
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(
                    "1. Add a new book to book list\n2. Add more copies for a book\n3. Show all the book details\n4. Show a book detail\n5. Issue a book\n6. Add a member\n7. Show all members\n8. Show a particular member\n9. Return a book");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
            case 1:
                Book b = new Book();
                b.input();
                bl.addBook(b);
                break;

            case 2:
                System.out.println("Book ID : ");
                int id = sc.nextInt();
                int final_val;
                System.out.println("How many more copies were added : ");
                final_val = sc.nextInt();
                bl.addCopies(id, final_val);
                break;
            case 3:
                bl.displayList();
                break;
            case 4:
                System.out.println("Book ID : ");
                int id1 = sc.nextInt();
                bl.displayBookInformation(id1);
                break;
            case 5:
                System.out.println("Member ID : ");
                int memid = sc.nextInt();
                System.out.println("Book ID : ");
                int id2 = sc.nextInt();
                if (ml.existsMember(memid) != -1) {
                   {
                   	if(ml.addBooks(memid) != -1){
                    	if(bl.existsID(id2) != -1){
                        if(bl.removeCopies(id2, 1)!= -1)
                        	tl.addTransaction(memid, id2);
                        }
                        else{
                        	System.out.println("Book does not exist\n");
                        	
                        }
                    }
			}
                } else {
                    System.out.println("Member does not exist");
                }
                break;
            case 6:
                Member m = new Member();
                ml.insertMember(m);
                break;
            case 7:
                ml.displayList();
                break;
            case 8:
                System.out.println("Member ID : ");
                int mem = sc.nextInt();
                ml.displayMemberInformation(mem);
                break;
            case 9:
                System.out.println("Member ID : ");
                int m1 = sc.nextInt();
                System.out.println("Book ID : ");
                int b1 = sc.nextInt();
                if (tl.removeTransaction(m1, b1) != -1) {
                    ml.removeBooks(m1);
                    bl.addCopy(b1);
                }
                break;
            default:
                System.out.println("Invalid Input\n");

            }
            

        } while (choice != -1);
        //sc.close();
    }

    public static void main(String args[]) throws IOException{
        LibraryManagement lm = new LibraryManagement();
        lm.run();
    }
}
