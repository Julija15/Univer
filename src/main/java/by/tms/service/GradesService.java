package by.tms.service;

import by.tms.dao.GradesDao;
import by.tms.entity.Grades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GradesService {

    @Autowired
    @Qualifier("hibernateGradeDao")
    private GradesDao gradesDao;

    public List<Grades> getAll(){
        return gradesDao.getList();
    }

    @Transactional
    public Grades findById(long gradesId) {
        return gradesDao.findById(gradesId);
    }

    @Transactional
    public Grades save(Grades grades){
        gradesDao.save(grades);
        return grades;
    }

}
