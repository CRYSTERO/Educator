package tom.controller.faculty_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tom.DAO.StudentRepository;
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
    StudentRepository studentRepository;

    @GetMapping("/allclasses")
    public String toClassList(Model model, HttpSession session)
    {
        model.addAttribute("faculty", (Faculty)session.getAttribute("faculty"));
        return "/faculty/classlist";
    }

    @GetMapping("/uploadgrade/{classId}")
    public String toUpLoadGrade(@PathVariable String classId, Model model)
    {
        List<Student> allStudentsInTheClass = classService.findAllStudentsInTheClass(classId);
        model.addAttribute("studentsList", allStudentsInTheClass);
        model.addAttribute("classId", classId);
        return "/faculty/studentlist";
    }

//    @GetMapping("/setgrade/{studentId}")
//    public String toSetGrade(@PathVariable String studentId, Model model)
//    {
//        model.addAttribute("student", studentRepository.findById(studentId));
//        return "/faculty/setgrade";
//    }
}


@RestController
@RequestMapping("/faculty")
class FacultyRestController
{
    @Autowired
    ClassService_Impl classService;

    @PostMapping("/calculateGrade")
    @ResponseBody
    public String calculateGrade(@RequestBody String str)
    {
        String[] grades = str.substring(0, str.length()-1).split("\\+");
        for(String grade : grades) System.out.println(grade);
        return classService.getFinalGrade(grades[0], grades[1], grades[2]);
//        String[] grades = str.split(" ");
//        return classService.getFinalGrade(grades[0], grades[1], grades[2]);
    }
}
