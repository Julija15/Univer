package by.tms.dao;

import by.tms.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateTeacherDao implements TeacherDao {

    private SessionFactory sessionFactory;

    @Override
    public Teacher save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Teacher ", Teacher.class).getResultList();
    }

    @Override
    public Teacher findById(Long id) {
        Session session = sessionFactory.openSession();
        Teacher teacher = session.createQuery("from Teacher ", Teacher.class).getSingleResult();
        return teacher;
    }

    public List<Teacher> findByUsername(String username) {
        return findByUsername(username);
    }

}
