import java.util.*;
import java.io.*;

public class Admin extends User{
    static Scanner scanner = new Scanner(System.in);

    public Admin(String username, String password, String role) {
        super(username, password, role);
    }
    
    public void addCourse() {
        
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        
        System.out.print("Enter number of units: ");
        int units = scanner.nextInt();
        
        Course course = new Course(courseCode, courseName, units);
        Course.courses.add(course);
        System.out.println("\nCourse added successfully.\n");
    }
    
    public void viewCourses() {
        if (Course.courses.isEmpty()) {
            System.out.println("\nNo courses available.\n");
            return;
        }
        
        System.out.println("\nList of courses:");
        for (Course course : Course.courses) {
            System.out.printf("%s - %s (%d units)\n", course.getCourseCode(), course.getCourseName(), course.getUnits());
        }
        System.out.println("");
    }
}
