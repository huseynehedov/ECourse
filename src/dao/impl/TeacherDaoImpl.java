package dao.impl;

import dao.DbHelper;
import dao.TeacherDao;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER WHERE ACTIVE = 1";

        try(Connection c = DbHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();) {

            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                teacher.setDataDate(rs.getDate("DATA_DATE"));
                teacher.setActive(rs.getInt("ACTIVE"));

                teacherList.add(teacher);
            }
        }

        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        String sql = "INSERT INTO TEACHER(ID, NAME, SURNAME, DOB, ADDRESS, PHONE, WORK_EXPERIENCE)\n" +
                "VALUES (TEACHER_SEQ.nextval, ?,?,?,?,?,?)";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){

            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setDate(3,new java.sql.Date(teacher.getDob().getTime()));
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWorkExperience());

            ps.execute();
            c.commit();
        }
    }

    @Override
    public Teacher getTeacherById(Long teacherId) throws Exception {
        Teacher teacher = new Teacher();
        String sql = "SELECT * FROM TEACHER\n" +
                "WHERE ACTIVE = 1 AND ID = ?";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setLong(1, teacherId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
            }
        }

        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        String sql = "UPDATE TEACHER SET NAME = ?, SURNAME = ?, ADDRESS = ?, DOB = ?, PHONE = ?, WORK_EXPERIENCE = ?\n" +
                "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setString(3, teacher.getAddress());
            ps.setDate(4, new java.sql.Date(teacher.getDob().getTime()));
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWorkExperience());
            ps.setLong(7, teacher.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteTeacher(Long teacherId) throws Exception {
        String sql = "UPDATE TEACHER SET ACTIVE = 0 WHERE ID = ?";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setLong(1, teacherId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Teacher> searchTeacherData(String key) throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT * FROM TEACHER\n" +
                "WHERE ACTIVE = 1 AND " +
                "(LOWER(NAME) LIKE LOWER(?)) OR (LOWER(SURNAME) LIKE LOWER(?)) OR (LOWER(ADDRESS) LIKE LOWER(?))";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1,"%" + key + "%");
            ps.setString(2,"%" + key + "%");
            ps.setString(3,"%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                teacher.setDataDate(rs.getDate("DATA_DATE"));
                teacher.setActive(rs.getInt("ACTIVE"));

                teacherList.add(teacher);
            }
        }
        return teacherList;
    }
}
