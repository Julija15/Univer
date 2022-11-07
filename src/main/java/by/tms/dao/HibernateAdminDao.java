package by.tms.dao;

import by.tms.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateAdminDao implements AdminDao {

    SessionFactory sessionFactory;


    @Override
    public void updateTeacher(Teacher teacher) {

    }

    @Override
    public void updateTeacher(long teacherId, Teacher teacher) {
        Session session = sessionFactory.openSession();
        Teacher updateTeacher = session.createQuery("from Teacher where id = :un", Teacher.class)
                .setParameter("un", teacher).getSingleResult();
       session.saveOrUpdate(updateTeacher);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student updateStudent = session.createQuery("from Student where id = :un", Student.class)
                .setParameter("un", student).getSingleResult();
        session.saveOrUpdate(updateStudent);
    }

    @Override
    public void updateGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        Student updateGroup = session.createQuery("from Group where id = :un", Student.class)
                .setParameter("un", group).getSingleResult();
        session.saveOrUpdate(updateGroup);
    }

    @Override
    public void updateSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        Student updateSubject = session.createQuery("from Subject where id = :un", Student.class)
                .setParameter("un", subject).getSingleResult();
        session.update(updateSubject);
    }


    @Override
    public Admin save(Admin entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    public List<Admin> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Admin ", Admin.class).getResultList();
    }

    @Override
    public Admin findById(Long id) {
        Session session = sessionFactory.openSession();
        Admin admin = session.createQuery("from Admin ", Admin.class).getSingleResult();
        return admin;
    }

}
