package tom.entity.common;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;
import java.util.List;

/**
 * 班级类(非行政班级！)
 */

@Document(collection = "class")
public class Class
{
    @MongoId
    private String id;  //课程编号
    
    private String className;   //课程名称
    private Faculty teacher;    //教师
    private List<Student> students; //修学此课程的学生名单
    private String oriGrade;
    private String perfGrade;
    private String fiGrade;

    public Class(){}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public Faculty getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Faculty teacher)
    {
        this.teacher = teacher;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getOriGrade()
    {
        return oriGrade;
    }

    public void setOriGrade(String oriGrade)
    {
        this.oriGrade = oriGrade;
    }

    public String getPerfGrade()
    {
        return perfGrade;
    }

    public void setPerfGrade(String perfGrade)
    {
        this.perfGrade = perfGrade;
    }

    public String getFiGrade()
    {
        return fiGrade;
    }

    public void setFiGrade(String fiGrade)
    {
        this.fiGrade = fiGrade;
    }
}
