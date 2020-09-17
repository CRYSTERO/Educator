package tom.entity.faculty;

import tom.entity.common.Class;
import tom.entity.enums.JobTitle;

import java.util.Date;
import java.util.List;

public class Employment_Info
{
    private String id;
    private String school;
    private Date entryDate;
    private JobTitle title;
    private Class adminClass;
    private List<Class> TeachingClasses;
    private String email;
    private String tel;

    public Employment_Info(){}

    public String getSchool()
    {
        return this.school;
    }
    public void setSchool(String school)
    {
        this.school = school;
    }

    public Date getEntryDate()
    {
        return entryDate;
    }

    public void setEntryDate(Date entryDate)
    {
        this.entryDate = entryDate;
    }

    public JobTitle getTitle()
    {
        return title;
    }

    public void setTitle(JobTitle title)
    {
        this.title = title;
    }

    public Class getAdminClass()
    {
        return adminClass;
    }

    public void setAdminClass(Class adminClass)
    {
        this.adminClass = adminClass;
    }

    public List<Class> getTeachingClasses()
    {
        return TeachingClasses;
    }

    public void setTeachingClasses(List<Class> teachingClasses)
    {
        TeachingClasses = teachingClasses;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }
}
