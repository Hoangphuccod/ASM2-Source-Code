import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int i = 1; i <= n; i++) {
            input();
        }

        System.out.println("PRINT STUDENT LIST:");
        output();

        System.out.println("Enter the student code to delete:");
        String codeToDelete = scanner.nextLine();
        removeByCode(codeToDelete);
        System.out.println("Student list after deletion:");
        output();

        System.out.println("Sort the student list by grade in descending order:");
        sortByGradeDesc();
        output();

        System.out.println("Enter student code or name to search:");
        String keyword = scanner.nextLine();
        Student foundStudent = findByCodeOrName(keyword);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent.toString());
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("Enter the value x to find students with grade >= x:");
        float x = scanner.nextFloat();
        List<Student> filteredStudents = filterByGrade(x);
        System.out.println("List of students with grade >= " + x + ":");
        for (Student student : filteredStudents) {
            System.out.println(student.toString());
        }
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student information:");

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter student code:");
        String code = scanner.nextLine();
        System.out.println("Enter gender (1 for Male, 0 for Female):");
        int gender = scanner.nextInt();
        System.out.println("Enter grade:");
        float grade = scanner.nextFloat();

        Student student = new Student(name, age, email, phone, code, gender, grade);
        studentList.add(student);
    }

    // Print student list
    public static void output() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    public static void removeByCode(String code) {
        studentList.removeIf(student -> student.getCode().equalsIgnoreCase(code));
    }

    public static void sortByGradeDesc() {
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
    }

    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    public static List<Student> filterByGrade(float x) {
        List<Student> filteredList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredList.add(student);
            }
        }
        return filteredList;
    }
}
