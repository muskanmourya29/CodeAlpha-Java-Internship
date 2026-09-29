import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store multiple Student objects
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Average Marks");
            System.out.println("4. Find Highest Marks");
            System.out.println("5. Find Lowest Marks");
            System.out.println("6. Search Student");
            System.out.println("7. Show Student Grades");
            System.out.println("8. Delete Student");
            System.out.println("9. Update Student Marks");
            System.out.println("10. Summary Report");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // =========================
                // 1. ADD STUDENT
                // =========================
                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Roll Number: ");
                    int rollno = sc.nextInt();

                    // Roll number validation
                    while (rollno <= 0) {
                        System.out.print(
                            "Invalid roll number! Enter a positive number: "
                        );
                        rollno = sc.nextInt();
                    }

                    // Check duplicate roll number
                    boolean alreadyExists = false;

                    for (Student s : students) {

                        if (s.getRollno() == rollno) {
                            alreadyExists = true;
                            break;
                        }
                    }

                    if (alreadyExists) {

                        System.out.println(
                            "Student with this Roll Number already exists!"
                        );

                        break;
                    }

                    System.out.print("Enter Student Marks: ");
                    int marks = sc.nextInt();

                    // Marks validation
                    while (marks < 0 || marks > 100) {

                        System.out.print(
                            "Invalid marks! Enter marks between 0 and 100: "
                        );

                        marks = sc.nextInt();
                    }

                    // Create Student object
                    Student student = new Student(name, rollno, marks);

                    // Add student to ArrayList
                    students.add(student);

                    System.out.println(
                        "Student added successfully!"
                    );

                    break;


                // =========================
                // 2. VIEW STUDENTS
                // =========================
                case 2:

                    System.out.println("\n-------- STUDENT LIST --------");

                    if (students.isEmpty()) {

                        System.out.println("No students found.");

                    } else {

                        for (Student s : students) {

                            System.out.println(
                                "Name: " + s.getName()
                                + ", Roll Number: " + s.getRollno()
                                + ", Marks: " + s.getMarks()
                            );
                        }
                    }

                    break;


                // =========================
                // 3. AVERAGE MARKS
                // =========================
                case 3:

                    if (students.isEmpty()) {

                        System.out.println("No Student Available.");

                    } else {

                        int total = 0;

                        for (Student s : students) {

                            total = total + s.getMarks();
                        }

                        double average =
                            (double) total / students.size();

                        System.out.println(
                            "Average Marks: " + average
                        );
                    }

                    break;


                // =========================
                // 4. HIGHEST MARKS
                // =========================
                case 4:

                    if (students.isEmpty()) {

                        System.out.println("No Student Available.");

                    } else {

                        int highest =
                            students.get(0).getMarks();

                        for (Student s : students) {

                            if (s.getMarks() > highest) {

                                highest = s.getMarks();
                            }
                        }

                        System.out.println(
                            "Highest Marks: " + highest
                        );
                    }

                    break;


                // =========================
                // 5. LOWEST MARKS
                // =========================
                case 5:

                    if (students.isEmpty()) {

                        System.out.println("No Student Available.");

                    } else {

                        int lowest =
                            students.get(0).getMarks();

                        for (Student s : students) {

                            if (s.getMarks() < lowest) {

                                lowest = s.getMarks();
                            }
                        }

                        System.out.println(
                            "Lowest Marks: " + lowest
                        );
                    }

                    break;


                // =========================
                // 6. SEARCH STUDENT
                // =========================
                case 6:

                    System.out.print(
                        "Enter Roll Number to Search: "
                    );

                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.getRollno() == searchRoll) {

                            System.out.println(
                                "\nStudent Found!"
                            );

                            System.out.println(
                                "Name: " + s.getName()
                            );

                            System.out.println(
                                "Roll Number: " + s.getRollno()
                            );

                            System.out.println(
                                "Marks: " + s.getMarks()
                            );

                            found = true;

                            break;
                        }
                    }

                    if (!found) {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // =========================
                // 7. SHOW GRADES
                // =========================
                case 7:

                    if (students.isEmpty()) {

                        System.out.println(
                            "No Student Available."
                        );

                    } else {

                        System.out.println(
                            "\n-------- STUDENT GRADES --------"
                        );

                        for (Student s : students) {

                            String grade;

                            if (s.getMarks() >= 90) {

                                grade = "A";

                            } else if (s.getMarks() >= 80) {

                                grade = "B";

                            } else if (s.getMarks() >= 70) {

                                grade = "C";

                            } else if (s.getMarks() >= 60) {

                                grade = "D";

                            } else {

                                grade = "F";
                            }

                            System.out.println(
                                "Name: " + s.getName()
                                + ", Marks: " + s.getMarks()
                                + ", Grade: " + grade
                            );
                        }
                    }

                    break;


                // =========================
                // 8. DELETE STUDENT
                // =========================
                case 8:

                    System.out.print(
                        "Enter Roll Number to Delete: "
                    );

                    int deleteRoll = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < students.size(); i++) {

                        if (
                            students.get(i).getRollno()
                            == deleteRoll
                        ) {

                            students.remove(i);

                            System.out.println(
                                "Student deleted successfully!"
                            );

                            deleted = true;

                            break;
                        }
                    }

                    if (!deleted) {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;


                // =========================
                // 9. UPDATE MARKS
                // =========================
                case 9:

                    System.out.print(
                        "Enter Roll Number: "
                    );

                    int updateRoll = sc.nextInt();

                    boolean updated = false;

                    for (Student s : students) {

                        if (s.getRollno() == updateRoll) {

                            System.out.print(
                                "Enter New Marks: "
                            );

                            int newMarks = sc.nextInt();

                            while (
                                newMarks < 0
                                || newMarks > 100
                            ) {

                                System.out.print(
                                    "Invalid marks! Enter marks between 0 and 100: "
                                );

                                newMarks = sc.nextInt();
                            }

                            s.setMarks(newMarks);

                            System.out.println(
                                "Student marks updated successfully!"
                            );

                            updated = true;

                            break;
                        }
                    }

                    if (!updated) {

                        System.out.println(
                            "Student not found."
                        );
                    }

                    break;
                
                //=========================
                // 10. SUMMARY REPORT
              
          case 10:
       if (students.isEmpty()) {
        System.out.println("No Student Available.");
    } else {

        System.out.println("\n========================================");
        System.out.println("           SUMMARY REPORT");
        System.out.println("========================================");

        System.out.println("Total Students: " + students.size());

        int total = 0;
        int highest = students.get(0).getMarks();
        int lowest = students.get(0).getMarks();

        for (Student s : students) {
             marks = s.getMarks();

            total += marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        double average = (double) total / students.size();

        System.out.println("Average Marks : " + average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);

        System.out.println("\n-------- STUDENT DETAILS --------");

        for (Student s : students) {

            String grade;

            if (s.getMarks() >= 90) {
                grade = "A";
            } else if (s.getMarks() >= 80) {
                grade = "B";
            } else if (s.getMarks() >= 70) {
                grade = "C";
            } else if (s.getMarks() >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println(
                "Name: " + s.getName()
                + " | Roll No: " + s.getRollno()
                + " | Marks: " + s.getMarks()
                + " | Grade: " + grade
            );
        }

        System.out.println("========================================");
    }
    break;


                // =========================
                // 11. EXIT
                // =========================
                case 11:

                    System.out.println(
                        "Exiting the program..."
                    );

                    break;


                // =========================
                // INVALID CHOICE
                // =========================
                default:

                    System.out.println(
                        "Invalid choice! Please try again."
                    );
            }

        } while (choice != 11);

        sc.close();

        System.out.println(
            "Thank you for using Student Grade Tracker!"
        );
    }
}