package tom.service;

import javax.servlet.http.HttpServletRequest;

public interface I_ResetService
{
    void sendMail(String sender,String receiver,String title,String text);

    boolean verifyURL(String sid, String account);
}
