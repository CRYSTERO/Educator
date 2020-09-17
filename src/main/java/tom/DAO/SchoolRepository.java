package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import tom.entity.common.AdminClass;
import tom.entity.common.School;

public interface SchoolRepository extends MongoRepository<School, String>
{
}
