package com.mgms.dao.impl;

import com.mgms.dao.TimetableDao;
import com.mgms.model.Timetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimetableDaoImpl implements TimetableDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Timetable> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable", Timetable.class).list();
    }

    @Override
    public Timetable findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Timetable.class, id);
    }

    @Override
    public List<Timetable> findByClassId(Long classId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable t where t.classObj.id = :classId", Timetable.class)
                .setParameter("classId", classId)
                .list();
    }

    @Override
    public List<Timetable> findByTeacherId(Long teacherId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable t where t.teacher.id = :teacherId", Timetable.class)
                .setParameter("teacherId", teacherId)
                .list();
    }

    @Override
    public Timetable save(Timetable timetable) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(timetable);
        return timetable;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Timetable timetable = session.get(Timetable.class, id);
        if (timetable != null) {
            session.delete(timetable);
        }
    }
}