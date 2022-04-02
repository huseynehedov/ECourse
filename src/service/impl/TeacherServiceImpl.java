package service.impl;

import dao.TeacherDao;
import model.Teacher;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao){
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return teacherDao.getTeacherList();
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        teacherDao.addTeacher(teacher);
    }
}
