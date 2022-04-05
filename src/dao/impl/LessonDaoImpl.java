package dao.impl;

import dao.DbHelper;
import dao.LessonDao;
import model.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public List<Lesson> getLessonList() throws Exception {

        List<Lesson> lessonList = new ArrayList<>();
        String sql = "SELECT * FROM LESSON WHERE ACTIVE = 1";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();){

            while (rs.next()){
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("ID"));
                lesson.setName(rs.getString("NAME"));
                lesson.setTime(rs.getInt("TIME"));
                lesson.setPrice(rs.getDouble("PRICE"));
                lesson.setDataDate(rs.getDate("DATA_DATE"));
                lesson.setActive(rs.getInt("ACTIVE"));

                lessonList.add(lesson);
            }

        }

        return lessonList;
    }

    @Override
    public void addLesson(Lesson lesson) throws Exception {
        String sql = "INSERT INTO LESSON(ID, NAME, TIME, PRICE)\n" +
                "VALUES (LESSON_SEQ.nextval,?,?,?)";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){

            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getTime());
            ps.setDouble(3, lesson.getPrice());

            ps.execute();
            c.commit();
        }
    }

    @Override
    public Lesson getLessonById(Long lessonId) throws Exception {
        Lesson lesson = new Lesson();
        String sql = "SELECT * FROM LESSON\n" +
                "WHERE ACTIVE = 1 AND ID = ?";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1, lessonId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lesson.setId(rs.getLong("ID"));
                lesson.setName(rs.getString("NAME"));
                lesson.setTime(rs.getInt("TIME"));
                lesson.setPrice(rs.getDouble("PRICE"));
            }
        }

        return lesson;
    }

    @Override
    public void updateLesson(Lesson lesson) throws Exception {
        String sql = "UPDATE LESSON SET NAME = ?, TIME = ?, PRICE = ?\n" +
                "WHERE ID = ?" ;
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getTime());
            ps.setDouble(3, lesson.getPrice());
            ps.setLong(4, lesson.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteLesson(Long lessonId) throws Exception {
        String sql = "UPDATE LESSON SET ACTIVE = 0\n" +
                "WHERE ID = ?";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1, lessonId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Lesson> searchLessonData(String key) throws Exception {
        List<Lesson> lessonList = new ArrayList<>();
        String sql = "SELECT * FROM LESSON\n" +
                "WHERE ACTIVE = 1 AND\n" +
                "(LOWER(NAME) LIKE LOWER(?))";

        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("ID"));
                lesson.setName(rs.getString("NAME"));
                lesson.setTime(rs.getInt("TIME"));
                lesson.setPrice(rs.getDouble("PRICE"));
                lesson.setDataDate(rs.getDate("DATA_DATE"));
                lesson.setActive(rs.getInt("ACTIVE"));

                lessonList.add(lesson);
            }

        }

        return lessonList;
    }
}
