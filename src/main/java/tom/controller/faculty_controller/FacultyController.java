package tom.controller.faculty_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tom.DAO.StudentRepository;
import tom.entity.common.Grade;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;
import tom.service.ClassService_Impl;
import tom.service.StudentService_Impl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/faculty")
public class FacultyController
{
    @Autowired
    ClassService_Impl classService;
    @Autowired
    StudentService_Impl studentService;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/allclasses")
    public String toClassList(Model model, HttpSession session)
    {
        model.addAttribute("faculty", (Faculty)session.getAttribute("faculty"));
        return "/faculty/classlist";
    }

    //到某个班级的学生列表
    @GetMapping("/studentlist/{classId}")
    public String toUpLoadGrade(@PathVariable String classId, Model model)
    {
        List<Student> allStudentsInTheClass = classService.findAllStudentsInTheClass(classId);
        model.addAttribute("studentsList", allStudentsInTheClass);
        model.addAttribute("classId", classId);
        return "/faculty/studentlist";
    }

    //这个Get，跳转到某个学生的成绩上传页面
    @GetMapping("/uploadgrade/{classId}/{studentId}")
    public String toSetGrade(@PathVariable String studentId, @PathVariable String classId, Model model)
    {
        model.addAttribute("student", studentService.findOneStudentById(studentId));
//        这里不加classID可以吗
        model.addAttribute("classId", classId);
        return "/faculty/setgrade";
    }

    //这个Post，提交成绩表单
    @PostMapping("/setgrade/{classId}/{studentId}")
    public String setGrade(@PathVariable String studentId, @PathVariable String classId, Grade grade)
    {
        studentService.setFinalGrade(grade, classId, studentId);
        return "/faculty/studentlist";
    }
}


@RestController
@RequestMapping("/faculty")
class FacultyRestController
{
    @Autowired
    ClassService_Impl classService;

    //AJAX请求，返回计算的结果
    @PostMapping("/calculateGrade")
    @ResponseBody
    public String calculateGrade(@RequestBody String str)
    {
        String[] grades = str.substring(0, str.length()-1).split("\\+");
        return classService.getFinalGrade(grades[0], grades[1], grades[2]);
    }
}
