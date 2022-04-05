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
import util.Utility;

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
                    "\n 1.View \n 2.Add \n 3.Update \n 4.Delete \n 5.Search");
            int methodNumber = scanner.nextInt();

            switch (model) {
                case "teacher" :
                    switch (methodNumber){
                        case 1:
                            Utility.getTeacherList(teacherService.getTeacherList());
                            break;
                        case 2:
                            System.out.println("Enter teacher's name: ");
                            scanner.nextLine();
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
                            Utility.getTeacherList(teacherService.getTeacherList());
                            System.out.println("Please enter the id of teacher which want to update: ");
                            Long teacherId = scanner.nextLong();
                            Teacher tr = teacherService.getTeacherById(teacherId);
                            if (tr == null) {
                                System.out.println("Not found the teacher!!!");
                            }else {
                                System.out.println("Old name: " + tr.getName());
                                System.out.println("Old surname: " + tr.getSurname());
                                System.out.println("Old address: " + tr.getAddress());
                                System.out.println("Old dob: " + tr.getDob());
                                System.out.println("Old phone: " + tr.getPhone());
                                System.out.println("Old work experience: " + tr.getWorkExperience());

                                System.out.println("Enter new name: ");
                                scanner.nextLine();
                                teacherName = scanner.nextLine();
                                System.out.println("Enter new surname : ");
                                teacherSurname = scanner.nextLine();
                                System.out.println("Enter new address: ");
                                address = scanner.nextLine();
                                System.out.println("Enter new phone: ");
                                phone = scanner.nextLine();
                                System.out.println("Enter new dob(Format: day/month/year) : ");
                                dob = scanner.nextLine();
                                System.out.println("Enter new work experience: ");
                                workExperience = scanner.nextInt();

                                tr.setName(teacherName);
                                tr.setSurname(teacherSurname);
                                tr.setAddress(address);
                                tr.setPhone(phone);
                                tr.setDob(df.parse(dob));
                                tr.setWorkExperience(workExperience);

                                teacherService.updateTeacher(tr);
                                System.out.println("Teacher has been successfully updated...");
                            }
                            break;
                        case 4:
                            Utility.getTeacherList(teacherService.getTeacherList());
                            System.out.println("Please enter id of teacher which you want to delete: ");
                            teacherId = scanner.nextLong();
                            teacherService.deleteTeacher(teacherId);
                            System.out.println("Teacher has been successfully deleted...");
                            break;
                        case 5:
                            Utility.getTeacherList(teacherService.getTeacherList());
                            System.out.println("Please enter keyword: ");
                            scanner.nextLine();
                            String searchKeyword = scanner.nextLine();
                            List<Teacher> teacherList = teacherService.searchTeacherData(searchKeyword);
                            System.out.println("Result: ");
                            if (teacherList.isEmpty()){
                                System.out.println("Not found searched key in the teacher table");
                            }else{
                                Utility.getTeacherList(teacherList);
                            }
                            break;
                        default:
                            System.out.println("Invalid Method number!!!");
                            break;
                    }
                    break;
                case "student" :
                    switch (methodNumber){
                        case 1:
                            Utility.getStudentList(studentService.getStudentList());
                            break;
                        case 2:
                            System.out.println("Enter name: ");
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
                            Utility.getStudentList(studentService.getStudentList());
                            System.out.println("Please enter the id of student which want to update: ");
                            Long studentId = scanner.nextLong();
                            Student st = studentService.getStudentById(studentId);
                            if (st == null) {
                                System.out.println("Not found the student!!!");
                            }else {
                                System.out.println("Old name: " + st.getName());
                                System.out.println("Old surname: " + st.getSurname());
                                System.out.println("Old address: " + st.getAddress());
                                System.out.println("Old dob: " + st.getDob());
                                System.out.println("Old phone: " + st.getPhone());

                                System.out.println("Enter new name: ");
                                scanner.nextLine();
                                name = scanner.nextLine();
                                System.out.println("Enter new surname : ");
                                surname = scanner.nextLine();
                                System.out.println("Enter new address: ");
                                address = scanner.nextLine();
                                System.out.println("Enter new phone: ");
                                phone = scanner.nextLine();
                                System.out.println("Enter new dob(Format: day/month/year) : ");
                                dob = scanner.nextLine();

                                st.setName(name);
                                st.setSurname(surname);
                                st.setAddress(address);
                                st.setPhone(phone);
                                st.setDob(df.parse(dob));

                                studentService.updateStudent(st);
                                System.out.println("Student has been successfully updated...");
                            }

                            break;
                        case 4:
                            Utility.getStudentList(studentService.getStudentList());
                            System.out.println("Please enter id of student which you want to delete: ");
                            studentId = scanner.nextLong();
                            studentService.deleteStudent(studentId);
                            System.out.println("Student has been successfully deleted...");
                            break;
                        case 5:
                            Utility.getStudentList(studentService.getStudentList());
                            System.out.println("Please enter keyword: ");
                            scanner.nextLine();
                            String searchKeyword = scanner.nextLine();
                            List<Student> studentList = studentService.searchStudentData(searchKeyword);
                            System.out.println("Result: ");
                            if (studentList.isEmpty()){
                                System.out.println("Not found searched key in the student table");
                            }else{
                                Utility.getStudentList(studentList);
                            }
                            break;
                        default:
                            System.out.println("Invalid Method number!!!");
                            break;
                    }
                    break;
                case "lesson" :
                    switch (methodNumber){
                        case 1:
                            Utility.getLessonList(lessonService.getLessonList());
                            break;
                        case 2:
                            System.out.println("Enter Lesson Name: ");
                            scanner.nextLine();
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
                            Utility.getLessonList(lessonService.getLessonList());
                            System.out.println("Please enter the id of Lesson which want to update: ");
                            Long lessonId = scanner.nextLong();
                            Lesson ls = lessonService.getLessonById(lessonId);
                            if (ls == null) {
                                System.out.println("Not found the student!!!");
                            }else {
                                System.out.println("Old name: " + ls.getName());
                                System.out.println("Old time: " + ls.getTime());
                                System.out.println("Old price: " + ls.getPrice());

                                System.out.println("Enter new name: ");
                                scanner.nextLine();
                                lessonName = scanner.nextLine();
                                System.out.println("Enter new time: ");
                                lessonTime = scanner.nextInt();
                                System.out.println("Enter new price: ");
                                lessonPrice = scanner.nextDouble();

                                ls.setName(lessonName);
                                ls.setTime(lessonTime);
                                ls.setPrice(lessonPrice);

                                lessonService.updateLesson(ls);
                                System.out.println("Lesson has been successfully updated...");
                            }
                            break;
                        case 4:
                            Utility.getLessonList(lessonService.getLessonList());
                            System.out.println("Please enter id of lesson which you want to delete: ");
                            lessonId = scanner.nextLong();
                            lessonService.deleteLesson(lessonId);
                            System.out.println("Lesson has been successfully deleted...");
                            break;
                        case 5:
                            Utility.getLessonList(lessonService.getLessonList());
                            System.out.println("Please enter keyword: ");
                            scanner.nextLine();
                            String searchKeyword = scanner.nextLine();
                            List<Lesson> lessonList = lessonService.searchLessonData(searchKeyword);
                            System.out.println("Result: ");
                            if (lessonList.isEmpty()){
                                System.out.println("Not found searched key in the lesson table");
                            }else{
                                Utility.getLessonList(lessonList);
                            }
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
