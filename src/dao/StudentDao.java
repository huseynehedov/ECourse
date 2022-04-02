package dao;

import model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;
}
