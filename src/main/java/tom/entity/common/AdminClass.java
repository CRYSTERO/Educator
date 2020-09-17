package tom.entity.common;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

@Document(collection = "adminClass")
public class AdminClass
{
    @MongoId
    private String Id;

    private String adminClassName;
    private Faculty counselor;
    private School school;
    private List<Student> studentList;

    public AdminClass(){}

    public String getAdminClassName()
    {
        return adminClassName;
    }

    public void setAdminClassName(String adminClassName)
    {
        this.adminClassName = adminClassName;
    }

    public Faculty getCounselor()
    {
        return counselor;
    }

    public void setCounselor(Faculty counselor)
    {
        this.counselor = counselor;
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }

    public void setStudentList(List<Student> studentList)
    {
        this.studentList = studentList;
    }

    public School getSchool()
    {
        return school;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }
}
