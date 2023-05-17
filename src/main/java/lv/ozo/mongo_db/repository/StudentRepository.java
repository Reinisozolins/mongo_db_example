package lv.ozo.mongo_db.repository;

//import lv.ozo.mongo_db.entitiy.Student;
import lv.ozo.mongo_db.entitiy.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String departmentName);

    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String depId);


    @Query("{\"name\" : \"?0\"}")
    List<Student> methodForFindByName(String name);
}
