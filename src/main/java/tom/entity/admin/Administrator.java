package tom.entity.admin;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "administrator")
public class Administrator
{
    @MongoId
    private String id;

    private String name;
    private String password;

    public Administrator(){}
    public Administrator(String id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
