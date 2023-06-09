package lv.ozo.mongo_db.entitiy;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "student")
public class Student {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field(name = "mail")
    private String email;

//    one to one mapping
    @DBRef
    private Department department;

//    one to many
    @DBRef (lazy = true)
    private List<Subject> subjects;


    @Transient
    private double precentable;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getPrecentable() {
        if (subjects != null && subjects.size() >0 ){
            int total =0;
            for(Subject subject: subjects){
                total+=subject.getMarksObtained();
            }
            return  total/subjects.size();
        }

        return 0.00;
    }

    public void setPrecentable(double precentable) {
        this.precentable = precentable;
    }
}


