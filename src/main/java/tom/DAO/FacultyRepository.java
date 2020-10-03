package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import tom.entity.faculty.Faculty;

public interface FacultyRepository extends MongoRepository<Faculty, String>
{
    Faculty findByIdAndPassword(String id, String password);

}
