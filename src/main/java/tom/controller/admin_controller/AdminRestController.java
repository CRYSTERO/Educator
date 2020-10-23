package tom.controller.admin_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tom.DAO.AdminRepository;
import tom.DAO.ClassRepository;
import tom.DAO.SchoolRepository;
import tom.entity.admin.Administrator;
import tom.entity.common.AdminClass;
import tom.entity.common.Class;
import tom.entity.common.School;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;
import tom.service.ClassService_Impl;
import tom.service.FacultyService_Impl;
import tom.service.StudentService_Impl;

@RestController
@RequestMapping("/admin")
public class AdminRestController
{
    @Autowired
    StudentService_Impl studentServiceImpl;
    @Autowired
    FacultyService_Impl facultyServiceImpl;
    @Autowired
    ClassService_Impl classServiceImpl;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    AdminRepository adminRepository;

    @DeleteMapping("/del-stu/{id}")
    public void deleteStudent(@PathVariable String id)
    {
        studentServiceImpl.deleteStudent(id);
    }

    @PostMapping("/add-stu")
    public Student addStudent(@RequestBody Student student)
    {
        System.out.println(student);
        return studentServiceImpl.addStudent(student);
    }
    @PostMapping("/add-stf")
    public Faculty addFaculty(@RequestBody Faculty faculty)
    {
        System.out.println(faculty);
        return facultyServiceImpl.addFaculty(faculty);
    }

//    @PostMapping("/add-class")
//    public void addClass(@RequestBody Class newClass)
//    {
//        classServiceImpl.addClass(newClass);
//    }

    @PostMapping("/addAdminClass")
    public void adminClass(@RequestBody AdminClass adminClass)
    {

    }

    @PostMapping("/addSchool")
    public void addSchool(@RequestBody School school)
    {
        schoolRepository.save(school);
    }

    @PostMapping("/addAdmin")
    public void addAdmin(@RequestBody Administrator administrator)
    {
        adminRepository.save(administrator);
    }
}
