# Student Result Management System

A simple Java console application to manage student results. The program allows adding students with their roll number, name, class/section, and marks for 4 subjects. It validates marks, calculates averages, and displays pass/fail results based on an average mark threshold of 35.

## Features

- Add student details including roll number, name, class/section, and marks for 4 subjects
- Validate marks in the range 0-100 using a custom `InvalidMarksException`
- Calculate average marks and determine pass/fail status (pass if average >= 35)
- Search and display student details by roll number
- Handles input errors and exceptions gracefully
- Menu-driven interface for easy usage

### How to Run

1. Clone or download this repository.
2. Compile the Java source files:
javac ResultManager.java , Student.java , InvalidMarksException.java
3. Run the application:
java ResultManager
4. Use the menu to add students, view results, or exit.

## Code Breakdown

- `InvalidMarksException.java` - Defines the exception for invalid marks.
- `Student.java` - Contains student details, validation, and result logic.
- `ResultManager.java` - Provides the main interface to manage student records.

## Sample Output

===== Student Result Management System =====

Add Student

Show Student Details

Exit

Enter your choice: 1

Enter Roll Number: 101

Enter Student Name: John Doe

Enter Class/Section: 10-A

Enter marks for subject 1: 78

Enter marks for subject 2: 85

Enter marks for subject 3: 90

Enter marks for subject 4: 88

Student added successfully. Returning to main menu...

===== Student Result Management System =====

Add Student

Show Student Details

Exit

Enter your choice: 2

Enter Roll Number to search: 101

Roll Number: 101

Student Name: John Doe

Class: 10-A

Marks: 78 85 90 88

Average: 85.25

Result: Pass

Search completed.


## Exception Handling

- Throws and catches `InvalidMarksException` when marks are out of valid range.
- Catches input mismatches and other runtime exceptions to maintain smooth execution.




