import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;
import java.io.*;


class Course implements Serializable {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Course> courses = new ArrayList<>();
    String courseCode;
    String courseName;
    int units;
    
    public Course(String courseCode, String courseName, int units) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.units = units;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getUnits() {
        return units;
    }
    
    public void addCourse(Course course) {
        courses.add(course);
    }
    
    public static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
