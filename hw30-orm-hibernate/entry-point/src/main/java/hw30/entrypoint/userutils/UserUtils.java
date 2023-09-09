package hw30.entrypoint.userutils;

import hw30.entity.model.entity.Student;

import java.util.List;
import java.util.Scanner;

public interface UserUtils {
    void addStudent(String studentName, String studentEmail);
    Student getStudentById(Integer studentId);
    List<Student> getAllStudents();
    Student deleteStudent(Integer studentId);
    Student updateStudent(String studentName, String studentEmail, Integer studentId);

    void performUserOperation();

    default int displayUserChoices(){
        System.out.println("Please, choose an operation: ");
        System.out.println("1 - add a new Student");
        System.out.println("2 - get all students");
        System.out.println("3 - get  Student by Id" );
        System.out.println("4 - update Student by Id");
        System.out.println("5 - delete Student by Id");
        System.out.println("0 - exit");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        return userChoice;
    }
}
