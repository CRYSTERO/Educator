package tom.entity.faculty;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.common.Notification;
import tom.entity.common.User;

import java.util.List;

@Document(collection = "faculty")
public class Faculty extends User
{
    @MongoId
    private String id;

    private Employment_Info employmentInfo;

    private List<Notification> notifications;

    public Faculty(){}

    public String getId()
    {
        return id;
    }

    public void setId()
    {
        this.id = employmentInfo.getId();
    }

    public Employment_Info getEmploymentInfo()
    {
        return employmentInfo;
    }

    public void setEmploymentInfo(Employment_Info employmentInfo)
    {
        this.employmentInfo = employmentInfo;
    }

    public List<Notification> getNotifications()
    {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications)
    {
        this.notifications = notifications;
    }

    public void setUsername()
    {
        super.setUsername(getEmploymentInfo().getId());
    }

}
