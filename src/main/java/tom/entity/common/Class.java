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

    public Class(){}

    public String getName()
    {
        return className;
    }

    public void setName(String className)
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
}
