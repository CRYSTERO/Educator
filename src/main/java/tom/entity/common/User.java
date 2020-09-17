package tom.entity.common;

/**
 * 用户类。基类，子类有学生类、教职工类与管理员类。主要含有用户的基本信息。
 */
public class User
{
    private Personal_Info personalInfo; //用户的个人基本信息
    private String username;    //用户账户的用户名
    private String password;    //用户账户的密码


    public Personal_Info getPersonalInfo()
    {
        return personalInfo;
    }

    public void setPersonalInfo(Personal_Info personalInfo)
    {
        this.personalInfo = personalInfo;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
