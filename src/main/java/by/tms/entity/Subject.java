package by.tms.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Subject extends AbstractEntity{

   @OneToOne
   private Teacher teacher;

   private String name;

   public Subject(Teacher teacher, String name) {
      this.teacher = teacher;
      this.name = name;
   }

   public Teacher getTeacher() {
      return teacher;
   }

   public void setTeacher(Teacher teacher) {
      this.teacher = teacher;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Subject() {
   }

   public void update(Subject subjectUpdate) {
   }
}
