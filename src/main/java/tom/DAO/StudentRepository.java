package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tom.entity.student.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>
{
    Student findByIdAndPassword(String id, String password);
}
