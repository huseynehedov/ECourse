package service.impl;

import dao.StudentDao;
import model.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getStudentList() throws Exception {
        return studentDao.getStudentList();
    }

    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.addStudent(student);
    }
}
