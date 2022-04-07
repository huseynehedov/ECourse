package dao.impl;

import dao.DbHelper;
import dao.PaymentDao;
import model.Lesson;
import model.Payment;
import model.Student;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImp implements PaymentDao {

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList();
        String sql = "SELECT P.ID,\n" +
                "       S.ID STUDENT_ID,\n" +
                "       S.NAME STUDENT_NAME,\n" +
                "       S.SURNAME STUDENT_SURNAME,\n" +
                "       T.ID TEACHER_ID,\n" +
                "       T.NAME TEACHER_NAME,\n" +
                "       T.SURNAME TEACHER_SURNAME,\n" +
                "       L.ID LESSON_ID,\n" +
                "       L.NAME LESSON_NAME,\n" +
                "       P.AMOUNT AMOUNT,\n" +
                "       P.PAY_DATE PAY_DATE\n" +
                "FROM PAYMENT P\n" +
                "    INNER JOIN LESSON L on P.LESSON_ID = L.ID\n" +
                "    INNER JOIN TEACHER T on P.TEACHER_ID = T.ID\n" +
                "    INNER JOIN STUDENT S on P.STUDENT_ID = S.ID\n" +
                "WHERE P.ACTIVE = 1;";
        try (Connection c = DbHelper.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();){
            while (rs.next()) {
                Payment p = new Payment();
                p.setId(rs.getLong("ID"));
                p.setAmount(rs.getDouble("AMOUNT"));
                p.setPayDate(rs.getDate("PAY_DATE"));

                Student s = new Student();
                s.setId(rs.getLong("STUDENT_ID"));
                s.setName(rs.getString("STUDENT_NAME"));
                s.setSurname(rs.getString("STUDENT_SURNAME"));

                Teacher t = new Teacher();
                t.setId(rs.getLong("TEACHER_ID"));
                t.setName(rs.getString("TEACHER_NAME"));
                t.setSurname(rs.getString("TEACHER_SURNAME"));

                Lesson l  = new Lesson();
                l.setId(rs.getLong("LESSON_ID"));
                l.setName(rs.getString("LESSON_NAME"));

                p.setStudent(s);
                p.setTeacher(t);
                p.setLesson(l);

                paymentList.add(p);
            }
        }
        return paymentList;
    }

    @Override
    public void addPayment(Payment payment) throws Exception {

    }

    @Override
    public Payment getPaymentById(Long paymentId) throws Exception {
        return null;
    }

    @Override
    public void updatePayment(Payment payment) throws Exception {

    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {

    }
}
