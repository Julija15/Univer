package by.tms.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Group extends AbstractEntity {
    private String name;
    @OneToMany
    private List<Student> students;
    @ManyToMany
    private List<Teacher> teachers;

    @ManyToMany
    private List<Subject> subjects;
    public Group() {
    }

    public Group(Group name, List<Student> students, List<Teacher> teachers, List<Subject> subjects) {
        this.name = String.valueOf(name);
        this.students = students;
        this.teachers = teachers;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(Group name) {
        this.name = String.valueOf(name);
    }

    public List<Student> getStudents(long studentId) {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }


}
