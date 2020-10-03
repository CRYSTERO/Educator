package tom.util;

import com.alibaba.fastjson.JSON;
import tom.entity.common.Certificate;
import tom.entity.common.Class;
import tom.entity.common.Notification;
import tom.entity.common.Personal_Info;
import tom.entity.enums.CertificateClass;
import tom.entity.enums.Gender;
import tom.entity.faculty.Faculty;
import tom.entity.student.Educational_Info;
import tom.entity.student.Examination;
import tom.entity.student.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student_JSON
{
    public static void main(String[] args) throws ParseException
    {
        Personal_Info personalInfo = new Personal_Info();
        Educational_Info educationalInfo = new Educational_Info();

        //Personal Info
        {
            personalInfo.setFamilyName("Sun");
            personalInfo.setGivenName("Wei");
            personalInfo.setGender(Gender.FEMALE);
            personalInfo.setAge(19);
            Certificate certificate = new Certificate();
            {
                certificate.setCertificateClass(CertificateClass.NATIONAL_ID_CARD);
                certificate.setCertificateId("1524887956482");
            }
            personalInfo.setCertificate(certificate);
            personalInfo.setBirthPlace("Fu Yang City, An Hui Province");
            personalInfo.setPhoto("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1946079738,1531544959&fm=26&gp=0.jpg");
        }

        //Educational Info
        {
            educationalInfo.setId("080218056");
            educationalInfo.setAdminClass("EE1802");
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                Date date1;
                date1 = ft.parse("2018-09-07");
                Date date2;
                date2 = ft.parse("2022-06-15");
            educationalInfo.setEnrollDate(date1);
            educationalInfo.setGraduateDate(date2);
            educationalInfo.setSchool("EE");
            educationalInfo.setRemark("Nicce student!!");
            educationalInfo.setEmail("sunwei@qq.com");
            educationalInfo.setTel("13955641221");
        }

        List<Class> classes = new ArrayList<>();
        List<Notification> notifications = new ArrayList<>();
        List<Examination> exams = new ArrayList<>();

        //Student
        Student student = new Student();
        {
            student.setPersonalInfo(personalInfo);
            student.setEducationalInfo(educationalInfo);
            student.setExams(exams);
            student.setClasses(classes);
            student.setNotifications(notifications);
            student.setUsername();
            student.setId();
        }

        System.out.println(getJSON(student));
    }

    public static String getJSON(Student student)
    {
        return JSON.toJSONString(student);
    }
}
