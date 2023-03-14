import java.util.*;
import java.io.*;

public class EnrollmentSystem {
    static Scanner scanner = new Scanner(System.in);
    static Registration registration = new Registration();
    
    public static void main(String[] args) {
        loadCourses();
        loadUsers();
        
        while (true) {
            System.out.println("Welcome to the Enrollment System!");
            System.out.println("[1] Login");
            System.out.println("[2] Registration Module");
            System.out.println("[0] Exit");
            System.out.print("\nEnter choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registrationModule();
                    break;
                case 0:
                    saveCourses();
                    saveUsers();
                    System.out.println("Successfully saved system files.");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
    public static void login() {
        scanner.nextLine();
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("");
        
        if(registration.login(username, password, "student")){
            Student student;
            student = registration.getCurrentStudent(username);
            studentModule(student);
        }
        else if(registration.login(username, password, "admin")) {
            Admin admin;
            admin = registration.getCurrentAdmin(username);
            adminModule(admin);
        }
        else{
            System.out.println("Invalid username or password.\n");
            return;
        }
        
        
    }
    
    public static void loadCourses() {
        try {
            File myObj = new File("courses.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 1;
            String courseCode = "";
            String courseName = "";
            int units = 0;
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                if(counter == 1) {
                    myReader.nextLine();
                    courseCode = myReader.nextLine();
                    counter++;
                }
                else if(counter == 2) {
                    myReader.nextLine();
                    courseName = myReader.nextLine();
                    counter++;
                }
                else{
                    myReader.nextLine();
                    Course course = new Course(courseCode, courseName, Integer.parseInt(myReader.nextLine()));
                    Course.courses.add(course);
                    counter = 1;
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            
        }
    }
    
    public static void loadUsers() {
        try {
            File myObj = new File("users.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 1;
            String username = "";
            String password = "";
            String role = "";
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                if(counter == 1) {
                    myReader.nextLine();
                    username = myReader.nextLine();
                    counter++;
                }
                else if(counter == 2) {
                    myReader.nextLine();
                    password = myReader.nextLine();
                    counter++;
                }
                else{
                    myReader.nextLine();
                    role = myReader.nextLine();
                    if(role.equals("student")){
                        Student student = new Student(username, password, role);
                        registration.register(student, role);
                    }
                    else if(role.equals("admin")){
                        Admin admin = new Admin(username, password, role);
                        registration.register(admin, role);
                    }
                    counter = 1;
                }
            }
            myReader.close();
            myObj = new File("students.txt");
            myReader = new Scanner(myObj);
            myReader.nextLine();
            for (Student student : registration.students) {
                myReader.nextLine();
                student.studentNum = myReader.nextLine();
                myReader.nextLine();
                student.name = myReader.nextLine();
                myReader.nextLine();
                student.mainCourse = myReader.nextLine();
                myReader.nextLine();
                int courseCount = Integer.parseInt(myReader.nextLine());
                for (int i = 0; i < courseCount; i++) {
                    myReader.nextLine();
                    Course course;
                    course = Course.findCourse(myReader.nextLine());

                    student.enrollCourse(course);
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            
        }
    }
    
    public static void saveCourses() {
        try {
            FileWriter myWriter = new FileWriter("courses.txt");
            myWriter.write("Enrollment System Courses\n");
            for (Course course : Course.courses) {
                myWriter.write("Course Code:\n");
                myWriter.write(course.courseCode + "\n");
                myWriter.write("Course Name:\n");
                myWriter.write(course.courseName + "\n");
                myWriter.write("Units:\n");
                myWriter.write(course.units + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void saveUsers() {
        ArrayList<User> users = new ArrayList<>();
        users = registration.getUsers();
        ArrayList<Student> students = new ArrayList<>();
        students = registration.getStudents();
        ArrayList<Admin> admins = new ArrayList<>();
        admins = registration.getAdmins();
        
        try {
            FileWriter myWriter = new FileWriter("users.txt");
            myWriter.write("Enrollment System Users\n");
            for (User user : users) {
                myWriter.write("Username:\n");
                myWriter.write(user.username + "\n");
                myWriter.write("Password:\n");
                myWriter.write(user.password + "\n");
                myWriter.write("Role:\n");
                myWriter.write(user.role + "\n");
            }
            myWriter.close();
            myWriter = new FileWriter("admins.txt");
            myWriter.write("Enrollment System Admins\n");
            for (Admin admin : admins) {
                myWriter.write("Username:\n");
                myWriter.write(admin.username + "\n");
                myWriter.write("Password:\n");
                myWriter.write(admin.password + "\n");
            }
            myWriter.close();
            myWriter = new FileWriter("students.txt");
            myWriter.write("Enrollment System Admins\n");
            for (Student student : students) {
                myWriter.write("Student Number:\n");
                myWriter.write(student.studentNum + "\n");
                myWriter.write("Name:\n");
                myWriter.write(student.name + "\n");
                myWriter.write("Course:\n");
                myWriter.write(student.mainCourse + "\n");
                myWriter.write("Enrolled Courses:\n");
                myWriter.write(student.enrolledCourses.size() + "\n");
                for (Course course : student.enrolledCourses) {
                    myWriter.write("Course Code:\n");
                    myWriter.write(course.courseCode + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void adminModule(Admin admin) {
        while (true) {
            System.out.println("Admin/Faculty Module");
            System.out.println("[1] Add Course");
            System.out.println("[2] View Courses");
            System.out.println("[0] Go back");
            System.out.print("\nEnter choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    admin.addCourse();
                    break;
                case 2:
                    admin.viewCourses();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
    public static void studentModule(Student student) {
        while (true) {
            System.out.println("Student Module");
            System.out.println("[1] View Available Courses");
            System.out.println("[2] Enroll in Course");
            System.out.println("[3] View Enrolled Courses");
            System.out.println("[4] Drop Course");
            System.out.println("[5] View Student Details");
            System.out.println("[0] Go back");
            System.out.print("\nEnter choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    student.viewAvailableCourses();
                    break;
                case 2:
                    student.enrollInCourse(student);
                    break;
                case 3:
                    student.viewEnrolledCourses(student);
                    break;
                case 4:
                    student.dropCourse(student);
                    break;
                case 5:
                    student.showDetails(student);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
    public static void registrationModule() {
        while (true) {
            System.out.println("\nRegistration Module");
            System.out.println("[1] Register as Student");
            System.out.println("[2] Register as Admin/Faculty");
            System.out.println("[0] Go back");
            System.out.print("\nEnter choice: ");
            
            int choice = scanner.nextInt();
            System.out.println("");
            
            switch (choice) {
                case 1:
                    registration.registerStudent();
                    break;
                case 2:
                    registration.registerAdmin();
                    break;
                case 0:
                    System.out.println("");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
