package dao;

import model.Homework;
import model.Lesson;

import java.util.List;

public interface LessonDao {

    boolean addLesson(String name, int homeworkId);
    boolean deleteLesson(int lessonId);
    List<Lesson> getAllLessons();
    Lesson getLessonById(int lessonId);

}
