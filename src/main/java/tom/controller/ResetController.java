package tom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tom.service.ResetService_Impl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class ResetController
{
    @Autowired
    ResetService_Impl resetService;

    @GetMapping("/reset-password")
    public String reset(String sid, String account, HttpSession session)
    {
        String sids = sid;
        String s = sids.replace(" ","+");
        session.setAttribute("account",account);
        //检查用户输入的连接是否是发给他的连接
        boolean isValid = resetService.verifyURL(s,account);
        if(!isValid)
        {
            return "error/404";
        }
        else
        {
            return "student/password-reset-main";
        }
    }

    @PostMapping("/reset-password-confirmed")
    public String resetConfirmed(String newPassword, HttpSession session)
    {
        String account = (String) session.getAttribute("account");
        resetService.resetConfirmed(account,newPassword);
        return "index";
    }
}
