package tom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tom.entity.common.AdminClass;
import tom.entity.common.Class;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

public interface I_ClassService
{
    //增加班级
    Class addClass(Class newClass);

    //删除班级
    void deleteClass(String id);

    //增加行政班级
    AdminClass addAdminClass(AdminClass newAdminClass);

    //删除行政班级
    void deleteAdminClass(String id);

    //获取课程最终成绩
    String getFinalGrade(String oriGrade, String perfGrade);

    String getFinalGrade(String oriGrade, String perfGrade, String experGrade);

    //获取某个课程的所有学生
    List<Student> findAllStudentsInTheClass(String classId);
}
