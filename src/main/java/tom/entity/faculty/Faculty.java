package tom.entity.faculty;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import tom.entity.common.User;

@Document(collection = "Faculty")
public class Faculty extends User
{
    @MongoId
    private String id;

    private Employment_Info employmentInfo;

    public Faculty(){}


}
