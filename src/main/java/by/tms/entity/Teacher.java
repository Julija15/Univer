package by.tms.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher extends AbstractUser {

    @OneToMany
    private List<Subject> subjects;
    @ManyToMany
    private List<Group> groups;

    public Teacher(String name, String username, String password, List<Subject> subjects, List<Group> groups) {
        super(name, username, password,Role.TEACHER);
        this.subjects = subjects;
        this.groups = groups;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Teacher() {
    }

    public void add(int point) {
    }
}
