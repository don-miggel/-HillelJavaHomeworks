package hw30.db.conn.repo;

import hw30.entity.model.entity.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements  StudentRepo{

    private final SessionFactory sessionFactory;

    public StudentImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        var entityManager = sessionFactory.createEntityManager();
        List<Student> studentList = new ArrayList<>();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<Student> students = entityManager.createQuery("SELECT s FROM student s", Student.class);
            studentList =  students.getResultList();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e+"rolled back");
            entityManager.getTransaction().rollback();
        }
        return studentList;

    }

    @Override
    public Student getStudentById(Integer studentId) {
        var entityManager = sessionFactory.createEntityManager();
        Student student = null;
        entityManager.getTransaction().begin();
        try{
            TypedQuery<Student> studentQuery = entityManager.createQuery("SELECT s FROM student s WHERE s.id LIKE :studentId",
                                                                            Student.class);
            studentQuery.setParameter("studentId", studentId);

            student = studentQuery.getSingleResult();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Student with id: "+ studentId+" is not found!");
            entityManager.getTransaction().rollback();
        }
        return student;
    }

    @Override
    public void addStudent(String name, String email) {
        var entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);

            entityManager.persist(student);
            entityManager.flush();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("An error occurred by adding a new student!");
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public Student deleteStudent(Integer studentId) {
        var entityManager = sessionFactory.createEntityManager();
        Student student = null;
        entityManager.getTransaction().begin();
        try {
            TypedQuery<Student> studentQuery = entityManager.createQuery("SELECT s FROM student s WHERE s.id LIKE :studentId",
                    Student.class);
            studentQuery.setParameter("studentId", studentId);

            student = studentQuery.getSingleResult();
            entityManager.remove(student);

            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println("Student with id: "+ studentId+" is not found!");
            entityManager.getTransaction().rollback();
        }

        return student;
    }

    @Override
    public int updateStudent(String newName, String newEmail, Integer currId) {
        var entityManager = sessionFactory.createEntityManager();
        int result = -1;
        entityManager.getTransaction().begin();
        try {
            result  = entityManager.createQuery("UPDATE student SET name = :newName, email = :newEmail WHERE id= :currId")
                    .setParameter("currId", currId)
                    .setParameter("newName", newName)
                    .setParameter("newEmail", newEmail)
                    .executeUpdate();


            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println("Student with id: "+ currId+" is not found!");
            entityManager.getTransaction().rollback();
        }

        return result;
    }
}
