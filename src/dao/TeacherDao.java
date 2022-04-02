package dao;

import model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher teacher) throws Exception;
}
