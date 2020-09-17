package tom.service;

import org.springframework.stereotype.Service;
import tom.entity.student.Student;

@Service
public interface I_StudentService
{
    Student checkIdentity(String username, String password);

    Student addStudent(Student newStudent);

    void deleteStudent(String id);

    boolean verifyEmail(String password, Student student);


}
