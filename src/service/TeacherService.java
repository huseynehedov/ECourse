package service;

import model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher teacher) throws Exception;
}
