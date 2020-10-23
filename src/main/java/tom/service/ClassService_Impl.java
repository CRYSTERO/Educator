package tom.service;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import tom.DAO.ClassRepository;
import tom.entity.common.AdminClass;
import tom.entity.common.Class;
import tom.entity.faculty.Faculty;
import tom.entity.student.Student;

import java.util.List;

@Service
public class ClassService_Impl implements I_ClassService
{
    @Autowired
    ClassRepository classRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Class addClass(Class newClass)
    {
        //将新课相应的教师文档中新增这门课
        Query fquery = new Query();
        fquery.addCriteria(Criteria.where("_id").is(newClass.getTeacher().getId()));
        Faculty teacher = mongoTemplate.findOne(fquery, Faculty.class);
        if(teacher != null)
        {
            List<Class> teachingClasses = teacher.getEmploymentInfo().getTeachingClasses();
            teachingClasses.add(newClass);
            mongoTemplate.save(teacher);
        }

        //将参加这门课的每个学生的课表更新
        for(Student student : newClass.getStudents())
        {
            Query squery = new Query();
            squery.addCriteria(Criteria.where("_id").is(student.getId()));
            Student classmate = mongoTemplate.findOne(squery, Student.class);
            if(classmate != null)
            {
                classmate.getClasses().put(newClass.getId(), newClass);
                mongoTemplate.save(classmate);
            }
        }
        return classRepository.save(newClass);
    }

    //计算课程总分。后期可以增加实验成绩选项，教师也可自行选择不同的成绩算法。
    @Override
    public String getFinalGrade(String oriGrade, String perfGrade)
    {
        return String.valueOf(Integer.parseInt(oriGrade) * 0.7 + Integer.parseInt(perfGrade) * 0.3);
    }

    @Override
    public String getFinalGrade(String oriGrade, String perfGrade, String experGrade)
    {
        return String.valueOf(Integer.parseInt(oriGrade) * 0.6 + Integer.parseInt(perfGrade) * 0.2 + Integer.parseInt(experGrade) * 0.2) ;
    }

    @Override
    public void deleteClass(String id)
    {

    }

    @Override
    public AdminClass addAdminClass(AdminClass newAdminClass)
    {
        return null;
    }

    @Override
    public void deleteAdminClass(String id)
    {

    }

    @Override
    public List<Student> findAllStudentsInTheClass(String classId)
    {
        return classRepository.findClassById(classId).getStudents();
    }
}
