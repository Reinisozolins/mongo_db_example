package lv.ozo.mongo_db.service;

//import lv.ozo.mongo_db.entitiy.Student;
//import lv.ozo.mongo_db.repository.StudentRepository;
import lv.ozo.mongo_db.entitiy.Student;
import lv.ozo.mongo_db.repository.DepartmentRepository;
import lv.ozo.mongo_db.repository.StudentRepository;
import lv.ozo.mongo_db.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;


    public Student createStudent(Student student){
        if (student.getDepartment() !=null){
            departmentRepository.save(student.getDepartment());
        }

        if (student.getSubjects() != null && student.getSubjects().size() >0 ){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentbyId(String id){
        return studentRepository.findById(id).get();
    }

    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }

    public  Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(String id){
        studentRepository.deleteById(id);
        return "Student has been deleted :))). ";
    }

    public List<Student> getStudentbyName(String name){
        return studentRepository.methodForFindByName(name);
    }

    public List<Student> studentsByNameAndEmail(String name, String email){
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> studentsByNameOrMail(String name, String email){
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public  List<Student>allWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
        return studentRepository.findAll(sort);
    }

    public List<Student>byDepartmentName(String departmentName){
        return  studentRepository.findByDepartmentDepartmentName(departmentName);

    }

    public List<Student>bySubjectName(String subName){
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student>emailLike(String email){
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student>nameStartWith(String name){
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student>byDepartmentId(String depId){
        return studentRepository.findByDepartmentId(depId);
    }


}



























