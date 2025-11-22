import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class Student {
    int rollNumber;
    String studentName;
    String studentClass;  // Added class/section field
    int[] marks;

    // Constructor updated for 4 subjects
    public Student(int rollNumber, String studentName, String studentClass, int[] marks) throws InvalidMarksException {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.marks = marks;
        validateMarks();
    }

    void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Class: " + studentClass);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println();
        System.out.println("Average: " + calculateAverage());
        // Changed pass criteria to >= 35
        System.out.println("Result: " + (calculateAverage() >= 35 ? "Pass" : "Fail"));
    }
}

public class ResultManagerForSister {
    static Student[] students = new Student[100];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    static void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Class/Section: ");
            String studentClass = scanner.nextLine();

            int[] marks = new int[4];  // Now 4 subjects
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }

            students[count++] = new Student(rollNumber, name, studentClass, marks);
            System.out.println("Student added successfully. Returning to main menu...");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage() + " Returning to main menu...");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Returning to main menu...");
            scanner.nextLine();
        }
    }

    static void showStudentDetails() {
        System.out.print("Enter Roll Number to search: ");
        int rollNumber = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].rollNumber == rollNumber) {
                students[i].displayResult();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
        System.out.println("Search completed.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("
                    ===== Student Result Management System for Sister =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudentDetails();
                    break;
                case 3:
                    System.out.println("Exiting program. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
