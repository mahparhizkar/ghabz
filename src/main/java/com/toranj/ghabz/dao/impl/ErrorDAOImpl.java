package com.toranj.ghabz.dao.impl;

import com.toranj.ghabz.dao.ErrorDAO;
import com.toranj.ghabz.entity.Error;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(noRollbackFor = Throwable.class , propagation = Propagation.REQUIRES_NEW)
@Component("errorDAO")
public class ErrorDAOImpl implements ErrorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Error error) {
        try{
            this.sessionFactory.getCurrentSession().persist(error);
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
    }

    @Override
    public Error findBylId(String id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Error.class);
            criteria.add(Restrictions.eq("id", id));
            return (Error) criteria.uniqueResult();
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage() + " happened!");
            e.printStackTrace();
        }
        return null;
    }
    }

