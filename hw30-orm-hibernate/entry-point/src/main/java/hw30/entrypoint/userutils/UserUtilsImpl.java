package hw30.entrypoint.userutils;

import hw30.db.conn.repo.StudentRepo;
import hw30.entity.model.entity.Student;

import java.util.List;
import java.util.Scanner;

public class UserUtilsImpl implements UserUtils{

    private StudentRepo studentRepo;

    public UserUtilsImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public void addStudent(String studentName, String studentEmail) {
        studentRepo.addStudent(studentName, studentEmail);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepo.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public Student deleteStudent(Integer studentId) {
        return studentRepo.deleteStudent(studentId);
    }

    @Override
    public Student updateStudent(String studentName, String studentEmail, Integer studentId) {

        Student student = null;
        int res =  studentRepo.updateStudent(studentName, studentEmail, studentId);
        if(res == 1)
            student = getStudentById(studentId);
        return student;

    }

    @Override
    public void performUserOperation() {
        int userInput;
        Student student = null;
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        while (true){
            userInput = displayUserChoices();
            switch (userInput){
                case 0:
                    System.out.println("App exit...");
                    System.exit(0);
                case 1:
                    System.out.println("Please, enter a student name: ");
                    String studentName = scString.nextLine();
                    System.out.println("Please, enter a student email: ");
                    String studentEmail = scString.nextLine();
                    addStudent(studentName, studentEmail);
                    System.out.println("A new user was successfully added!");
                    break;
                case 2:
                    List<Student> allStudents= getAllStudents();
                    if(allStudents.size() == 0)
                        System.out.println("There are no students entered!");
                    else
                        System.out.println(getAllStudents());
                    break;
                case 3:
                    System.out.println("Please, enter a student Id: ");
                    int studentId = scInt.nextInt();
                    student = getStudentById(studentId);
                    if(student != null)
                        System.out.println(student);
                    break;
                case 4:
                    System.out.println("Please, enter a student Id to update: ");
                    studentId = scInt.nextInt();
                    System.out.println("Please, enter a student name: ");
                    student = getStudentById(studentId);
                    if(student == null)
                        continue;
                    studentName = scString.nextLine();
                    System.out.println("Please, enter a student email: ");
                    studentEmail = scString.nextLine();
                    student = updateStudent(studentName, studentEmail, studentId);
                    if(student != null)
                        System.out.println("This student with id: "+studentId+" was changed to:"+ student);
                    break;
                case 5:
                    System.out.println("Please, enter a student Id to delete: ");
                    studentId = scInt.nextInt();
                    student  = deleteStudent(studentId);
                    if(student != null)
                        System.out.println("This student was deleted: "+ student);
                    break;
                default:
                    System.out.println("You have entered a wrong menu item. Please, choose again !");

            }
        }

    }
}
