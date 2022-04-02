package service.impl;

import dao.LessonDao;
import model.Lesson;
import service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDao lessonDao;

    public LessonServiceImpl(LessonDao lessonDao){
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return lessonDao.getLessonList();
    }

    @Override
    public void addLesson(Lesson lesson) throws Exception {
        lessonDao.addLesson(lesson);
    }
}
