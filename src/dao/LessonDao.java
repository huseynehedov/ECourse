package dao;

import model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;

    void addLesson(Lesson lesson) throws Exception;

}
