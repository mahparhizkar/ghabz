package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.NaturalPersonDAO;
import com.toranj.ghabz.entity.NaturalPerson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Component("naturalPersonDAO")
public class NaturalPersonDAOImpl implements NaturalPersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(NaturalPerson naturalPerson) {
        try {
            naturalPerson.setCreationDate(new Date());
            this.sessionFactory.getCurrentSession().persist(naturalPerson);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrUpdate(NaturalPerson naturalPerson) {
        try {
            naturalPerson.setCreationDate(new Date());
            this.sessionFactory.getCurrentSession().saveOrUpdate(naturalPerson);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public NaturalPerson findByNationalId(String nationalId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(NaturalPerson.class);
            criteria.add(Restrictions.eq("nationalId", nationalId));
            return (NaturalPerson) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void UpdateInfo(NaturalPerson naturalPerson) {
        try {
            this.sessionFactory.getCurrentSession().merge(naturalPerson);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public NaturalPerson findByMobile(String mobile) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(NaturalPerson.class);
            criteria.add(Restrictions.eq("mobileNumber", mobile));
            return (NaturalPerson) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NaturalPerson findById(String id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(NaturalPerson.class);
            criteria.add(Restrictions.eq("id", id));
            return (NaturalPerson) criteria.uniqueResult();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }
}
