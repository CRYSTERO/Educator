package tom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tom.DAO.StudentRepository;
import tom.entity.student.Student;
import tom.util.MD5Utils;

import javax.servlet.http.HttpServletRequest;

@Service
public class StudentService_Impl implements I_StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Student checkIdentity(String username, String password)
    {
        return studentRepository.findByIdAndPassword(username, MD5Utils.stringToMD5(password));
    }

    @Override
    public boolean verifyEmail(String password, Student student)
    {
        if(student.getPassword().equals(password)) return true;
        else return false;
    }

    @Override
    public Student addStudent(Student newStudent)
    {
        System.out.println("successful");
        newStudent.setId();
        newStudent.setUsername();
        String CertId = newStudent.getPersonalInfo().getCertificate().getCertificateId();
        String oriPassword = MD5Utils.stringToMD5(CertId.substring(CertId.length() - 6));
        newStudent.setPassword(oriPassword);
        return studentRepository.save(newStudent);
    }

    @Override
    public void deleteStudent(String id)
    {
        System.out.println("successful");
        studentRepository.deleteById(id);
    }


}
