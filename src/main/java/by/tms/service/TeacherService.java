package by.tms.service;

import by.tms.dao.TeacherDao;
import by.tms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

@Service
public class TeacherService {


    @Autowired
    private TeacherDao teacherDao;



    @Transactional
    public Teacher saveTeacher (Teacher teacher){
        teacherDao.save(teacher);
        return teacher;
    }

    @Transactional
    public List<Teacher> getTeacherList(){
        return teacherDao.getList();
    }

    @Transactional
    public Teacher findByUsername(String username){
        return findByUsername(username);
    }

    @Transactional
    public Teacher addGradesToStudent (long studentId, int point){
        teacherDao.findById(studentId).add(point);
        return addGradesToStudent(studentId,point);
    }

    @Transactional
    public Teacher findById(Long id){
        return findById(id);
    }
}
