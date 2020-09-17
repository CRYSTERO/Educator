package tom.util;

import com.alibaba.fastjson.JSON;
import tom.entity.common.*;
import tom.entity.common.Class;
import tom.entity.enums.CertificateClass;
import tom.entity.enums.Gender;
import tom.entity.enums.School_Table;
import tom.entity.faculty.Faculty;
import tom.entity.student.Educational_Info;
import tom.entity.student.Examination;
import tom.entity.student.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSON_Translator
{
    public static void main(String[] args) throws ParseException
    {

//       Certificate certificate = new Certificate();
//        {
//            certificate.setCertificateClass(CertificateClass.NATIONAL_ID_CARD);
//            certificate.setCertificateId("5011248557");
//        }
//       Educational_Info educationalInfo = new Educational_Info();
//        {
//            educationalInfo.setId("080218059");
//            educationalInfo.setAdminClass("EE1802");
//
//                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
//                Date date1;
//                date1 = ft.parse("2018-09-07");
//                Date date2;
//                date2 = ft.parse("2022-06-15");
//
//            educationalInfo.setEnrollDate(date1);
//            educationalInfo.setGraduateDate(date2);
//            educationalInfo.setRemark("Very good student!");
//            educationalInfo.setSchool("EE");
//            educationalInfo.setEmail("1409678189@qq.com");
//            educationalInfo.setTel("15123662521");
//        }
//       Faculty faculty = new Faculty();
//        Class aClass = new Class();
//        {
//            aClass.setName("English");
//            aClass.setTeacher(faculty);
//            aClass.setStudents(new ArrayList<Student>());
//        }
//       Examination examination = new Examination();
//       Notification notification = new Notification();
//       List<Class> classes = new ArrayList<>();
//        {
//            classes.add(aClass);
//        }
//       List<Notification> notifications = new ArrayList<>();
//        {
//            notifications.add(notification);
//        }
//       List<Examination> exams = new ArrayList<>();
//        {
//            exams.add(examination);
//        }
//
//        Personal_Info personalInfo = new Personal_Info();
//        {
//            personalInfo.setAge(20);
//            personalInfo.setBirthPlace("Chaohu, Anhui");
//            personalInfo.setFamilyName("Lee");
//            personalInfo.setGivenName("Xudong");
//            personalInfo.setCertificate(certificate);
//            personalInfo.setGender(Gender.MALE);
//            personalInfo.setPhoto("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1946079738,1531544959&fm=26&gp=0.jpg");
//        }
//        Student student = new Student();
//        {
//            student.setPersonalInfo(personalInfo);
//            student.setEducationalInfo(educationalInfo);
//            student.setUsername();
//            student.setId();
//            student.setPassword("222222");
//            student.setExams(exams);
//
//        }
//        System.out.println(student.getUsername());
//        System.out.println(getJSON(student));
        AdminClass adminClass = new AdminClass();
        ArrayList<AdminClass> adminClasses = new ArrayList<>();
        adminClasses.add(adminClass);
        School school = new School();
        school.setAdminClasses(adminClasses );
        school.setSchoolTable(School_Table.Computer_Science);
        System.out.println(getJSON(school));
    }

    public static String getJSON(School school)
    {
        return JSON.toJSONString(school);
    }
}
