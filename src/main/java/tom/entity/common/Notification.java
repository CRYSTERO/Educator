package tom.entity.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.Date;
import java.util.List;

@Document(collection = "notification")
public class Notification
{
    @Id
    private Long id;

    private String title;
    private Date date;
    private String content;
    private Boolean urgent;
    private Faculty publisher;
    private List<Student> alreadyRead;

    public Notification()
    {
    }
}
