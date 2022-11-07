package by.tms.dao;

import by.tms.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HibernateGroupsDao implements GroupsDao{

    private int point;
    SessionFactory sessionFactory;


    @Override
    public Group save(Group entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    public List<Group> getList() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Group", Group.class).getResultList();
    }

    @Override
    public Group findById(Long id) {
        Session session = sessionFactory.openSession();
        Group group = session.createQuery("from Group", Group.class).getSingleResult();
        return group;
    }

    @Transactional
    public Group findGroupByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Group un = session.createQuery("from Group where name = ?", Group.class)
                .setParameter("?", name).getSingleResult();
        return un;
    }
}
