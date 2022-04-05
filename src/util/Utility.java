package util;

import model.Lesson;
import model.Student;
import model.Teacher;

import java.util.List;

public class Utility {

    public static void getStudentList(List<Student> studentList){

        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    public static void getTeacherList(List<Teacher> teacherList){
        for (Teacher teacher: teacherList) {
            System.out.println(teacher);
        }
    }

    public static void getLessonList(List<Lesson> lessonList){
        for (Lesson lesson: lessonList) {
            System.out.println(lesson);
        }
    }

}
