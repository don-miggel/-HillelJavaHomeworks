package hw30.db.conn.repo;

import hw30.entity.model.entity.Student;
import org.hibernate.SessionFactory;

import java.util.List;

public interface StudentRepo {

    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    void addStudent(String name, String email);
    Student deleteStudent(Integer id);
    int updateStudent(String newName, String newEmail, Integer currId);


}
