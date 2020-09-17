package tom.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tom.entity.common.Reset;

@Repository
public interface ResetRepository extends MongoRepository<Reset, String>
{
    Reset findResetByAccount(String account);
}
