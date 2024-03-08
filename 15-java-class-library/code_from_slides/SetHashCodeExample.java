import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private Integer ID;
    private ArrayList<Double> grades;
    public Student(String firstName, String lastName, Integer ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.grades = new ArrayList<>();
    }
    public void addGrades(Double... grades) { // grades is an array
        for(Double grade : grades) this.grades.add(grade);
    }
    public Double[] grades() {
        return grades.toArray(new Double[grades.size()]);
    }
    @Override // Comparable interface
    public int compareTo(Student s) {
        int result = lastName.compareTo(s.lastName);
        if(result == 0) result = firstName.compareTo(s.firstName);
        if(result == 0) result = ID.compareTo(s.ID);
        return result;
    }
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;     // Is it me?
        if(o == null                   // Is it my type?
          || ! (o instanceof Student)) return false;
        Student s = (Student) o;       // Downcast to my type
        return compareTo(s) == 0;  // Compare significant fields
    }
    @Override
    public int hashCode() {         // If s1.equals(s2), then MUST have same hashCode
        return Objects.hash(ID, firstName, lastName); // Thus SAME fields as equals
    }
    @Override
    public String toString() {
        double sum = 0;
        for(double grade : grades) sum += grade;
        return String.format("%s %s (%d, %3.1f average)", 
                  firstName, lastName, ID, sum / grades.size());
    }
}

public class SetHashCodeExample {
    private static Scanner in = new Scanner(System.in);
    private static String getString(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        Student s = new Student("Fred", "Flintstone", 1002391);
        s.addGrades(82.0, 91.0, 66.0, 102.0, 98.0);
        students.add(s);
        s = new Student("Barney", "Rubble", 1001134);
        s.addGrades(58.0, 62.0, 71.0, 59.0, 91.0, 88.0, 89.0, 76.0);
        students.add(s);
        s = new Student("Wilma", "Flintstone", 1001912);
        s.addGrades(91.0, 93.0, 88.0, 90.0);
        students.add(s);
        s = new Student("Betty", "Rubble", 1002201);
        s.addGrades(92.0, 103.0, 98.0, 101.0);
        students.add(s);
/*        while(true) {
            try {
                String firstName = getString("Enter first name: ");
                if(firstName.isEmpty()) break;
                String lastName = getString("Enter last name: ");
                Integer ID = Integer.parseInt(getString("Enter ID: "));
                s = new Student(firstName, lastName, ID);
                System.out.print("Enter grades (-1 when done): ");
                while(true) {
                    double grade = in.nextDouble();
                    if(grade < 0) break;
                    s.addGrades(grade);
                }
                getString(""); // Remove final newline
                students.add(s);
                System.out.println("Added: " + s);
            } catch(Exception e) {
                System.err.println("Invalid student: " + e);
                e.printStackTrace();
            }
        } */
        System.out.println("Students: ");
        for(Student student : students) System.out.println("  " + student);
        System.out.println("");
    }
}
