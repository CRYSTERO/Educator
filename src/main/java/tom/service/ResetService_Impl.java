package tom.service;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tom.DAO.ResetRepository;
import tom.DAO.StudentRepository;
import tom.entity.common.Reset;
import tom.entity.student.Student;
import tom.util.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@Service
public class ResetService_Impl implements I_ResetService
{
    @Autowired
    static ResetRepository resetRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public void resetPassword(HttpServletRequest request, String account)
    {
        String url = getPath(request, account);
        String sender = "安庆师范大学教务管理系统";
        String receiver = account;
        String title = "重置您的密码";
        String text = url;
        sendMail(sender,receiver,title,text);
    }

    public static String getPath(HttpServletRequest request, String account)
    {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        return getAffix(basePath,account);
    }
    public static String getAffix(String basePath, String account)
    {
        String result = "";
        Random rand = new Random();
        String key = String.valueOf(rand.nextInt(100001) + 100001);
        long expireMills = System.currentTimeMillis() + (long)(5*60*1000);
        Date expireTime = new Date(expireMills);
        String sid = account + "&" + key + "&" + expireTime;
        Reset ready = new Reset(account, MD5Utils.stringToMD5(sid),expireTime);
        Reset fromBase = resetRepository.findResetByAccount(account);
        if(fromBase != null)
        {
            resetRepository.delete(fromBase);
        }
        resetRepository.save(ready);
        result = basePath + "user/reset_password?sid=" + MD5Utils.stringToMD5(sid) + "&userName" + account;
        return result;
    }

    //用户根据邮件中的地址访问，审查是否存在
    @Override
    public boolean verifyURL(String sid, String account)
    {
        boolean result = false;
        Reset accountInfo = resetRepository.findResetByAccount(account);
        long expireTime = accountInfo.getExpireTime().getTime();
        long nowTime = System.currentTimeMillis();

        if(expireTime <= nowTime)
        {
            return false;
        }
        else if("".equals(sid))
        {
            return false;
        }
        else if (!sid.equals(accountInfo.getSid()))
        {
            return false;
        }
        return true;
    }

    @Override
    public void sendMail(String sender,String receiver,String title,String text)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setText(receiver);
        mailMessage.setSubject(title);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }

    public void resetConfirmed(String account, String newPassword)
    {
        MongoOperations operations = new MongoTemplate(new SimpleMongoClientDbFactory(MongoClients.create(), "Educator"));
        operations.updateFirst(query(where("_id").is(account)), update("password", newPassword), Student.class);
    }
}
