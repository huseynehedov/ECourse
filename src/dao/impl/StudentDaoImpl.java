package dao.impl;

import dao.DbHelper;
import dao.StudentDao;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT WHERE ACTIVE = 1";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();) {

            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("NAME"));
                student.setSurname(rs.getString("SURNAME"));
                student.setAddress(rs.getString("ADDRESS"));
                student.setDob(rs.getDate("DOB"));
                student.setPhone(rs.getString("PHONE"));
                student.setDataDate(rs.getDate("DATA_DATE"));
                student.setActive(rs.getInt("ACTIVE"));

                studentList.add(student);
            }
        }

        return studentList;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT(ID, NAME, SURNAME, ADDRESS, DOB, PHONE)\n" +
                "VALUES (STUDENT_SEQ.nextval,?,?,?,?,?)";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){

            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getAddress());
            ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
            ps.setString(5, student.getPhone());
            ps.execute();
            c.commit();
        }
    }
}
