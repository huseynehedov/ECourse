package model;

import java.util.Date;

public class Payment extends CourseModel{
    private Student student;
    private Teacher teacher;
    private Lesson lesson;
    private Double amount;
    private Date payDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "student=" + student +
                ", teacher=" + teacher +
                ", lesson=" + lesson +
                ", amount=" + amount +
                ", payDate=" + payDate +
                '}';
    }
}
