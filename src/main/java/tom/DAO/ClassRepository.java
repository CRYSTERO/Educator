package tom.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tom.entity.common.Class;
import tom.entity.faculty.Faculty;

import java.util.List;

@Repository
public interface ClassRepository extends MongoRepository<Class,String>
{
    Class findClassById(String classId);
}
