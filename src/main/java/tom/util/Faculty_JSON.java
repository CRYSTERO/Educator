package tom.util;

import com.alibaba.fastjson.JSON;
import tom.entity.common.Certificate;
import tom.entity.common.Class;
import tom.entity.common.Notification;
import tom.entity.common.Personal_Info;
import tom.entity.enums.CertificateClass;
import tom.entity.enums.Gender;
import tom.entity.enums.JobTitle;
import tom.entity.faculty.Employment_Info;
import tom.entity.faculty.Faculty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Faculty_JSON
{
    public static void main(String[] args) throws ParseException
    {
        Personal_Info personalInfo = new Personal_Info();
        Employment_Info employmentInfo = new Employment_Info();

        //Personal Info
        {
            personalInfo.setFamilyName("Liu");
            personalInfo.setGivenName("Quanjiin");
            personalInfo.setGender(Gender.MALE);
            personalInfo.setAge(50);
            Certificate certificate = new Certificate();
            {
                certificate.setCertificateClass(CertificateClass.NATIONAL_ID_CARD);
                certificate.setCertificateId("342601197201235514");
            }
            personalInfo.setCertificate(certificate);
            personalInfo.setBirthPlace("Tong Cheng County, An Hui Province");
            personalInfo.setPhoto("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1946079738,1531544959&fm=26&gp=0.jpg");
        }

        //Employment Info
        {
            employmentInfo.setId("181456096");
            employmentInfo.setTitle(JobTitle.PROFESSOR);
            employmentInfo.setAdminClass(null);
            employmentInfo.setSchool("EE");
            employmentInfo.setTel("18922163012");
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            Date date1;
            date1 = ft.parse("1985-10-01");
            employmentInfo.setEntryDate(date1);
            employmentInfo.setEmail("liuquanjin@aqnu.edu.com");
            List<Class> teachingClasses = new ArrayList<>();
            employmentInfo.setTeachingClasses(teachingClasses);
        }

        Faculty faculty = new Faculty();
        faculty.setNotifications(new ArrayList<Notification>());
        faculty.setPersonalInfo(personalInfo);
        faculty.setEmploymentInfo(employmentInfo);

        System.out.println(parser(faculty));
    }

    public static String parser(Faculty faculty)
    {
        return JSON.toJSONString(faculty);
    }
}
