package dao;

import model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;

    void addLesson(Lesson lesson) throws Exception;

    Lesson getLessonById(Long lessonId) throws Exception;

    void updateLesson(Lesson lesson) throws Exception;

    void deleteLesson(Long lessonId) throws Exception;

    List<Lesson> searchLessonData(String key) throws Exception;
}
