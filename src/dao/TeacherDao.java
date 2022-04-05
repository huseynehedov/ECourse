package dao;

import model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher teacher) throws Exception;

    Teacher getTeacherById(Long teacherId) throws Exception;

    void updateTeacher(Teacher teacher) throws Exception;

    void deleteTeacher(Long teacherId) throws Exception;

    List<Teacher> searchTeacherData(String key) throws Exception;
}
