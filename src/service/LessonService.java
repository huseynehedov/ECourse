package service;

import model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getLessonList() throws Exception;

    void addLesson(Lesson lesson) throws Exception;

}
