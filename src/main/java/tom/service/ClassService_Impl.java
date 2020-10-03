package tom.service;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
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
                classmate.getClasses().add(newClass);
                mongoTemplate.save(classmate);
            }
        }
        return classRepository.save(newClass);
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

}