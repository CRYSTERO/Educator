package tom.service;

import tom.entity.student.Student;

import java.util.List;

public interface I_StudentService
{
    Student checkIdentity(String username, String password);

    Student addStudent(Student newStudent);

    List<Student> getAllStudents();

    void deleteStudent(String id);

    boolean verifyEmail(String password, Student student);


}
