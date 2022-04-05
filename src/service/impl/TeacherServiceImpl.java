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

    @Override
    public Teacher getTeacherById(Long teacherId) throws Exception {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) throws Exception {
        teacherDao.deleteTeacher(teacherId);
    }

    @Override
    public List<Teacher> searchTeacherData(String key) throws Exception {
        return teacherDao.searchTeacherData(key);
    }
}
