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

    @Override
    public Lesson getLessonById(Long lessonId) throws Exception {
        return lessonDao.getLessonById(lessonId);
    }

    @Override
    public void updateLesson(Lesson lesson) throws Exception {
        lessonDao.updateLesson(lesson);
    }

    @Override
    public void deleteLesson(Long lessonId) throws Exception {
        lessonDao.deleteLesson(lessonId);
    }

    @Override
    public List<Lesson> searchLessonData(String key) throws Exception {
        return lessonDao.searchLessonData(key);
    }
}
