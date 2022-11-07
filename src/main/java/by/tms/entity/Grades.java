package by.tms.entity;

import javax.persistence.*;

@Entity
public class Grades extends AbstractEntity{

    private int point;
    @OneToOne
    private Student student;
    @OneToOne
    private Subject subject;

    public Grades(int point, Student student, Subject subject) {
        this.point = point;
        this.student = student;
        this.subject = subject;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grades() {
    }
}
