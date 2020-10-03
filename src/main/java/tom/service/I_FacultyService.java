package tom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

@Service
public interface I_FacultyService
{
    Faculty addFaculty(Faculty faculty);

    List<Faculty> getAllFaculties();

    Faculty checkIdentity(String id, String password);
}
