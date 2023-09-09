package hw30.entrypoint;

import hw30.db.conn.conn.HibernateSession;
import hw30.db.conn.repo.StudentImpl;
import hw30.db.conn.repo.StudentRepo;
import hw30.entrypoint.userutils.UserUtils;
import hw30.entrypoint.userutils.UserUtilsImpl;

public class Main {
    public static void main(String[] args) {

        var hibernateSession = HibernateSession.getSessionFactory();
        StudentRepo studentRepo = new StudentImpl(hibernateSession);
        UserUtils userUtils = new UserUtilsImpl(studentRepo);
        userUtils.performUserOperation();

    }
}