package tom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tom.entity.common.User;
import tom.entity.student.Student;
import tom.service.StudentService_Impl;
import tom.util.MD5Utils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController
{
    @Autowired
    StudentService_Impl studentService;

    @PostMapping("/login")
    public String login(@RequestParam("identity") String identity,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Map<String,Object> map)
    {
        switch (identity)
        {
            case "1" :
            {
                Student student = studentService.checkIdentity(username, password);
                if(student != null)
                {
                    System.out.println("登陆成功！！！");
                    student.setPassword(null);
                    //session中加入 当前登录的学生 的属性
                    session.setAttribute("student",student);
                    return "/student/dashboard";
                }
                else
                {
                    map.put("message","用户名或密码有误！如果您遗忘了密码，请与管理员联系！");
                    System.out.println("登录失败！！！");
                     return "index";
                }
            }
            case "2" :
            {

            }
            default:
            {
            }
        }
        return null;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        System.out.println("注销成功！！！");
        session.removeAttribute("student");
        return "index";
    }
}
