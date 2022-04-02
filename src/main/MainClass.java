package main;

import dao.LessonDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.impl.LessonDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TeacherDaoImpl;
import model.Lesson;
import model.Student;
import model.Teacher;
import service.LessonService;
import service.StudentService;
import service.TeacherService;
import service.impl.LessonServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        TeacherDao teacherDao = new TeacherDaoImpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);
        LessonDao lessonDao = new LessonDaoImpl();
        LessonService lessonService = new LessonServiceImpl(lessonDao);

        try {

            System.out.println("You can write one of these: student, teacher, or lesson");
            String model = scanner.nextLine();

            System.out.println("Please choose method: " +
                    "\n 1.View \n 2.Add \n 3.Update \n 4.Delete");
            int methodNumber = scanner.nextInt();

            switch (model) {
                case "teacher" :
                    switch (methodNumber){
                        case 1:
                            List<Teacher> teacherList = teacherService.getTeacherList();

                            for (Teacher teacher: teacherList) {
                                System.out.println(teacher.toString());
                            }
                            break;
                        case 2:
                            System.out.println("Enter teacher's name: ");
                            String teacherName = scanner.nextLine();
                            System.out.println("Enter teacher's surname: ");
                            String teacherSurname = scanner.nextLine();
                            System.out.println("Add teacher's dob(Format: day/month/year) :");
                            String dob = scanner.nextLine();
                            System.out.println("Enter teacher's address: ");
                            String address = scanner.nextLine();
                            System.out.println("Enter teacher's phone: ");
                            String phone = scanner.nextLine();
                            System.out.println("Enter teacher's work experience: ");
                            Integer workExperience = scanner.nextInt();

                            Teacher teacher = new Teacher();
                            teacher.setName(teacherName);
                            teacher.setSurname(teacherSurname);
                            teacher.setDob(df.parse(dob));
                            teacher.setAddress(address);
                            teacher.setPhone(phone);
                            teacher.setWorkExperience(workExperience);

                            teacherService.addTeacher(teacher);
                            System.out.println("Teacher object has been successfully added...");
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Method number!!!");
                            break;
                    }
                    break;
                case "student" :
                    switch (methodNumber){
                        case 1:
                            List<Student> studentList = studentService.getStudentList();

                            for (Student student: studentList) {
                                System.out.print(student.getId() + " ");
                                System.out.print(student.getName() + " ");
                                System.out.print(student.getSurname() + " ");
                                System.out.print(student.getAddress() + " ");
                                System.out.print(student.getDob() + " ");
                                System.out.print(student.getPhone() + " ");
                                System.out.print(student.getDataDate() + " ");
                                System.out.print(student.getActive() + " ");
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Enter name: ");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Enter surname : ");
                            String surname = scanner.nextLine();
                            System.out.println("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.println("Enter phone: ");
                            String phone = scanner.nextLine();
                            System.out.println("Enter dob(Format: day/month/year) : ");
                            String dob = scanner.nextLine();

                            Student student = new Student();
                            student.setName(name);
                            student.setSurname(surname);
                            student.setAddress(address);
                            student.setPhone(phone);
                            student.setDob(df.parse(dob));

                            studentService.addStudent(student);
                            System.out.println("Student has been successfully added...");

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Method number!!!");
                            break;
                    }
                    break;
                case "lesson" :
                    switch (methodNumber){
                        case 1:
                            List<Lesson> lessonList = lessonService.getLessonList();

                            for (Lesson lesson: lessonList){
                                System.out.println(lesson);
                            }

                            break;
                        case 2:
                            System.out.println("Enter Lesson Name: ");
                            String lessonName = scanner.nextLine();
                            System.out.println("Enter the time of lesson: ");
                            int lessonTime = scanner.nextInt();
                            System.out.println("Enter the price of lesson: ");
                            double lessonPrice = scanner.nextDouble();

                            Lesson lesson = new Lesson();
                            lesson.setName(lessonName);
                            lesson.setTime(lessonTime);
                            lesson.setPrice(lessonPrice);

                            lessonService.addLesson(lesson);
                            System.out.println("Lesson has been added successfully");
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid Method number!!!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid form!!!");
                    break;
            }

            main(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
