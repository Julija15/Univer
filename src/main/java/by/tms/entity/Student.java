package by.tms.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Student extends AbstractUser{


    @OneToMany
    private List<Grades> grades;
    @ManyToOne
    private Group group;

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }

    public Teacher getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student(String name, String username, String password, Role role, List<Grades> grades, Group group) {
        super(name, username, password, role);
        this.grades = grades;
        this.group = group;
    }

    public Student(List<Grades> grades, Group group) {
        this.grades = grades;
        this.group = group;
    }

    public Student(String name, String username, String password, List<Grades> grades, Group group) {
        super(name, username, password,Role.STUDENT);
        this.grades = grades;
        this.group = group;
    }

    public Student() {
    }

}
