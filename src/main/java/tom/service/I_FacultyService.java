package tom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tom.entity.common.Class;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

public interface I_FacultyService
{
    //增加教职工
    Faculty addFaculty(Faculty faculty);

    //获得全部的教职工
    List<Faculty> getAllFaculties();

    //登录时检查通行证
    Faculty checkIdentity(String id, String password);
}
