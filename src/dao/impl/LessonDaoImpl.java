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
}
