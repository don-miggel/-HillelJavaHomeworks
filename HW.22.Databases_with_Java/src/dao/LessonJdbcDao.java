package dao;

import model.Homework;
import model.Lesson;
import org.mariadb.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LessonJdbcDao implements LessonDao{

    private final Connection conn;

    public LessonJdbcDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addLesson(String name, int homeworkId) {

        boolean flag = true;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO Lesson(name, homework_id) values(?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, homeworkId);

            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("Unable to execute an SQL statement"+ e.getMessage());
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteLesson(int lessonId) {
        boolean flag = true;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM Lesson WHERE id = ?");
            preparedStatement.setInt(1, lessonId);

            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("Unable to execute an SQL statement"+ e.getMessage());
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> resultSet = new ArrayList<>();

        Statement stmt = conn.createStatement();
        boolean dataReturned = false;
        try {
            dataReturned = stmt.execute("SELECT * from Lesson");


            if (dataReturned) {
                ResultSet res = stmt.getResultSet();

                while (res.next()) {

                    int id = res.getInt("id");
                    String name = res.getString("name");

                    Lesson newLesson = new Lesson();
                    newLesson.setId(id);
                    newLesson.setName(name);
                    newLesson.setHomework(getHomeworkById(newLesson.getId()));

                    resultSet.add(newLesson);
                }

            }
        } catch (SQLException e) {
            System.out.println("Unable to execute an SQL query");
    }
        return resultSet;
    }

    @Override
    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from Lesson where id=?");

            preparedStatement.setInt(1, lessonId);

            boolean dataReturned = preparedStatement.execute();

            if (dataReturned) {
                ResultSet res = preparedStatement.getResultSet();

                lesson = new Lesson();

                while (res.next()) {
                    int hwId = res.getInt("id");
                    String name = res.getString("name");

                    lesson.setId(hwId);
                    lesson.setName(name);
                    lesson.setHomework(getHomeworkById(lessonId));
                }
            }
        }catch (SQLException e){
            System.out.println("Unable to execute an SQL statement"+ e.getMessage());
        }
        return lesson;
    }

    private Homework getHomeworkById(int id) {
        Homework hw = null;
        try{

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from Homework where id=?");

            preparedStatement.setInt(1,id);

            boolean dataReturned = preparedStatement.execute();

            if (dataReturned) {
                ResultSet res =  preparedStatement.getResultSet();

                hw = new Homework();

                while (res.next()) {
                    int hwId = res.getInt("id");
                    String name = res.getString("name");
                    String description = res.getString("description");

                    hw.setId(hwId);
                    hw.setName(name);
                    hw.setDescription(description);
                }
            }

    }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return hw;
    }
}
