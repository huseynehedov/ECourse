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

    @Override
    public Student getStudentById(Long id) throws Exception {
        Student student = new Student();
        String sql = "SELECT * FROM STUDENT " +
                "WHERE ACTIVE = 1 AND ID = ?";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("NAME"));
                student.setSurname(rs.getString("SURNAME"));
                student.setAddress(rs.getString("ADDRESS"));
                student.setDob(rs.getDate("DOB"));
                student.setPhone(rs.getString("PHONE"));
            }

        }

        return student;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET NAME = ?, SURNAME = ?, ADDRESS = ?, DOB = ?, PHONE = ?\n" +
                "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){

            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getAddress());
            ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
            ps.setString(5, student.getPhone());
            ps.setLong(6, student.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        String sql = "UPDATE STUDENT SET ACTIVE = 0 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){

            ps.setLong(1, studentId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public List<Student> searchStudentData(String key) throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT\n" +
                "WHERE ACTIVE = 1 AND \n" +
                "(LOWER(NAME) LIKE LOWER(?)) OR (LOWER(SURNAME) LIKE LOWER(?)) OR (LOWER(ADDRESS) LIKE LOWER(?))";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ResultSet rs = ps.executeQuery();

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
}
