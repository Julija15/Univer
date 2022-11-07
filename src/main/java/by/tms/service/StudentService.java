package by.tms.service;

import by.tms.dao.StudentsDao;
import by.tms.entity.Student;
import by.tms.entity.Subject;
import by.tms.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentsDao studentsDao;

    @Transactional
    public Student saveStudent(Student student){
        studentsDao.save(student);
        return student;
    }

    @Transactional
    public List<Student> getStudentList(){
        return studentsDao.getList();
    }

    @Transactional
    public Student findById(long studentId) {
        return studentsDao.findById(studentId);
    }


}
