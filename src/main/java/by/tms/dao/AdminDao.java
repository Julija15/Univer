package by.tms.dao;

import by.tms.entity.*;

public interface AdminDao extends CrudDao<Admin, Long> {

    void updateTeacher(Teacher teacher);

    void updateTeacher(long teacherId, Teacher teacher);

    void updateStudent(Student student);

    void updateGroup(Group group);

    void updateSubject(Subject subject);

}
