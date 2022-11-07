package by.tms.dao;

import by.tms.entity.Grades;
import by.tms.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateGradeDao implements GradesDao {

    SessionFactory sessionFactory;

    @Override
    public Grades save(Grades entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    public List<Grades> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Grades", Grades.class).getResultList();
    }

    @Override
    public Grades findById(Long id) {
        Session session = sessionFactory.openSession();
        Group group = session.createQuery("from Group", Group.class).getSingleResult();
        return new Grades();
    }
}
