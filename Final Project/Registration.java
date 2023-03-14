import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Registration {
    static Scanner scanner = new Scanner(System.in);
    ArrayList<User> users;
    ArrayList<Student> students;
    ArrayList<Admin> admins;
    
    public Registration() {
        users = new ArrayList<User>();
        students = new ArrayList<Student>();
        admins = new ArrayList<Admin>();
    }
    
    public void registerStudent() {
        System.out.print("Enter Student No: ");
        String studentNum = scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Course: ");
        String mainCourse = scanner.nextLine();
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (userExists(username)) {
            System.out.println("Username already exists.");
            return;
        }
        
        Student student = new Student(username, password, "student");
        student.studentNum = studentNum;
        student.name = name;
        student.mainCourse = mainCourse;
        
        if (!register(student, "student")) {
            System.out.println("Registration failed. Please try again later.");
            return;
        }
        
        System.out.println("");
        System.out.println("Registration successful.");
    }
    
    public void registerAdmin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (userExists(username)) {
            System.out.println("Username already exists.");
            return;
        }
        
        Admin admin = new Admin(username, password, "admin");
        
        if (!register(admin, "admin")) {
            System.out.println("Registration failed. Please try again later.");
            return;
        }
        
        System.out.println("");
        System.out.println("Registration successful.");
    }
    
    public void addUser(User user, Student student, Admin admin, String role) {
        users.add(user);
        if(role.equals("student")){
            students.add(student);
        }
        if(role.equals("admin")){
            admins.add(admin);
        }
    }
    
    public boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean login(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }

    Student getCurrentStudent(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        return null;
    }
    
    Admin getCurrentAdmin(String username) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    boolean register(Admin admin, String admin0) {
        User newUser = new User(admin.username, admin.password, admin0);
        addUser(newUser, null, admin, admin0);
        return true;
    }

    boolean register(Student student, String student0) {
        User newUser = new User(student.username, student.password, student0);
        addUser(newUser, student, null, student0);
        return true;
    }

    ArrayList<User> getUsers() {
        return users;
    }

    ArrayList<Student> getStudents() {
        return students;
    }

    ArrayList<Admin> getAdmins() {
        return admins;
    }
}
