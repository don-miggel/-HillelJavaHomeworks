package entry_point;

import conn.DataBaseConnection;
import dao.LessonDao;
import dao.LessonJdbcDao;
import model.Lesson;
import org.mariadb.jdbc.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = null;
        Connection conn  = null;
        try {
            dataBaseConnection = new  DataBaseConnection();
            conn = dataBaseConnection.getConnection();

            List<Lesson> lessons;

            LessonDao lessonDao = new LessonJdbcDao(conn);

            // a. Adding a lesson
            System.out.println(lessonDao.addLesson("Build tools in Java",6));
            System.out.println("----------Adding a lesson-------------------");
            System.out.println(lessonDao.getAllLessons());

            // b. Deleting a lesson
            lessonDao.deleteLesson(6);
            System.out.println("---------------Deleting a lesson---------------");
            System.out.println(lessonDao.getAllLessons());

            // c. Get all lessons
            lessons = lessonDao.getAllLessons();
            System.out.println("---------------Get all lessons---------------");
            System.out.println(lessons);

            // d. Get lesson by Id
            Lesson res = lessonDao.getLessonById(3);
            System.out.println("---------------Get a lesson by Id---------------");
            System.out.println(res);




        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Unable to execute SQL query "+ e.getMessage());
        }finally {
            if (dataBaseConnection != null) {
                dataBaseConnection.close(conn);
            }
        }
    }
}
