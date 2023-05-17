package lv.ozo.mongo_db.repository;

import lv.ozo.mongo_db.entitiy.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
}
