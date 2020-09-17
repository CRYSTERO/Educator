package tom.controller.stu_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tom.entity.student.Student;
import tom.service.ResetService_Impl;
import tom.service.StudentService_Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stu")
public class StudentController
{
    @Autowired
    StudentService_Impl studentService;
    @Autowired
    ResetService_Impl resetService;

    //前往学生端主页
    @GetMapping("")
    public String dash()
    {
        return "student/dashboard";
    }

    //前往学籍信息页面，从session中拿到当前登录的学生然后调出对应的数据
    @GetMapping("/info")
    public String toInfo(HttpSession session)
    {
        session.getAttribute("student");
        return "student/info";
    }

    @GetMapping("/info-edit")
    public String editInfo()
    {
        return "student/info_modification";
    }

    @GetMapping("/password-reset")
    public String resetPassword()
    {
        return "student/password-reset";
    }

    @PostMapping("/safety-verify")
     public String verify(String password, HttpSession session,
                          HttpServletRequest request,
                          RedirectAttributes attributes)
    {
        Student student = (Student) session.getAttribute("student");
        boolean flag = studentService.verifyEmail(password,student);
        if (flag)
        {
            resetService.resetPassword(request,student.getEducationalInfo().getId());
            return "student/password-reset-wait";
        }
        else
        {
           attributes.addFlashAttribute("error","请检查密码是否输入正确！");
           return "redirect:/student/password-reset";
        }
    }
}
