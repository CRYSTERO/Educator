package tom.entity.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reset")
public class Reset
{
    @Id
    private String id;

    private String account;
    private String sid;
    private Date expireTime;

    public Reset(String account, String sid, Date expireTime)
    {
        this.account = account;
        this.sid = sid;
        this.expireTime = expireTime;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getSid()
    {
        return sid;
    }

    public void setSid(String sid)
    {
        this.sid = sid;
    }

    public Date getExpireTime()
    {
        return expireTime;
    }

    public void setExpireTime(Date expireTime)
    {
        this.expireTime = expireTime;
    }
}
