package tom.entity.common;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.enums.School_Table;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

@Document(collection = "school")
public class School
{
    @MongoId
    private String id;

    private School_Table schoolTable;
    private List<AdminClass> adminClasses;
//    private List<Faculty> faculties;
//    private  List<Student> students;

    public School(){}

    public School_Table getSchoolTable()
    {
        return schoolTable;
    }

    public void setSchoolTable(School_Table schoolTable)
    {
        this.schoolTable = schoolTable;
    }

    public List<AdminClass> getAdminClasses()
    {
        return adminClasses;
    }

    public void setAdminClasses(List<AdminClass> adminClasses)
    {
        this.adminClasses = adminClasses;
    }
}
