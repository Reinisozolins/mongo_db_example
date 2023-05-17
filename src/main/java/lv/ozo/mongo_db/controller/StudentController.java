package lv.ozo.mongo_db.controller;

//import lv.ozo.mongo_db.entitiy.Student;
//import lv.ozo.mongo_db.service.StudentService;
import lv.ozo.mongo_db.entitiy.Student;
import lv.ozo.mongo_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;
//
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentbyId(@PathVariable String id) {
        return studentService.getStudentbyId(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> studentByName(@PathVariable String name){
        return studentService.getStudentbyName(name);
    }


    @GetMapping("/studentByNameAndMail")
    public List<Student> studentBNameAndEmail(@RequestParam String name, @RequestParam String email){
        return  studentService.studentsByNameAndEmail(name, email);
    }

    @GetMapping("/studentsByNameOrMail")
    public List<Student> studentsByNameOrMail(@RequestParam String name , @RequestParam String email){
        return  studentService.studentsByNameOrMail(name, email);
    }

    @GetMapping("/allWithPagination")
    public List<Student> allWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> allWithSorting(){
        return studentService.allWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName (@RequestParam String departmentName){
        return studentService.byDepartmentName(departmentName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName){
        return  studentService.bySubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email){
        return studentService.emailLike(email);
    }

    @GetMapping("/nameStartWith")
    public List<Student> nameStartWith(@RequestParam String name){
        return studentService.nameStartWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String depId){
        return  studentService.byDepartmentId(depId);
    }

}








































