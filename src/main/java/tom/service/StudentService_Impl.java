package tom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import tom.DAO.StudentRepository;
import tom.entity.common.Grade;
import tom.entity.student.Student;
import tom.util.MD5Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class StudentService_Impl implements I_StudentService
{
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Student findOneStudentById(String studentId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(studentId));
		return mongoTemplate.findOne(query, Student.class);
	}

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
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(String id)
	{
		studentRepository.deleteById(id);
	}

	@Override
	public void setFinalGrade(Grade grade, String classId, String studentId)
	{
		Student student = findOneStudentById(studentId);
		student.getClasses().get(classId).setGrade(grade);
	}
}
