package by.tms.service;

import by.tms.dao.*;
import by.tms.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {


    private AdminDao adminDao;
    private Student student;


    public Admin save(Admin admin) {
        adminDao.save(admin);
        return admin;
    }

    public Admin findByName(String name) {
        return findByName(name);
    }


    public void updateTeacher(Teacher teacher) {
        adminDao.updateTeacher(teacher);
    }

    public Admin findById(Long id){
        return   adminDao.findById(id);
    }

    public void addStudent(Student student) {
        adminDao.updateStudent(student);
    }

    public void addGroup(Group group) {
        adminDao.updateGroup(group);
    }

    public void addSubject(Subject subject) {
        adminDao.updateSubject(subject);
    }

    public String addGroupName(String name, long groupId) {
        adminDao.findById(groupId).getName();
        return adminDao.findById(groupId).getName();
    }

    public void addStudentAtGroup(Student student) {
        List<Subject> subjects = student.getGroup().getSubjects();
        List<Long> teacherIds = new ArrayList<>();
        for (Subject subject : subjects) {
            Teacher teacher = subject.getTeacher();
            if (!teacherIds.contains(teacher.getId())) {
                teacherIds.add(teacher.getId());
            }
        }
        for (Long teacherId : teacherIds) {
            adminDao.updateTeacher(teacherId, student.getGroup());
        }
    }
}