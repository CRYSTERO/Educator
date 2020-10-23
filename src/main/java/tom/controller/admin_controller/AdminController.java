package tom.controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import tom.entity.common.Class;
import tom.entity.enums.CertificateClass;
import tom.entity.enums.Gender;
import tom.entity.student.Student;
import tom.service.ClassService_Impl;
import tom.service.FacultyService_Impl;
import tom.service.StudentService_Impl;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    StudentService_Impl studentService;
    @Autowired
    FacultyService_Impl facultyService;
    @Autowired
    ClassService_Impl classService;

    @GetMapping("/add-stu")
    public String toAddStuPage()
    {
        return "admin/add-stu";
    }
//    @PostMapping("/add-stu")
//    public String addStudent(Student student)
//    {
//        System.out.println(student);
//        studentService.addStudent(student);
//        return "/index";
//    }

    @InitBinder
    public void myBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
                {
                    public void setAsText(String value)
                    {
                        try
                        {
                            setValue(new SimpleDateFormat("yyyy-MM-dd").parse(value));
                        }
                        catch (ParseException e)
                        {
                            setValue(null);
                        }
                    }
                });

        binder.registerCustomEditor(Gender.class, new PropertyEditorSupport()
        {
            public void setAsText(String value)
            {
                try {
                    setValue(Gender.parseGender(value));
                } catch(IllegalArgumentException e) {
                    setValue(Gender.MALE);
                }
            }
        });

        binder.registerCustomEditor(CertificateClass.class, new PropertyEditorSupport()
        {
            public void setAsText(String value)
            {
                try {
                    setValue(CertificateClass.parseCertificate(value));
                } catch(IllegalArgumentException e) {
                    setValue(CertificateClass.NATIONAL_ID_CARD);
                }
            }
        });
    }

    @GetMapping("/add-class")
    public String toAddClass(Model model)
    {
        model.addAttribute("class", new Class());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("students", studentService.getAllStudents());
        return "admin/add-class";
    }

    @PostMapping ("/add-class")
    public Class addClass(@ModelAttribute Class newClass)
    {
        return classService.addClass(newClass);
    }
}
