package lv.ozo.mongo_db.repository;

import lv.ozo.mongo_db.entitiy.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository  extends MongoRepository<Department, String> {
}
