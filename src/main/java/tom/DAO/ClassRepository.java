package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tom.entity.common.Class;

@Repository
public interface ClassRepository extends MongoRepository<Class,String>
{
}
