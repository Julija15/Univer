package by.tms.dao;

import by.tms.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateSubjectDao implements SubjectDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Subject save(Subject entity) {
        return entity;
    }

    @Override
    public List<Subject> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Subject ", Subject.class).getResultList();
    }

    @Override
    public Subject findById(Long id) {
        Session session = sessionFactory.openSession();
        Subject subject = session.createQuery("from Subject ", Subject.class).getSingleResult();
        return subject;
    }

    @Override
    public void updateSubject(Subject subject) {
        Session session= sessionFactory.getCurrentSession();
        Subject subjectUpdate = session.createQuery("from Subject ", Subject.class).getSingleResult();
        subjectUpdate.update(subjectUpdate);
    }
}
