package service;

import model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;

    Student getStudentById( Long studentId) throws Exception;

    void updateStudent( Student student) throws Exception;

    void deleteStudent (Long studentId) throws Exception;

    List<Student> searchStudentData(String key) throws Exception;
}
