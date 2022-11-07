package by.tms.dao;

import by.tms.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HibernateStudentDao implements StudentsDao {

    private SessionFactory sessionFactory;


    @Override
    public Student save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return student;
    }

    @Override
    public List<Student> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(Long id) {
            Session session3 = sessionFactory.openSession();
            Student student = session3.createQuery("from Student ", Student.class).getSingleResult();
            return student;
    }
}
