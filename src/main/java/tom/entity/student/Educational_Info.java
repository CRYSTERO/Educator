package tom.entity.student;

import java.util.Date;

/**
 * 学生的学籍信息类
 */
public class Educational_Info
{
    private String Id;  //学生的学号
    private String school;  //学生所属的院系，为了方便这里先用字符串代替，后期用专用的类
    private String adminClass;  //学生所属的行政班级，为了方便这里先用字符串代替，后期用专用的类
    private Date enrollDate;    //学生的入学日期
    private Date graduateDate;  //学生的预计毕业日期
    private String remark;  //学生的评语
    private String email;   //学生的电子邮箱地址
    private String tel; //学生的电话号码

   public Educational_Info(){}

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getAdminClass()
    {
        return adminClass;
    }

    public void setAdminClass(String adminClass)
    {
        this.adminClass = adminClass;
    }

    public Date getEnrollDate()
    {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate)
    {
        this.enrollDate = enrollDate;
    }

    public Date getGraduateDate()
    {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate)
    {
        this.graduateDate = graduateDate;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getId()
    {
        return Id;
    }

    public void setId(String id)
    {
        Id = id;
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

    @Override
    public String toString()
    {
        return "Education_Info{" +
                "Id='" + Id + '\'' +
                ", school='" + school + '\'' +
                ", adminClass='" + adminClass + '\'' +
                ", enrollDate=" + enrollDate +
                ", graduateDate=" + graduateDate +
                '}';
    }
}
