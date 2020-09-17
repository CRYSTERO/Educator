package tom.entity.student;

import java.util.Date;

/**
 * 考试类
 */
public class Examination
{
    private String name;    //考试名称
    private Date date;  //考试日期
    private Double grade;   //考试成绩

    public Examination()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Double getGrade()
    {
        return grade;
    }

    public void setGrade(Double grade)
    {
        this.grade = grade;
    }
}
