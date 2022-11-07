package by.tms.service;

import by.tms.dao.SubjectDao;
import by.tms.entity.Subject;
import by.tms.entity.Teacher;
import jdk.internal.loader.AbstractClassLoaderValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class SubjectService {
    private SubjectDao subjectDao;

    public Subject save (Subject subject) {
        subjectDao.save(subject);
        return subject;
    }

    public Subject findById (long subjectId){
      return  subjectDao.findById(subjectId);
    }

    public List<Subject> getSubjectList(){
        return subjectDao.getList();
    }
}
