package tom.controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tom.DAO.ClassRepository;
import tom.DAO.SchoolRepository;
import tom.entity.common.AdminClass;
import tom.entity.common.Class;
import tom.entity.common.School;
import tom.service.StudentService_Impl;

@RestController
@RequestMapping("/admin")
public class AdminRestController
{
    @Autowired
    StudentService_Impl studentServiceImpl;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    SchoolRepository schoolRepository;

    @DeleteMapping("/del-stu/{id}")
    public void deleteStudent(@PathVariable String id)
    {
        studentServiceImpl.deleteStudent(id);
    }

//    @PostMapping("/add-stu")
//    public Student addStudent(@RequestBody Student student)
//    {
//        System.out.println(student);
//        return studentServiceImpl.addStudent(student);
//    }

    @PostMapping("/add-class")
    public Class addClass(@RequestBody Class aClass)
    {
        return classRepository.save(aClass);
    }

    @PostMapping("/addAdminClass")
    public void adminClass(@RequestBody AdminClass adminClass)
    {

    }

    @PostMapping("/addSchool")
    public void addSchool(@RequestBody School school)
    {
        schoolRepository.save(school);
    }
}
