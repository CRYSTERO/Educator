package tom.entity.student;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.common.Class;
import tom.entity.common.Notification;
import tom.entity.common.Personal_Info;
import tom.entity.common.User;

import java.util.List;

@Document(collection = "student")
public class Student extends User
{
    @MongoId
    private String id;

    private Educational_Info educationalInfo;
    private List<Class> classes;
    private List<Notification> notifications;
    private List<Examination> exams;

    public Student(){}

    public String getId()
    {
        return id;
    }

    public void setId()
    {
        this.id = getEducationalInfo().getId();
    }

    public Educational_Info getEducationalInfo()
    {
        return educationalInfo;
    }

    public void setEducationalInfo(Educational_Info educationalInfo)
    {
        this.educationalInfo = educationalInfo;
    }

    public List<Class> getClasses()
    {
        return classes;
    }

    public void setClasses(List<Class> classes)
    {
        this.classes = classes;
    }

    public List<Notification> getNotifications()
    {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications)
    {
        this.notifications = notifications;
    }

    public List<Examination> getExams()
    {
        return exams;
    }

    public void setExams(List<Examination> exams)
    {
        this.exams = exams;
    }

    public void setUsername()
    {
        super.setUsername(getEducationalInfo().getId());
    }

}
