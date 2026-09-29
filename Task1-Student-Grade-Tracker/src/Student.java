public class Student {

    private String name;
    private int rollno;
    private int marks;

    // Constructor
    public Student(String name, int rollno, int marks) {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for roll number
    public int getRollno() {
        return rollno;
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    // Setter for marks
    public void setMarks(int marks) {
        this.marks = marks;
    }
}