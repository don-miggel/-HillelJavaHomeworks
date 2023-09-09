package hw30.db.conn;


import hw30.db.conn.conn.HibernateSession;
import hw30.db.conn.repo.StudentImpl;
import hw30.db.conn.repo.StudentRepo;

public class Main {
    public static void main(String[] args) {

//        var hibernateSession = HibernateSession.getSessionFactory();
//        StudentRepo studentRepo = new StudentImpl(hibernateSession);
 //       System.out.println(studentRepo.getAllStudents());
 //       System.out.println(studentRepo.getStudentById(10));
 //       studentRepo.addStudent("Teddis", "teddis@bear.com");
 //       studentRepo.deleteStudent(10);
 //       studentRepo.updateStudent("Phil", "phil@new.com", 13);
 //       System.out.println(studentRepo.getAllStudents());

        /*
        var entityManager = hibernateSession.createEntityManager();

        entityManager.getTransaction().begin();

        Student student = new Student();
        student.setName("Kimberly");
        student.setEmail("kim@berly.com");

        entityManager.persist(student);
        entityManager.flush();
        System.out.println();

        entityManager.getTransaction().commit();


        /*

       var config =  new Configuration();
       var properties= new Properties();
       properties.put("hibernate.connection.driver_class", System.getenv("DB_DRIVER"));
       properties.put("hibernate.connection.url", System.getenv("DB_CONN_URL"));
       properties.put("hibernate.connection.username", System.getenv("DB_USERNAME"));
       properties.put("hibernate.connection.password", System.getenv("DB_PASSWORD"));
       config.setProperties(properties);


       config.configure("hibernate-annotation.cfg.xml");
       config.addAnnotatedClass(Student.class);
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
               .applySettings(config.getProperties()).build();

        try (var entityManagerFactory
                     = Persistence.createEntityManagerFactory("studentapp");
       var sessionFactory = config.buildSessionFactory()){
            var entityManager = sessionFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Student student = new Student();
            student.setName("lJohnDbjc11");
            student.setEmail("ljohndjjjbc1@email1.com");

            entityManager.persist(student);
            entityManager.flush();
            System.out.println();

            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e+" exc occured");
        }

         */
        /*
        try (var entityManagerFactory
                     = Persistence.createEntityManagerFactory("studentapp");
             var entityManager =
                     entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();

            Student student = new Student();
            student.setName("JohnDbc");
            student.setEmail("johndbc@email.com");

            entityManager.persist(student);
            entityManager.flush();
            System.out.println();

            entityManager.getTransaction().commit();

        }

         */
    }
}