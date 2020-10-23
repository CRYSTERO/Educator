package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import tom.entity.admin.Administrator;

public interface AdminRepository extends MongoRepository<Administrator, String>
{
    Administrator findByIdAndPassword(String id, String password);
}
