import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Student extends User{
    static Scanner scanner = new Scanner(System.in);
    String studentNum;
    String name;
    String mainCourse;
    ArrayList<Course> enrolledCourses;

    public Student(String username, String password, String role) {
        super(username, password, role);
        enrolledCourses = new ArrayList<Course>();
    }
    
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }
    
    public void viewAvailableCourses() {
        ArrayList<Course> availableCourses;
        availableCourses = Course.courses;
        
        if (availableCourses.isEmpty()) {
            System.out.println("\nNo available courses.\n");
            return;
        }
        
        System.out.println("\nList of available courses:");
        for (Course course : availableCourses) {
            System.out.printf("%s - %s (%d units)\n", course.getCourseCode(), course.getCourseName(), course.getUnits());
        }
        System.out.println("");
    }
    
    public void enrollInCourse(Student student) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        
        Course course;
        course = Course.findCourse(courseCode);
        
        if (course == null) {
            System.out.println("\nInvalid course code.\n");
            return;
        }
        
        student.enrollCourse(course);
        
        System.out.println("\nEnrollment successful.\n");
    }
    
    public void viewEnrolledCourses(Student student) {
        if (enrolledCourses.isEmpty()) {
            System.out.println("You are not currently enrolled in any courses.");
            return;
        }
        
        System.out.println("\nList of enrolled courses:");
        for (Course course : enrolledCourses) {
            System.out.printf("%s - %s (%d units)\n", course.getCourseCode(), course.getCourseName(), course.getUnits());
        }
        System.out.println("");
    }
    
    public void dropCourse(Student student) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        
        Course course = findCourse(courseCode);
        
        if (course == null) {
            System.out.println("\nInvalid course code.\n");
            return;
        }
        
        enrolledCourses.remove(course);
        
        System.out.println("\nDrop successful.\n");
    }

    Course findCourse(String courseCode) {
        for (Course course : enrolledCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void showDetails(Student student) {
        System.out.println("Student No.: " + student.studentNum);
        System.out.println("Name: " + student.name);
        System.out.println("Course: " + student.mainCourse);
        System.out.println("Username: " + student.username + "\n");
        
        if (enrolledCourses.isEmpty()) {
            System.out.println("You are not currently enrolled in any courses.\n");
            return;
        }
        
        System.out.println("List of enrolled courses:");
        for (Course course : enrolledCourses) {
            System.out.printf("%s - %s (%d units)\n", course.getCourseCode(), course.getCourseName(), course.getUnits());
        }
        System.out.println("");
    }
}
